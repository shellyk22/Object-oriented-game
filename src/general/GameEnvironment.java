//ID: 326705829.
//Shelly Koretsky
package general;
import collisions.Collidable;
import collisions.CollisionInfo;
import geometry.Point;
import geometry.Line;
import java.util.ArrayList;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-23
 * constructs, sets gets and handles a GameEnvironment object.
 */
public class GameEnvironment {
    //fields
    private ArrayList<Collidable> collidableObjectsInGame = new ArrayList<>();

    /**
     * construstd a GameEnvironment with list of collidables.
     *
     * @param collidablesList is the list of collidables in the game.
     */
    //constructor
    public GameEnvironment(ArrayList<Collidable> collidablesList) {
        this.collidableObjectsInGame = collidablesList;
    }
    /**
     * Add the given collidable to the environment.
     * @param c the Collidable we add to our list of collidables.
     */
    // add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        collidableObjectsInGame.add(c);
    }
    /**
     * Gets the list array of Collidables (our game environment).
     * @return collidableObjectsInGame list array of Collidables.
     */
    //getter
    public ArrayList<Collidable> getGameEnv() {
        return this.collidableObjectsInGame;
    }
    /**
     * Assume an object moving from trajectory.start() to trajectory.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory the given line.
     * @return the information of collision(if collision occurred, else return null.
     */
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {

        ArrayList<Integer> interactionIndexes = new ArrayList<>();
        ArrayList<Point> interactionPoins = new ArrayList<>();

        for (int i = 0; i < this.collidableObjectsInGame.size(); i++) { //checks if there are any collisions

            if (trajectory.closestIntersectionToStartOfLine(collidableObjectsInGame.
                    get(i).getCollisionRectangle()) != null) {
                interactionIndexes.add(i);

                interactionPoins.add(trajectory.closestIntersectionToStartOfLine(collidableObjectsInGame.
                        get(i).getCollisionRectangle()));
            }
        }
        if (interactionIndexes.isEmpty()) {
            return null;
        } else {
            Point tempInteractionPoint = new Point(interactionPoins.get(0).getX(),
                    interactionPoins.get(0).getY());

            int tempCount = 0;
            for (int i = 1; i < interactionPoins.size(); i++) {
                Point currentIneractionPoint = new Point(interactionPoins.get(i).getX(),
                        interactionPoins.get(i).getY());
                    if (trajectory.start().distance(currentIneractionPoint)
                            < trajectory.start().distance(tempInteractionPoint)) {
                        tempInteractionPoint = currentIneractionPoint;
                        tempCount = i;
                    }
            }
            CollisionInfo infoOfCol = new CollisionInfo(tempInteractionPoint,
                    collidableObjectsInGame.get(interactionIndexes.get(tempCount)));
            return infoOfCol;
        }
    }
}
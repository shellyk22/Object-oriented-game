//ID: 326705829.
//Shelly Koretsky
import java.util.ArrayList;
import general.Game;
import general.GameEnvironment;
import collisions.Collidable;
import sprites.Sprite;
import sprites.SpriteCollection;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-22
 * Runs the assignment
 */
public class Ass5Game {
    /**
     * has the run command of the game.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Collidable> collideObjsTest = new ArrayList<>();
        ArrayList<Sprite> spriteTestList = new ArrayList<>();
        SpriteCollection spriteTest = new SpriteCollection(spriteTestList);
        GameEnvironment gameEnvTest = new GameEnvironment(collideObjsTest);
        Game gameTest = new Game(spriteTest, gameEnvTest);
        gameTest.initialize();
        gameTest.run();
    }
}

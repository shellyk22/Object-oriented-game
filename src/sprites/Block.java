//ID: 326705829.
//Shelly Koretsky
package sprites;
import collisions.Collidable;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import general.Game;
import general.HitNotifier;
import listeners.HitListener;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-23
 * Constructs, sets gets and handles a Block object.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //fields
    private Rectangle blockRectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<>();
    /**
     * construstd a block with rectangle rect.
     * @param rect is the rectangle shape and location of the block.
     */
    //constructor
    public Block(Rectangle rect) {
        this.blockRectangle = rect;
    }
    /**
     * construstd a block with upper left point of a rectangle and width,hight.
     * @param upperLeftOfRect is the upper left point of a rectangle.
     * @param width the width of a rectangle.
     * @param hight the hight of a rectangle.
     */
    public Block(Point upperLeftOfRect, double width, double hight) {
        this.blockRectangle = new Rectangle(upperLeftOfRect, width, hight);
    }
    /**
     * Gets the rectangle of the block.
     * @return the "collision shape" of the object.
     */
    // Return the "collision shape" of the object.
    public Rectangle getCollisionRectangle() {
        return this.blockRectangle;
    }
    /**
     * Sets the color of the block.
     * @param c the given color.
     */
    public void setBlockColor(java.awt.Color c) {
        this.color = c;
    }

    /**
     * Gets the color of the block.
     * @return the color of the block.
     */
    public Color getBlockColor() {
        return this.color;
    }
    /**
     * Draw the block on the given DrawSurface.
     * @param d the given surface.
     */
    // draw the sprite to the screen
    public void drawOn(DrawSurface d) {
        d.setColor(this.getBlockColor());
        d.fillRectangle((int) this.blockRectangle.getUpperLeft().getX(),
                (int) this.blockRectangle.getUpperLeft().getY(), (int) this.blockRectangle.getWidth(),
                (int) this.blockRectangle.getHeight());
        d.setColor(Color.gray);
        d.drawRectangle(((int) this.blockRectangle.getUpperLeft().getX()),
                (int) this.blockRectangle.getUpperLeft().getY(), (int) this.blockRectangle.getWidth(),
                (int) this.blockRectangle.getHeight());
    }
    /**
     * Method of Sprite interface.
     * for now, does nothing...
     */
    public void timePassed() {
          /////////////
    }
    /**
     * Adds the block to the game.
     * @param g the game we are adding the block to
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint  the point of the hit.
     * @param currentVelocity the velocity of the object that hit us.
     * @return the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {

        int xMin = (int) Math.round(this.getCollisionRectangle().getUpperLeft().getX());
        int yMin = (int) Math.round(this.getCollisionRectangle().getUpperLeft().getY());
        int xMax = (int) Math.round(this.getCollisionRectangle().getLowerRight().getX());
        int yMax = (int) Math.round(this.getCollisionRectangle().getLowerRight().getY());

        int xCol = (int) Math.round(collisionPoint.getX());
        int yCol = (int) Math.round(collisionPoint.getY());

        if (xCol >= xMin && xCol <= xMax && (Math.abs(yCol - yMin) <= 1)) { //hit on the upper side
            currentVelocity.setVelocity(currentVelocity.getDx(),
                                -Math.abs(currentVelocity.getDy()));
        }
        if (xCol >= xMin && xCol <= xMax && (Math.abs(yCol - yMax) <= 1)) { //hit on the lower side
            currentVelocity.setVelocity(currentVelocity.getDx(),
                    Math.abs(currentVelocity.getDy()));
        }
        if ((Math.abs(xCol - xMax) <= 1) && yCol >= yMin && yCol <= yMax) { //hit on the right side
            currentVelocity.setVelocity(Math.abs(currentVelocity.getDx()),
                    currentVelocity.getDy());
        }
        if ((Math.abs(xCol - xMin) <= 1) && yCol >= yMin && yCol <= yMax) { //hit on the left side
            currentVelocity.setVelocity(-Math.abs(currentVelocity.getDx()),
                    currentVelocity.getDy());
        }
        return currentVelocity; // after being set accordingly
    }
    /**
     * @return a String that describes the type of the sprite (paddle, ball or block).
     */
    public String getType() {
        return new String("Block");
    }
    /**
     * Creates a string that contains the size and location of the ball.
     * @return a String that describes the sprite according to its properties.
     */
    public String getName() {
        return new String("(" + this.getCollisionRectangle().getUpperLeft().getX()
                + "," + this.getCollisionRectangle().getUpperLeft().getY() + ","
                + this.getCollisionRectangle().getWidth() + ","
                + this.getCollisionRectangle().getHeight() + ")");
    }
    /**
     * Removes a block from the game.
     * @param game the game this block is being removed from.
     */
    public void removeFromGame(Game game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    /**
     * Checks if the color of a block and a ball are the same.
     * @param ball the given ball.
     * @return the string that represents the color of the block.
     */
    public Boolean ballColorMatch(Ball ball) {
        return (this.color.toString().equals(ball.getColor().toString()));
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * If the color of the block is different from the color of the ball, also
     * calls the notifiyHit method.
     * @param collisionPoint  the point of the hit.
     * @param currentVelocity the velocity of the object that hit us.
     * @param hitter the ball that hit this block.
     * @return the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    // Notice that we changed the hit method to include a "Ball hitter" parameter -- update the
    // Collidable interface accordingly.
     public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (!ballColorMatch(hitter)) {
            this.notifyHit(hitter);
        }
        //as before...
        return hit(collisionPoint, currentVelocity);
    }
    /**
     * Add hl as a listener to hit events.
     * @param hl is the listener added.
     */
    // Add hl as a listener to hit events.
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl is the listener removed.
     */
    // Remove hl from the list of listeners to hit events.
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

}

//ID: 326705829.
//Shelly Koretsky
package collisions;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;
import biuoop.DrawSurface;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-07
 * Interface of Collidable objects.
 */
public interface Collidable {
    /**
     * Gets the "collision shape" of the object.
     * @return the "collision shape" of the object.
     */
    // Return the "collision shape" of the object.
    Rectangle getCollisionRectangle();
    /**
     * draws the object on the given surface.
     * @param d  the drawing surface we work on.
     */
    void drawOn(DrawSurface d);
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint  the point of the hit.
     * @param currentVelocity the velocity of the object that hit us.
     * @param hitter the ball that hit us.
     * @return the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
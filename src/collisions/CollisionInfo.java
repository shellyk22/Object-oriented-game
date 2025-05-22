//ID: 326705829.
//Shelly Koretsky
package collisions;
import geometry.Point;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-30
 * constructs, sets gets and handles a CollisionInfo object.
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * Creates a new CollisionInfo with collision point and collision object.
     * @param collosionPoint the point at which the collision occurs.
     * @param collisionObject the collidable object involved in the collision.
     */
    //constructor
    public CollisionInfo(Point collosionPoint, Collidable collisionObject) {
        this.collisionPoint = collosionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * Gets the collision point.
     * @return collisionPoint, the point at which the collision occurs.
     */
    // the point at which the collision occurs.
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * Gets the collision object.
     * @return collisionObject, the collidable object involved in the collision.
     */
    // the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.collisionObject;
    }
    /**
     * Sets a CollisionInfo with collision point and object.
     * @param collosionPoint the point at which the collision occurs.
     * @param collisionObject the collidable object involved in the collision.
     */
    //constructor
    public void setCollisionInfo(Point collosionPoint, Collidable collisionObject) {
        this.collisionPoint = collosionPoint;
        this.collisionObject = collisionObject;
    }



}
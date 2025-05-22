//ID: 326705829.
//Shelly Koretsky
package geometry;
/**
 * ----------------------------.
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-07
 * constructs, sets gets and handles a Velocity object.
 */
public class Velocity {
    //fields
    private double dx;
    private double dy;
    // constructor
    /**
     * Constructs a line that starts in point start and ends point end.
     * @param dx the change in position on the X axis.
     * @param dy the change in position on the Y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Apply velocity to a point.
     * By Taking a point with position (x,y) and returning a new point
     * with position (x+dx, y+dy)
     * @param p the given point.
     * @return the point after applying velocity to it.
     */
    public Point applyToPoint(Point p) {
        return (new Point(p.getX() + this.dx, p.getY() + this.dy));
    }
    /**
     * Translates angle and speed to velocity.
     * @param angle the angle of the movement.
     * @param speed the speed of the movement.
     * @return velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = (speed * (Math.sin(Math.toRadians(angle))));
        double dy = (speed * (Math.cos((Math.toRadians(angle)))));
        return new Velocity(dx, dy);
    }
    /**
     * Gets the dx of the velocity.
     * @return dx of the velocity.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * Gets the dy of the velocity.
     * @return dy of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Sets the velocity of the ball.
     * @param dx the change in position on the X axis.
     * @param dy the change in position on the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
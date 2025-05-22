//ID: 326705829.
//Shelly Koretsky
package geometry;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-07
 * constructs, sets gets and handles a Point object.
 */
public class Point {
    //fields - shelly added :)
    private double x;
    private double y;

    /**
     * construstd a point at the location (x,y).
     * @param x is the x coordinate.
     * @param y is the y coordinate.
     */
    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }
    /**
     * Calculates and returns the distance of this point to the other point.
     * Does the calculations using sqrt() method and the distance formula.
     * @param other is the given point.
     * @return the distance between this point to the given point.
     */
    // distance -- return the distance of this point to the other point
    public double distance(Point other) {
        double tempSquareX = (this.getX() - other.getX())
                * (this.getX() - other.getX());
        double tempSquarey = (this.getY() - other.getY())
                * (this.getY() - other.getY());
        return java.lang.Math.sqrt(tempSquareX + tempSquarey);
    }
    /**
     * checks if the other point equels our point.
     * checks if both X and Y coordinates of the points are the same.
     * @param other is the given point.
     * @return true if the given point equals this point.
     */
    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        return ((other.getX() == this.getX()) && (other.getY() == this.getY()));
    }
    /**
     * Gets the X coordinate of this point.
     * @return the X coordinate of this point.
     */
    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }
    /**
     * Gets the Y coordinate of this point.
     * @return the Y coordinate of this point.
     */
    public double getY() {
        return this.y;
    }
    /**
     * Sets the x and y coordinate of this point.
     * @param x the x coordinate of point.
     * @param y the y coordinate of point.
     * */
    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
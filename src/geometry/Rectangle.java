//ID: 326705829.
//Shelly Koretsky
package geometry;
import java.util.ArrayList;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-23
 * constructs, sets gets and handles a Rectangle object.
 */
public class Rectangle {
    //fields
    private Point upperLeft;
    private double width;
    private double height;
    /**
     * Creates a new rectangle with location and width/height.
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * Gets the width of the rectangle.
     * @return the width of the rectangle
     */
    // Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }
    /**
     * Gets the height of the rectangle.
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * Gets the upper left point of the rectangle.
     * @return the upper left point of the rectangle.
     */
    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * Gets the upper right point of the rectangle.
     * @return the upper roght point of the rectangle.
     */

    public Point getUpperRight() {
        Point upperRight = new Point((getUpperLeft().getX() + this.getWidth()), getUpperLeft().getY());
        return upperRight;
    }
    /**
     * Gets the lower left point of the rectangle.
     * @return the lower left point of the rectangle.
     */
    public Point getLowerLeft() {
        Point lowerLeft = new Point(this.upperLeft.getX(),
                this.upperLeft.getY() + this.getHeight());
        return lowerLeft;
    }
    /**
     * Gets the lower right point of the rectangle.
     * @return the lower right point of the rectangle.
     */
    public Point getLowerRight() {
        Point lowerRight = new Point((getUpperLeft().getX() + this.getWidth()),
                (getUpperLeft().getY() + this.getHeight()));
        return lowerRight;
    }
    /**
     * Gets the upper left point of the rectangle.
     * @return the upper left point of the rectangle.
     */
    public Line getUpperSide() {
        Line upperSide = new Line(getUpperLeft(), getUpperRight());
        return upperSide;
    }
    /**
     * Gets the lower left side of the rectangle.
     * @return the lower left side of the rectangle.
     */
    public Line getLowerSide() {
        Line lowerSide = new Line(getLowerLeft(), getLowerRight());
        return lowerSide;
    }
    /**
     * Gets the upper left side of the rectangle.
     * @return the upper left side of the rectangle.
     */
    public Line getLeftSide() {
        Line leftSide = new Line(getUpperLeft(), getLowerLeft());
        return leftSide;
    }
    /**
     * Gets the right Side line of the rectangle.
     * @return the right Side line of the rectangle.
     */
    // Returns the upper-left point of the rectangle.
    public Line getRightSide() {
        Line rightSide = new Line(getUpperRight(), getLowerRight());
        return rightSide;
    }
    /**
     * Sets the upper left Point of the rectangle.
     * @param x the  coordinate of the point.
     * @param y the y coordinate of the point.
     */
    public void setUpperLeft(double x, double y) {
        this.upperLeft = new Point(x, y);
    }
    /**
     * Finds all the interaction points with a given line (if they exist).
     * @param line the given line.
     * @return meetingPointsList, a (possibly empty) List of intersection points with the specified line.
     */
    // Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> meetingPointsList = new ArrayList<>();

        if (getUpperSide().isIntersecting(line) //interaction with upper side
                && (getUpperSide().intersectionWith(line) != null)) {
            meetingPointsList.add(getUpperSide().intersectionWith(line));
        }
        if (getLowerSide().isIntersecting(line)
                && (getLowerSide().intersectionWith(line) != null)) {
            meetingPointsList.add(getLowerSide().intersectionWith(line));
        }
        if (getLeftSide().isIntersecting(line)
                && (getLeftSide().intersectionWith(line) != null)) {
            meetingPointsList.add(getLeftSide().intersectionWith(line));
        }
        if (getRightSide().isIntersecting(line)
                && (getRightSide().intersectionWith(line) != null)) {
            meetingPointsList.add(getRightSide().intersectionWith(line));
        }
        return meetingPointsList;
    }

    /**
     * checks if the other rectangle equels this rectangle.
     * @param other is the given rectangle.
     * @return true if the given rectangle equals this rectangle.
     */
    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Rectangle other) {
        return (this.getUpperLeft().equals(other.getUpperRight())
                && this.getWidth() == other.getWidth() && this.getHeight() == other.getHeight());
    }
}
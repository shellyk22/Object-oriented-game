//ID: 326705829.
//Shelly Koretsky
package geometry;
/**
 * @author Shelly Koretsky
 * @version 2.0
 * @since 2024-01-07
 * constructs, sets gets and handles a Line object.
 */


public class Line {
    //fields
    private final double error = 0.00001;
    private final Point start;
    private final Point end;

    /**
    * Construstd a line that starts in point start and ends point end.
    * @param start is the starting point of the line.
    * @param end   is the ending point of the line.
    */
    // constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Construstd a line that starts in point start and ends point end.
     * @param x1 is the x coordinate of the starting point of the line.
     * @param y1 is the y coordinate of the starting point of the line.
     * @param x2 is the x coordinate of the ending point of the line.
     * @param y2 is the y coordinate of the ending point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
    * Finds the length of the line.
    * <1.1>
    * Calculates it using the distance method (of class point).
    * <1.2>
    * Using it to calculates the distance between the start and end point of the line.
    * @return the length of the line
    */
   // Return the length of the line
   public double length() {
       return start.distance(end);
   }

   /**
    * Finds the middle point of the line.
    * @return the middle point of the line.
    */

   public Point middle() {
       double middleXValue = ((start.getX() + end.getX()) / 2);
       double middleYValue = ((start.getY() + end.getY()) / 2);
       Point middleOfLine = new Point(middleXValue, middleYValue);
       return middleOfLine;
   }
   /**
    * Returns the start point of the line.
    * @return the start point of the line.
    */
   public Point start() {
       return start;
   }
   /**
    * Returns the end point of the line.
    * @return the end point of the line.
    */
   public Point end() {
       return end;
   }

    /**
     * @param other the other line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (other == null) {
            return false;
        }
        //We will check if the intersection point are placed on both line segments.
        if (this.isVertical() && other.isVertical()) {
            return other.pointOnLine(this.start) || pointOnLine(other.start) || other.pointOnLine(this.end);
        }

        if (this.isVertical()) { //line is vertical and the 'other' is not.
            Point interPoint = new Point(this.start.getX(), (other.getIncline()
                    * this.start.getX()) + other.getB());
            return other.pointOnLine(interPoint) && pointOnLine(interPoint);
        }
        if (other.isVertical()) { //'other' is vertical but ours is not.
            Point interPoint = new Point(other.start.getX(), (getIncline()
                    * other.start.getX()) + getB());
            return other.pointOnLine(interPoint) && pointOnLine(interPoint);
        }

        double slope1 = this.getIncline(), slope2 = other.getIncline();
        if (Math.abs(slope1 - slope2) <= error) { //lines are parallel - check for any common point.
            return other.pointOnLine(this.start) || pointOnLine(other.start) || other.pointOnLine(this.end);
        }

        double b1 = this.getB();
        double b2 = other.getB();
        double xInter = (b2 - b1) / (slope1 - slope2);
        double yInter = slope1 * xInter + b1;

        Point interPoint = new Point(xInter, yInter);
        return pointOnLine(interPoint) && other.pointOnLine(interPoint);

    }

    /**
     * Checks if the line is intersecting with both given lines- other1 and other2.
     * does it by using the isIntersecting() method I wrote earlier.
     * @param other1 is a given line,we check if interacts with our line
     * @param other2 is a given line,we check if interacts with our line
     * @return the Incline value of the line.
     */
    public boolean isIntersecting(Line other1, Line other2) {
        return (this.isIntersecting(other1) && this.isIntersecting(other2));
    }

    /**
     * Checks if two lines intersect, if so, returns the point.
     * First, calls the isIntersecting function and checks if there is an interaction point.
     * If there is, we check how many interaction points there are.
     * If the lines overlap, which causes multiple interaction points, return null
     * @param other is a given line, we explore its interaction with line.
     * @return the intersection point if lines intersect in one point ,null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (other == null || !isIntersecting(other)) {
            return null;
        }
        //we can now assume that they do have an intersection.
        if (other.length() <= error) { //length=0
            return other.start;
        }
        if (this.length() <= error) { //length=0
            return this.start;
        }

        if (this.isVertical() && other.isVertical()) {
            return connectsWith(other);
        }

        if (this.isVertical()) {
            return new Point(this.start.getX(), other.getIncline() * this.start.getX()
                    + other.getB());
        }
        if (other.isVertical()) {
            return new Point(other.start.getX(), getIncline() * other.start.getX() + getB());
        }

        //We will calculate the intersection point and return (if it's in both segments).
        double slope1 = this.getIncline(), slope2 = other.getIncline();
        if (Math.abs(slope1 - slope2) <= error) {   //lines are parallels.
            return connectsWith(other);
        }

        double b1 = this.getB();
        double b2 = other.getB();
        double xInter = (b2 - b1) / (slope1 - slope2);
        double yInter = slope1 * xInter + b1;
        return new Point(xInter, yInter);
    }

    /**
     * We say that two lines are connected when the end of the first line is the start of the other.
     * This method is helpful when we want the intersection point of a line that continues the other.
     * (For example: (-1,0)->(0,0) and (0,0)->(1,0)).
     * @param other line.
     * @return the connection point (if there isn't - null).
     */
    private Point connectsWith(Line other) {
        if (other == null) {
            return null;
        }

        if (this.start.equals(other.start)) {
            if (other.pointOnLine(this.end) || pointOnLine(other.end)) {
                //checks if the other point is in the opposite direction.
                return null;
            }
            return this.start;
        }
        if (this.start.equals(other.end)) {
            if (pointOnLine(other.start) || other.pointOnLine(this.end)) {
                return null;
            }
            return this.start;
        }
        if (this.end.equals(other.start)) {
            if (other.pointOnLine(this.start) || pointOnLine(other.end)) {
                return null;
            }
            return this.end;
        }
        if (this.end.equals(other.end)) {
            if (pointOnLine(other.start) || other.pointOnLine(this.start)) {
                return null;
            }
            return this.end;
        }
        return null;
    }

    /**
     * Incline m, where y=mx+b.
     * @return the Incline of the line equation (if it exists!).
     */
    private double getIncline() {
        if ((Math.abs(this.start.getX() - this.end.getX()) <= error)) {
            throw new ArithmeticException("Line's slope is undefined");
        }

        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    /**
     * Constant: b, where y=mx+b. The meeting point with the y axis.
     * @return the constant value of the line equation.
     */
    private double getB() {
        return -1 * this.start.getX() * getIncline() + this.start.getY();
    }

    /**
     * Checks if a point is on our line.
     * @param p given point.
     * @return true if p1 is on our line, false otherwise.
     */
    private boolean pointOnLine(Point p) {
        if (p == null) {
            return false;
        }
        return Math.abs(length() - (p.distance(this.start) + p.distance(this.end))) <= error;
    }

    /**
     * Checks if the line is vertical.
     * @return true if the line is vertical, false otherwise.
     */
    private boolean isVertical() {
        return Math.abs(this.start.getX() - this.end.getX()) <= error;
    }

    /**
     * Checks if the line equals a given line.
     * Does that by checking if they have the same starting and ending point.
     * or if ones ilne ending point is th others start and vice versa.
     * @param other the given line we compare to our line.
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (((Math.abs(other.start.getX() - this.start.getX()) <= error)
                && (Math.abs(other.start.getY() - this.start.getY()) <= error)
                && (Math.abs(other.end.getX() - this.end.getX()) <= error)
                && (Math.abs(other.end.getY() - this.end.getY()) <= error))
                ||
                ((Math.abs(other.start.getX() - this.end.getX()) <= error)
                && (Math.abs(other.start.getY() - this.end.getY()) <= error)
                && (Math.abs(other.end.getX() - this.start.getX()) <= error)
                && (Math.abs(other.end.getY() - this.start.getY()) <= error)));
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @param rect the given Rectangle we check.
     * @return the closest interaction point to the start of the line, if there is
     * no suck point, return false.
     */
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line currentLine = new Line(this.start, this.end);
        if (rect.intersectionPoints(currentLine).isEmpty()) {
            return null;
        } else {
           Point closestToStart = new Point(rect.intersectionPoints(currentLine).get(0).getX(),
                   rect.intersectionPoints(currentLine).get(0).getY());

           for (int i = 0; i < rect.intersectionPoints(currentLine).size(); i++) {
               if (rect.intersectionPoints(currentLine).get(i).distance(this.start)
                       < closestToStart.distance(this.start)) {
                   closestToStart = rect.intersectionPoints(currentLine).get(i);
               }

           }
           return closestToStart;
        }
    }

}
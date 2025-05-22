//ID: 326705829.
//Shelly Koretsky
package sprites;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import geometry.Line;
import general.Game;
import general.GameEnvironment;
import collisions.CollisionInfo;
import biuoop.DrawSurface;

/**
 * @author Shelly Koretsky
 * @version 2.0
 * @since 2024-01-07
 * constructs, sets gets and handles a Ball object.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity = new Velocity(0, 0);
    private GameEnvironment gameEnv;

    /**
     * construstd a ball with canter point, radius r and color.
     *
     * @param center is the center point of the ball.
     * @param r      is the radius of the ball.
     * @param color  is the color of the ball.
     */
    // constructor
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * construstd a ball with canter point, radius r and color.
     *
     * @param x     is the x coordinate of the center of the ball.
     * @param y     is the y coordinate of the center of the ball.
     * @param r     is the radius of the ball.
     * @param color is the color of the ball.
     */
    //another constructor - shelly added
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * Gets the X coordinate of the center of the ball.
     *
     * @return the X coordinate of center point.
     */
    // accessors
    public int getX() {
        return ((int) this.center.getX());
    }

    /**
     * Gets the Y coordinate of the center of the ball.
     *
     * @return the Y coordinate of center point.
     */
    public int getY() {
        return ((int) this.center.getY());
    }

    /**
     * Gets the radius of the ball.
     *
     * @return the Y coordinate of center point.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets the color of the ball.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * sets the color of the ball.
     * @param c the given color.
     */
    public void setColor(java.awt.Color c) {
         this.color = c;
    }


    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface the given surface.
     */
    public void drawOn(DrawSurface surface) {

        surface.setColor(this.getColor());
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.getSize());
    }

    /**
     * After a given time, moves the ball one step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Sets the game environment of the ball.
     *
     * @param g the game environment of the ball.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnv = g;
    }

    /**
     * Gets the game environment of the ball.
     *
     * @return gameEnv the game environment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnv;
    }

    /**
     * Adds the ball to the game.
     *
     * @param g the game we are adding the ball to
     */
    public void addToGame(Game g) {
        g.addSprite(this);
    }

    /**
     * Sets the velocity of the ball.
     *
     * @param v the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the velocity of the ball.
     *
     * @param dx the change in position on the X axis.
     * @param dy the change in position on the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Sets the center Point of the ball.
     *
     * @param x axis of the ball center.
     * @param y axis of the ball center.
     */
    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }

    /**
     * Sets the radius of the ball.
     *
     * @param radius radius of the ball.
     */
    public void setSize(int radius) {
        this.r = radius;
    }

    /**
     * gats the velocity of the ball.
     *
     * @return velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * moves the ball from (x,y) to (x+dx, y+dy).
     * changes the velocity of a point when reaching to the edge.
     *
     * @param hight the highest point the ball is allowed to reach.
     * @param width the most distant point the ball is allowed to reach.
     */
    public void helperMove(int width, int hight) {
        if (((center.getX()) <= this.getSize())
                || ((center.getX()) >= width - this.getSize())) {
            setVelocity(((-1) * (this.velocity.getDx())), (this.velocity.getDy()));
        }

        if (((center.getY()) <= this.getSize())
                || ((Math.round(center.getY())) >= hight - this.getSize())) {
            setVelocity(this.velocity.getDx(), ((-1) * (this.velocity.getDy())));
        }

        this.moveOneStep();

    }

    /**
     * moves the ball from (x,y) to (x+dx, y+dy) in a restricted zone.
     *
     * @param topLeftx the x of the highest point a ball can reach.
     * @param topLefty the y of the highest point a ball can reach.
     * @param width    the width of the rectangle the ball is trapped in.
     * @param hight    the hight of the rectangle the ball is trapped in.
     */
    public void helperMoveInRect(int topLeftx, int topLefty, int width, int hight) {
        if (this.center.getX() <= (topLeftx + this.getSize())) {
            setVelocity(Math.abs(this.velocity.getDx()), this.velocity.getDy()); //move X right
        }

        if (this.center.getX() >= (width - this.getSize())) {
            setVelocity(-Math.abs(this.velocity.getDx()), this.velocity.getDy()); //move X left
        }

        if (this.center.getY() <= (topLefty + this.getSize())) {
            setVelocity(this.velocity.getDx(), Math.abs(this.velocity.getDy())); //move down to maxY
        }
        if (this.center.getY() >= (hight - this.getSize())) {
            setVelocity(this.velocity.getDx(), -Math.abs(this.velocity.getDy())); //move Y to zero
        }

    }
    /**
     * moves the ball a bit from the collision point depends on the hit location.
     * @param collisionRect the object we collided.
     * @param collisionlPoint the point of the collision.
     */
    public void hitLocation(Point collisionlPoint, Rectangle collisionRect) {
        int xMin = (int) Math.round(collisionRect.getUpperLeft().getX());
        int yMin = (int) Math.round(collisionRect.getUpperLeft().getY());
        int xMax = (int) Math.round(collisionRect.getLowerRight().getX());
        int yMax = (int) Math.round(collisionRect.getLowerRight().getY());
        int xCur = (int) Math.round(collisionlPoint.getX());
        int yCur = (int) Math.round(collisionlPoint.getY());
        //checks where was the hit
        if (xCur >= xMin && xCur <= xMax && yCur <= yMin) { //hit on the upper side
            this.setCenter((int) Math.round(collisionlPoint.getX()),
                    (int) Math.round(collisionlPoint.getY()));
            this.setCenter((int) Math.round(this.center.getX()), (int) Math.round(this.center.getY()
                    - this.getVelocity().getDy() - 3));
        }
        if (xCur >= xMin && xCur <= xMax && yCur == yMax) { //hit on the lower side
            this.setCenter((int) Math.round(collisionlPoint.getX()),
                    (int) Math.round(collisionlPoint.getY()));
            this.setCenter((int) Math.round(this.center.getX()), (int) Math.round(this.center.getY()
                    + this.getVelocity().getDy() + 3));
        }
        if (xCur == xMax && yCur >= yMin && yCur <= yMax) { //hit on the right side
            this.setCenter((int) Math.round(collisionlPoint.getX()),
                    (int) Math.round(collisionlPoint.getY()));
            this.setCenter((int) Math.round(this.center.getX()
                    + this.getVelocity().getDx() + 3), (int) Math.round(this.center.getY()));
        }
        if (xCur == xMin && yCur >= yMin && yCur <= yMax) { //hit on the left side
            this.setCenter((int) Math.round(collisionlPoint.getX()),
                    (int) Math.round(collisionlPoint.getY()));
            this.setCenter((int) Math.round(this.center.getX()
                    - this.getVelocity().getDx() - 3), (int) Math.round(this.center.getY()));
        }

    }
    /**
     * moves the ball from (x,y) to (x+dx, y+dy).
     * //
     */
    public void moveOneStep() {
        //this.center = this.getVelocity().applyToPoint(this.center);
        Point nextLocation = new Point(this.center.getX() + this.getVelocity().getDx(),
                this.center.getY() + this.getVelocity().getDy());
        Line trajectory = new Line(this.center, nextLocation);
        if (this.gameEnv.getClosestCollision(trajectory) != null) { // interaction
            CollisionInfo tempInfo = new CollisionInfo(this.gameEnv.getClosestCollision(trajectory).collisionPoint(),
                    this.gameEnv.getClosestCollision(trajectory).collisionObject());
            Point collisionlPoint = new Point(tempInfo.collisionPoint().getX(), tempInfo.collisionPoint().getY());
            Rectangle collisionRect = new Rectangle(tempInfo.collisionObject().getCollisionRectangle().getUpperLeft(),
                    tempInfo.collisionObject().getCollisionRectangle().getWidth(),
                    tempInfo.collisionObject().getCollisionRectangle().getHeight());
            hitLocation(collisionlPoint, collisionRect); //does all the manipulations on the velocity
            this.gameEnv.getClosestCollision(trajectory).collisionObject().hit(this, collisionlPoint,
                    this.getVelocity());
            this.center = this.getVelocity().applyToPoint(this.center);
            } else { //no interaction
                this.center = this.getVelocity().applyToPoint(this.center); //moves normally.
        }
    }
    /**
     * moves the ball from (x,y) to (x+dx, y+dy).
     * while making sure the ball does not enter a restricted zone.
     * @param min1 the minimum x,y a ball cant reach
     * @param max1 the maximum x,y a ball cant reach
     */
    public void helperRestrict(int min1, int max1) {
        int r = this.getSize();
        if ((center.getX() <= (max1 + r)) && (center.getX() >= (min1 - r))
                && (center.getY() <= (max1 + r)) && (center.getY() >= (min1 - r))) { //zone 2
            //want to enter restricted zone
            if (((center.getY() - (this.velocity.getDy())) <= (min1 - r))
                    || ((center.getY() - (this.velocity.getDy())) >= (max1 + r))) { //came from up or down
                setVelocity((this.velocity.getDx()), ((-1) * (this.velocity.getDy())));
            }
            if (((center.getX() - (this.velocity.getDx())) <= (min1 - r))
                    || ((center.getX() - (this.velocity.getDx())) >= (max1 + r))) { //came from sides
                setVelocity(((-1) * (this.velocity.getDx())), (this.velocity.getDy()));
            }
        }
    }
    /**
     * moves the ball from (x,y) to (x+dx, y+dy).
     * calls other methods according to the restrictions of the movement.
     * in our case, there are balls that cant reach two restricted zones.
     * bur at the same time have to stay in the window limits.
     * @param min1 the minimum x,y a ball cant reach.
     * @param max1 the maximum x,y a ball cant reach.
     * @param min2 the minimum x,y a ball cant reach. (second restricted zone)
     * @param max2 the maximum x,y a ball cant reach.
     * @param hight the hight of the window.
     * @param width the width of the window.
     * @param topLeft the top  (x,y) of a restricted zone.
     */
    public void helperRestrictedMoveInRect(int min1, int max1, int min2, int max2,
    int topLeft, int width, int hight) {
        if ((min1 > 0) && (max1 > 0)) {
            this.helperRestrict(min1, max1);
            this.helperRestrict(min2, max2);
        }
        this.helperMoveInRect(topLeft, topLeft, width, hight);
        this.moveOneStep();
    }

    /**
     * @return a String that describes the type of the sprite (paddle, ball or block).
     */
    public String getType() {
        return new String("Ball");
    }
    /**
     * Creates a string that contains the size, location and color of the ball.
     * @return a String that describes the sprite according to its properties.
     */
    public String getName() {
        return new String("(" + this.getX() + "," + this.getY() + ","
                + getSize() + ")");
    }
    /**
     * Removes a block from the game.
     * @param game the game this block is being removed from.
     */
    public void removeFromGame(Game game) {
        game.removeSprite(this);
    }
}
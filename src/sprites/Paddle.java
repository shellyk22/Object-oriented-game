//ID: 326705829.
//Shelly Koretsky
package sprites;
import collisions.Collidable;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import general.Game;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-23
 */
public class Paddle implements Collidable, Sprite {
    private biuoop.KeyboardSensor keyboard;

    //field
    private Rectangle paddleRectangle;
    private java.awt.Color color;
    private int gameBorderWidth;
    /**
     * Constructs the Rectangke field of the paddle.
     * @param rect the given rectangle.
     */
    //constructor
    public Paddle(Rectangle rect) {
        this.paddleRectangle = rect;
    }
    /**
     * Gets the rectangle of the paddle.
     * @return the "collision shape" of the object.
     */
    // Return the "collision shape" of the object.
    public Rectangle getCollisionRectangle() {
        return this.paddleRectangle;
    }
    /**
     * Sets the color of the paddle.
     * @param c the given color.
     */
    public void setPaddleColor(java.awt.Color c) {
        this.color = c;
    }
    /**
     * Gets the color of the paddle.
     * @return the color of the paddle.
     */
    public Color getPaddleColor() {
        return this.color;
    }
    /**
     * Sets the width of the border the paddle lives in.
     * @param width the given width of the border.
     */
    public void setBorderWidth(int width) {
        this.gameBorderWidth = width;
    }
    /**
     * Draw the paddle on the given DrawSurface.
     * @param d the given surface.
     */
    // draw the sprite to the screen
    public void drawOn(DrawSurface d) {
        d.setColor(this.getPaddleColor());
        d.fillRectangle((int) this.paddleRectangle.getUpperLeft().getX(),
                (int) this.paddleRectangle.getUpperLeft().getY(),
                (int) this.paddleRectangle.getWidth(),
                (int) this.paddleRectangle.getHeight());
    }
    /**
     * Sprite method, if after the time passed the one of the relevant keyboard keys
     * was pressed, moves the paddle to the needed direction.
     */
    // notify the sprite that time has passed
    public void timePassed() {
       if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
           // Move the paddle to the left
           moveLeft();
       } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
           // Move the paddle to the right
           moveRight();
       }
    }
    /**
     * Sets the keyboard sensor.
     * @param k the keyboard sensor.
     */
    public void setKeyBoard(KeyboardSensor k) {
        this.keyboard = k;
    }
    /**
     * Moves the paddle 5 pixels to the left.
     * If exiting the screen, moves it to the right border of the screen.
     */
    public void moveLeft()  {
        if (this.getCollisionRectangle().getUpperLeft().getX() < 20) {

            this.getCollisionRectangle().setUpperLeft((this.gameBorderWidth
                            - this.getCollisionRectangle().getWidth() - 20),
                    this.getCollisionRectangle().getUpperLeft().getY());
        } else {
            this.getCollisionRectangle().setUpperLeft(this.getCollisionRectangle().getUpperLeft().getX() - 5,
                    this.getCollisionRectangle().getUpperLeft().getY());
        }

    }
    /**
     * Moves the paddle 5 pixels to the right.
     * If exiting the screen, moves it to the left border of the screen.
     */
    public void moveRight() {
        if (this.getCollisionRectangle().getUpperLeft().getX() > (this.gameBorderWidth
                - this.getCollisionRectangle().getWidth() - 17)) {
            this.getCollisionRectangle().setUpperLeft(25,
                    this.getCollisionRectangle().getUpperLeft().getY());
        } else {
            this.getCollisionRectangle().setUpperLeft(this.getCollisionRectangle().getUpperLeft().getX() + 5,
                    this.getCollisionRectangle().getUpperLeft().getY());
        }
    }

    /**
     * Adds the paddle to the game.
     * @param g the game we are adding the paddle to
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * Helper method for the hit method that helps us change the velocity of the ball.
     * depands on the hitting point (its location on the paddle).
     * @param collisionPoint  the point of the hit.
     * @param currentVelocity the velocity of the object that hit us.
     * @return the new velocity expected after the hit
     * (based on the force the object inflicted on us and the hitting location).
     */
    public Velocity hitInUpper(Point collisionPoint, Velocity currentVelocity) {
        double paddleWidth = this.getCollisionRectangle().getWidth();
        double partOfPaddle = paddleWidth / 5;
        double x0 = 0;
        double x1 = partOfPaddle;
        double x2 = 2 * partOfPaddle;
        double x3 = 3 * partOfPaddle;
        double x4 = 4 * partOfPaddle;
        double x5 = paddleWidth;
        double angle = 0;

        double xCurr = collisionPoint.getX() - this.paddleRectangle.getUpperLeft().getX();
        double yCurr = collisionPoint.getY();
        if (xCurr >= x0 && xCurr <= x1) {
            angle = 300;
        } else if (xCurr > x1 && xCurr <= x2) {
            angle = 330;
        } else if (xCurr > x2 && xCurr <= x3) {
            angle = 0;
        } else if (xCurr > x3 && xCurr <= x4) {
            angle = 30;
        } else if (xCurr > x4 && xCurr <= x5) {
            angle = 60;
        }
        //double tempAngle = Math.tanh(currentVelocity.getDx() / currentVelocity.getDy());
        double speed = Math.sqrt((currentVelocity.getDx() * currentVelocity.getDx())
                + (currentVelocity.getDy() * currentVelocity.getDy()));
        //double speed = 5 * Math.sqrt(2);
        Velocity updatedV = new Velocity((speed * (Math.sin(Math.toRadians(angle)))),
                (speed * (Math.cos((Math.toRadians(angle))))));
        return updatedV;
    }
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint  the point of the hit.
     * @param currentVelocity the velocity of the object that hit us.
     * @param hitter the ball that hits the paddle.
     * @return the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int xMin = (int) this.getCollisionRectangle().getUpperLeft().getX();
        int yMin = (int) this.getCollisionRectangle().getUpperLeft().getY();
        int xMax = (int) this.getCollisionRectangle().getLowerRight().getX();
        int yMax = (int) this.getCollisionRectangle().getLowerRight().getY();

        int xCol = (int) collisionPoint.getX();
        int yCol = (int) collisionPoint.getY();


        if (xCol >= xMin && xCol <= xMax && (Math.abs(yCol - yMin) <= 1)) { //hit on the upper side
            currentVelocity.setVelocity(hitInUpper(collisionPoint, currentVelocity).getDx(),
                    -hitInUpper(collisionPoint, currentVelocity).getDy());
            //currentVelocity.setVelocity(currentVelocity.getDx(),
                  //  -Math.abs(currentVelocity.getDy()));
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
     * @return a String that describes the sprite object name.
     */
    public String getType() {
        return new String("Paddle");
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
}

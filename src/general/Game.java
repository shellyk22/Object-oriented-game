//ID: 326705829.
//Shelly Koretsky
package general;
import listeners.BlockRemover;
import listeners.BallRemover;
import listeners.ScoreTrackingListener;
import sprites.Ball;
import sprites.Sprite;
import sprites.SpriteCollection;
import sprites.Block;
import sprites.Paddle;
import sprites.ScoreIndicator;
import collisions.Collidable;
import geometry.Point;
import geometry.Rectangle;
import biuoop.GUI;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-30
 * constructs, sets gets and handles a Game object.
 */
public class Game {
    //fields
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainingBlocks;
    private BlockRemover blockRemover;
    private Counter remainingBalls;
    private BallRemover ballRemover;
    private Counter scoreCout;
    private ScoreTrackingListener scoreTrackingL;

    /**
     * Constructs a Game object.
     * @param s is the SpriteCollection of the game.
     * @param e   is the GameEnvironment of the game.
     */
    //constructor
    public Game(SpriteCollection s, GameEnvironment e) {
        this.sprites = s;
        this.environment = e;
        /////////////////
        this.remainingBlocks = new Counter();
        this.blockRemover = new BlockRemover(this, remainingBlocks);
        this.remainingBalls = new Counter();
        this.ballRemover = new BallRemover(this, remainingBalls);
        this.scoreCout = new Counter();
        this.scoreTrackingL = new ScoreTrackingListener(scoreCout);
    }
    /**
     * Adds a Collidable object to the array of collidables.
     * @param c is the collidable added to the game Environment of the game.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * Removes a Collidable object from the array of collidables.
     * @param c is the collidable removed from the game Environment of the game.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getGameEnv().remove(c);
    }
    /**
     * Adds a Sprite object to the array of collidables.
     * @param s is the Sprite added to the sprite collection of the game.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * Removes a sprite object from the array of sprites.
     * @param s is the sprite removed from the sprite collection of the game.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }
    /**
     * gets the score of the player.
     * @return the score of the player.
     */
    public int getScoreCounter() {
        return this.scoreTrackingL.getScore();
    }
    //public void setCounter(Counter numOfBlocks) {
        //this.remainingBlocks = numOfBlocks;
    //}

    ////////////////////////////////////////////
    /**
     * Sets the GUI object of the game.
     * @param g is the gui of the game.
     */
    public void setGui(GUI g) {
        this.gui = g;
    }
    /**
     * Creates borders to the game.
     * @param width the width of the board game.
     * @param hight the hight of the board game.
     */
    public void addFrame(int width, int hight) {
//background
        Point background = new Point(-30, -30);
        Rectangle backgroundRect = new Rectangle(background, width + 70, hight + 70);
        Block blockback = new Block(backgroundRect);
        blockback.setBlockColor(Color.pink);
        blockback.addToGame(this);
//actual borders
       Point leftBorder = new Point(0, 20);
       Point upperBorder = new Point(0, 0);
       Point rightBorder = new Point(width - 20, 20);
       Point lowerBorder = new Point(0, hight + 20);

        Rectangle leftRect = new Rectangle(leftBorder, 20, hight + 10);
        Rectangle upperrect = new Rectangle(upperBorder, width + 10, 60);
        Rectangle rightrect = new Rectangle(rightBorder, 20, hight + 10);
        Rectangle lowerBrect = new Rectangle(lowerBorder, width + 10, 20);
        Block leftB = new Block(leftRect);
        Block upperB = new Block(upperrect);
        Block rightB = new Block(rightrect);
        Block lowerB = new Block(lowerBrect);
        leftB.setBlockColor(Color.gray);
        upperB.setBlockColor(Color.gray);
        rightB.setBlockColor(Color.gray);
        lowerB.setBlockColor(Color.gray);
        leftB.addToGame(this);
        upperB.addToGame(this);
        rightB.addToGame(this);
        lowerB.addToGame(this);

       Point left2Border = new Point(-10, 20);
       Point upper2Border = new Point(0, -10);
       Point right2Border = new Point(width - 10, 15);
       Point lower2Border = new Point(-10, hight + 10);

       Rectangle left2Rect = new Rectangle(left2Border, 20, hight + 10);
       Rectangle upper2rect = new Rectangle(upper2Border, width + 10, 60);
       Rectangle right2rect = new Rectangle(right2Border, 20, hight + 10);
       Rectangle lower2Brect = new Rectangle(lower2Border, width + 10, 20);

       Block leftB2 = new Block(left2Rect);
       Block upperB2 = new Block(upper2rect);
       Block rightB2 = new Block(right2rect);
       Block lowerB2 = new Block(lower2Brect);

       leftB2.setBlockColor(Color.gray);
       upperB2.setBlockColor(Color.gray);
       rightB2.setBlockColor(Color.gray);
       lowerB2.setBlockColor(Color.gray);
       leftB2.addToGame(this);
       upperB2.addToGame(this);
       rightB2.addToGame(this);
       lowerB2.addToGame(this);

        Point left3Border = new Point(-16, 20);
        Point upper3Border = new Point(0, -16);
        Point right3Border = new Point(width - 4, 15);
        Point lower3Border = new Point(-10, hight);

        Rectangle left3Rect = new Rectangle(left3Border, 20, hight + 10);
        Rectangle upper3rect = new Rectangle(upper3Border, width + 10, 55);
        Rectangle right3rect = new Rectangle(right3Border, 20, hight + 10);
        Rectangle lower3Brect = new Rectangle(lower3Border, width + 10, 20);

        Block leftB3 = new Block(left3Rect);
        Block upperB3 = new Block(upper3rect);
        Block rightB3 = new Block(right3rect);
        Block lowerB3 = new Block(lower3Brect);

        leftB3.setBlockColor(Color.gray);
        upperB3.setBlockColor(Color.gray);
        rightB3.setBlockColor(Color.gray);
        lowerB3.setBlockColor(Color.gray);
        leftB3.addToGame(this);
        upperB3.addToGame(this);
        rightB3.addToGame(this);
        lowerB3.addToGame(this);

        /////////////////
        lowerB.addHitListener(this.ballRemover);
        lowerB2.addHitListener(this.ballRemover);
        lowerB3.addHitListener(this.ballRemover);
    }
    /**
     * Adds a new row of blocks to the game.
     * @param x the x coordinate of the upperLeft point of the first block in the row.
     * @param y the y coordinate of the upperLeft point of the first block in the row.
     * @param numOfBlocks number of blocks in the game
     * @param color the color of the blocks in the row.
     */
    public void addRow(int x, int y, int numOfBlocks, Color color) {
        for (int i = 0; i < numOfBlocks; i++) {
            Point upperL = new Point(x + (50 * i), y);
            Rectangle rect = new Rectangle(upperL, 50, 20);
            Block block = new Block(rect);
            block.setBlockColor(color);
            block.addToGame(this);
            this.remainingBlocks.increase(1);
            block.addHitListener(this.blockRemover);
            block.addHitListener(this.scoreTrackingL);
        }
    }
    /**
     * Adds a new ball to the game.
     * @param x the x coordinate of the canter of the ball.
     * @param y the y coordinate of the canter of the ball.
     */
    public void addBall(int x, int y) {
        Ball ball = new Ball(x, y, 6, Color.black);
        ball.setVelocity(0, 4);
        ball.addToGame(this);
        ball.setGameEnvironment(this.environment);
        this.remainingBalls.increase(1);
    }
    /**
     * Adds a paddle and sets board game and use of ketboard.
     */
    public void addPaddle() {
        GUI guiGame = new GUI("Shelly's Arknoid", 800, 600);
        this.setGui(guiGame);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        Point paddleUpperLeft = new Point(360, 550);
        Rectangle rectPaddle = new Rectangle(paddleUpperLeft, 120, 25);
        Paddle paddle = new Paddle(rectPaddle);
        paddle.setPaddleColor(Color.darkGray);
        paddle.setBorderWidth(800);
        paddle.setKeyBoard(keyboard);
        paddle.addToGame(this);
    }
    /**
     * Adds a score board to the game.
     */
    public void addScoreBoard() {
        Point upperL = new Point(0, 0);
        ScoreIndicator scoreB = new ScoreIndicator(upperL, 800, 40, this);
        scoreB.setBlockColor(Color.white);
        scoreB.addToGame(this);
        //scoreB.addHitListener(this.scoreTrackingL);
    }

    /**
     *Initialize a new game: create the Blocks and Ball (and Paddle)
     *and add them to the game.
     */
    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
 public void initialize() {

     addFrame(800, 600);
     addBall(450, 500);
     addBall(360, 530);
     addBall(400, 515);
     addPaddle();
     //addRow(280, 130, 10, Color.yellow);
     addRow(150, 150, 10, Color.cyan);
     addRow(200, 170, 8, Color.magenta);
     addRow(250, 190, 6, Color.blue);
     addRow(300, 210, 4, Color.green);
     addRow(350, 230, 2, Color.yellow);
     this.blockRemover = new BlockRemover(this, remainingBlocks);
     this.ballRemover = new BallRemover(this, remainingBalls);
     this.scoreTrackingL = new ScoreTrackingListener(scoreCout);
     addScoreBoard();
 }

    /**
     * Run the game -- start the animation loop.
     */
 // Run the game -- start the animation loop.
 public void run() {
     biuoop.Sleeper sleeper = new biuoop.Sleeper();
     int framesPerSecond = 60;
     int millisecondsPerFrame = 1000 / framesPerSecond;

     while (remainingBlocks.getValue() >= 1) {
         long startTime = System.currentTimeMillis(); // timing
         DrawSurface d = gui.getDrawSurface();
         this.sprites.drawAllOn(d);
         gui.show(d);
         this.sprites.notifyAllTimePassed();

         // timing
         long usedTime = System.currentTimeMillis() - startTime;
         long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
         if (milliSecondLeftToSleep > 0) {
             sleeper.sleepFor(milliSecondLeftToSleep);
         }
         if (remainingBlocks.getValue() == 0) {
             this.scoreCout.increase(100);
             this.scoreTrackingL.setCurrentScore(scoreCout.getValue());
             System.out.print("amazing! your score is: " + scoreCout.getValue());
             gui.close();
             return;
         }
         if (remainingBalls.getValue() == 0) {
             System.out.print("you lost. loser :(");
             gui.close();
             return;
         }
     }

 }
}
//ID: 326705829.
//Shelly Koretsky
package listeners;
import general.Game;
import general.Counter;
import sprites.Ball;
import sprites.Block;

/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-23
 * a BallRemover is in charge of removing balls from the game
 * as well as keeping count of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private Game gameOfBalls;
    private Counter remainingBallsCount;
    /**
     * Constructs a BallRemover objects, that "listens" to hits balls with
     * a specific block.
     * @param game is the game given.
     * @param remainingBalls is the number of balls currently in the game.
     */
    public BallRemover(Game game, Counter remainingBalls) {
        this.gameOfBalls = game;
        this.remainingBallsCount = remainingBalls;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * in such case, removes the hitter ball from the game,
     * and decreases the ball counter by 1.
     * @param beingHit is the block being hit.
     * @param hitter is the ball that hit the block.
     */
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBallsCount.decrease(1);
        hitter.removeFromGame(this.gameOfBalls);
    }
}

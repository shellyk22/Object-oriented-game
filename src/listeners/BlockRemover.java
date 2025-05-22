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
 * @since 2024-02-22
 * a BlockRemover is in charge of removing blocks from the game
 * as well as keeping count of the number of blocks that remain.
 */

public class BlockRemover implements HitListener {
    //fields
    private Game gameOfBlocks;
    private Counter remainingBlocksCount;
    /**
     * Constructs a BlockRemover objects, that "listens" to hits of balls with
     * a specific block.
     * @param game is the game given.
     * @param remainingBlocks is the number of blocks currently in the game.
     */
    //constructor
    public BlockRemover(Game game, Counter remainingBlocks) {
        this.gameOfBlocks = game;
        this.remainingBlocksCount = remainingBlocks;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * in such case, removes the hitten block from the game,
     * and decreases the block counter by 1.
     * and also, changes the color of the ball to the color of the block
     * he hit.
     * @param beingHit is the block being hit.
     * @param hitter is the ball that hit the block.
     */
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.setColor(beingHit.getBlockColor());
        this.remainingBlocksCount.decrease(1);
        beingHit.removeFromGame(this.gameOfBlocks);
        beingHit.removeHitListener(this);
    }
}
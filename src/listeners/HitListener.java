//ID: 326705829.
//Shelly Koretsky
package listeners;
import sprites.Ball;
import sprites.Block;

/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-22
 * Interface HitListener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit is the block being hit.
     * @param hitter is the ball that hit the block.
     */
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    void hitEvent(Block beingHit, Ball hitter);
}

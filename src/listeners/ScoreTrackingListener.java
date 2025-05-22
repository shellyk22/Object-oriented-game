//ID: 326705829.
//Shelly Koretsky
package listeners;
import sprites.Block;
import sprites.Ball;
import general.Counter;

/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-22
 * keeps track of the score of a player.
 * handles a score tracking object.
 */
public class ScoreTrackingListener implements HitListener {
    //field
    private Counter currentScore;
    /**
     * Constructs a ScoreTrackingListener objects, that "listens" to hits of balls with
     * a specific block.
     * @param scoreCounter is the counter given.
     */
    // constructor
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * in such case, adds 5 point to the score count.
     * @param beingHit is the block being hit.
     * @param hitter is the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
    /**
     * Gets the score.
     * @return the value of the score according to the score counter.
     */
    public int getScore() {
        return currentScore.getValue();
    }
    /**
     * Sets the score.
     * @param c the given score we set.
     */
    public void setCurrentScore(int c) {
        this.currentScore.setValue(c);
    }
}
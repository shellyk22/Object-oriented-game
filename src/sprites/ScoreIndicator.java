//ID: 326705829.
//Shelly Koretsky
package sprites;
import geometry.Point;
import general.Game;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-22
 * dusplayes the score of a player.
 * handles a score displaying object.
 */
public class ScoreIndicator extends Block {
    //fields
    private Game game;
    /**
     * Draws the score block on the given surface.
     * @param upperLeft the upperleft point of the block.
     * @param width the wigth of the block.
     * @param hight the hight of the block.
     * @param g the given game this scoreBoard is in.
     */
    //counstructor
    public ScoreIndicator(Point upperLeft, int width, int hight, Game g) {
        super(upperLeft, width, hight);
        this.game = g;
    }
    /**
     * Draws the Sprite on the given surface.
     * @param d the given surface
     */
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        // draw text in black
        d.setColor(Color.black);
        d.drawText(250, 20, "Score: " + game.getScoreCounter(), 20);
    }
    /**
     * @return a String that describes the type of the sprite (paddle, ball or block).
     */
    @Override
    public String getType() {
        return new String("ScoreIndicator");
    }
}

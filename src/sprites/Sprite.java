//ID: 326705829.
//Shelly Koretsky
package sprites;
import general.Game;
import biuoop.DrawSurface;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-30
 * Interface of Sprite objects.
 */
public interface Sprite {
    /**
     * Draws the Sprite on the given surface.
     * @param d the given surface
     */
    // draw the sprite to the screen
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    // notify the sprite that time has passed
    void timePassed();
    /**
     * Adds the sprite to the game.
     * @param g the given game.
     */
    //adds the sprite to the game
    void addToGame(Game g);
    /**
     * @return a String that describes the type of the sprite (paddle, ball or block).
     */
    String getType();
    /**
     * @return a String that describes the sprite according to its properties.
     */
    String getName();
}
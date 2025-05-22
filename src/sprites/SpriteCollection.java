//ID: 326705829.
//Shelly Koretsky
package sprites;
import java.util.ArrayList;
import java.util.List;
import biuoop.DrawSurface;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-01-28
 * constructs, sets gets and handles a SpriteCollection object.
 */
public class SpriteCollection {
    //field
    private ArrayList<Sprite> spritesInWorld = new ArrayList<>();
    /**
     * Constructs a SpriteCollection.
     * @param spritesList is the list of sprites.
     */
    //constructor
    public SpriteCollection(ArrayList<Sprite> spritesList) {
        this.spritesInWorld = spritesList;
    }
    /**
     * Adds a sprite to the collection.
     * @param s is the sprute added to the list.
     */
    public void addSprite(Sprite s) {
        spritesInWorld.add(s);
    }
    /**
     * call timePassed() on all sprites in the collection.
     */
    // call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.spritesInWorld);
        for (Sprite sprite : spritesCopy) {
            sprite.timePassed();
        }
    }
    /**
     * call drawOn(d) on all sprites in the collection.
     * and draws all the sprites on the screeen.
     * @param d the given surface.
     */
    // call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spritesInWorld) {
            sprite.drawOn(d);
        }
    }
    /**
     * Gets the list array of sprites (our game spriteCollection).
     * @return list array of sprites.
     */
    //getter
    public ArrayList<Sprite> getSprites() {
        return this.spritesInWorld;
    }
}
//ID: 326705829.
//Shelly Koretsky
package general;
import listeners.HitListener;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-22
 * Interface HitNotifier.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl is the listener added.
     */
    // Add hl as a listener to hit events.
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl is the listener removed.
     */
    // Remove hl from the list of listeners to hit events.
    void removeHitListener(HitListener hl);
}
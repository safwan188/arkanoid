/**
 * @author safwan
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.
    /**
     * @param hl add hitlestener
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * @param hl remove hitlisterner
     */
    void removeHitListener(HitListener hl);
}

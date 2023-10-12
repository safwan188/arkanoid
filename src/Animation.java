import biuoop.DrawSurface;
/**
 * @author safwan
 */
public interface Animation {
    /**
     * @param d aniumition do one frame on d
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return true if animition should stop
     */
    boolean shouldStop();
}

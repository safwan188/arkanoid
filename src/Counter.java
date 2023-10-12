/**
 * @author safwan
 */
public class Counter {
    private int x;
    /**
     * constructor.
     */
    public Counter() {
        this.x = 0;
    }
    /**
     * @param number add number to current count.
     */
    void increase(int number) {
        this.x = x + number;
    }
    /**
     * @param number subtract number from current count.
     */
    void decrease(int number) {
        this.x = x - number;
    }
    /**
     * @return get current count.
     */
    int getValue() {
        return this.x;
    }
}

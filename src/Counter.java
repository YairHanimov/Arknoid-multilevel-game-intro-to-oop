/**
 * The type Counter.
 */
public class Counter {
    private int num;

    /**
     * Instantiates a new Counter.
     *
     * @param numb the numb
     */
// add number to current count.
    public Counter(int numb) {
        this.num = numb;
    }

    /**
     * Increase.
     *
     * @param number the number
     */
    void increase(int number) {
        this.num = this.num + number;
    }

    /**
     * Decrease.
     *
     * @param number the number
     */
// subtract number from current count.
    void decrease(int number) {
        this.num = this.num - number;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
// get current count.
    int getValue() {
        return this.num;
    }
}
//ID: 326705829.
//Shelly Koretsky
package general;
/**
 * @author Shelly Koretsky
 * @version 1.0
 * @since 2024-02-22
 * a counter Helps keep track of count.
 */
public class Counter {
    //field
    private int value;
    /**
     * Constructs a counter object with value of 0.
     */
    //constructors
    public Counter() {
        this.value = 0;
    }
    /**
     * Constructs a counter object with a given value.
     * @param val the given value.
     */
    public Counter(int val) {
        this.value = val;
    }
    /**
     * add number to current count.
     * @param number the given number added.
     */
    // add number to current count.
    public void increase(int number) {
        this.value += number;
    }
    /**
     * subtract number from the current count.
     * @param number the given number subtracted.
     */
    // subtract number from current count.
    public void decrease(int number) {
        this.value -= number;
    }
    /**
     * get current count.
     * @return the value of the counter.
     */
    // get current count.
    public int getValue() {
        return this.value;
    }
    /**
     * sets current count.
     * @param v the given value.
     */
    public void setValue(int v) {
        this.value = v;
    }
}
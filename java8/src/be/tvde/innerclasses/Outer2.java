package be.tvde.innerclasses;

/**
 * Created by tomvde on 29/12/2016.
 */
public class Outer2 {

    // Instance variable for Outer2 class
    private int value = 1116;

    // Inner2 class starts here
    public class Inner2 {
        // Instance variable for Inner2 class
        private int value = 1720;

        public void printValue() {
            System.out.println("\nInner2 - printValue()...");
            System.out.println("Inner2: Value = " + value);
            System.out.println("Outer: Value = " + Outer2.this.value + " != " + this.value);
        }
    } // Inner2 class ends here

    // Instance method for Outer class
    public void printValue() {
        System.out.println("\nOuter2 - printValue()...");
        System.out.println("Outer2: Value = " + value);
    }

    // Another instance method for Outer2 class
    public void setValue(int newValue) {
        System.out.println("\nSetting Outer2's value to " + newValue);
        this.value = newValue;
    }
}

package be.tvde.innerclasses;

/**
 * Created by tomvde on 29/12/2016.
 */
public class OuterTest {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        outer.printValue();
        inner.printValue();
    }
}

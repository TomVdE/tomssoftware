package be.tvde.innerclasses.local_inner_classes.inner_class_outside_declaring_block.extend_public_class;

/**
 * Created by tomvde on 27/12/2016.
 */
public class LocalInnerTest {

    public static void main(String[] args) {
        RandomInteger rTop = new RandomInteger();

        System.out.println("Random integers using Top-level class: ");
        System.out.println(rTop.getValue());
        System.out.println(rTop.getValue());
        System.out.println(rTop.getValue());

        // Generate random integers using the RandomIntegerLocal class
        RandomLocal local = new RandomLocal();
        RandomInteger rLocal = local.getRandomInteger();
        System.out.println("\nRandom integers using local inner class:");

        System.out.println(rLocal.getValue());
        System.out.println(rLocal.getValue());
        System.out.println(rLocal.getValue());

    }
}

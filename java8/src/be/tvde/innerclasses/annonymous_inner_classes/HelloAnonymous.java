package be.tvde.innerclasses.annonymous_inner_classes;

/**
 * Created by tomvde on 27/12/2016.
 */
public class HelloAnonymous {

    public static void main(String[] args) {
        new Object() {
            {
                System.out.println("Hello from an anonymous class... ");
            }
        };
    }
}

package be.tvde.lambdas.book_examples.lambdas_as_parameters;

/**
 * Created by tomvde on 22/12/2016.
 */
public class LamdbaUtil {

    /**
     * You can use a lamba expression as method arguments!!
     *
     * @param adder
     */
    public void handleAdder(Adder adder) {
        double x = 190.90;
        double y = 8.50;

        double sum = adder.add(x, y);
        System.out.println("Using Adder: ");
        System.out.println(x + " + " + y + " = " + sum);
    }

    /**
     * You can use a lamba expression as method arguments!!
     *
     * @param joiner
     */
    public void handleJoiner(Joiner joiner) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = joiner.join(s1, s2);

        System.out.print("Using a Joiner:");
        System.out.println("\"" + s1 + "\" + \"" + s2 + "\" = \"" + s3 + "\"");;
    }
}

package be.tvde.lambdas.book_examples.lambdas_as_parameters;

/**
 * Created by tomvde on 22/12/2016.
 */
public class LambdaUtilTest {

    public static void main(String[] args) {
        LamdbaUtil util = new LamdbaUtil();

        util.handleAdder((x, y) -> x + y);

        Joiner joinWithSpace = (x, y) -> { return x + " " + y; };
        Joiner joinReverse = (x, y) -> {
            StringBuilder sbx = new StringBuilder(x);
            StringBuilder sby = new StringBuilder(y);

            return sby.reverse().append(",").append(sbx.reverse()).toString();
        };

        //3 times we call the method, every time witha different outcome
        /*
            changing the behavior of a method through its parameters is
            known as BEHAVIOR PARAMETERIZATION

            Also known as passing code as data because you pass code encapsulated
            in lambda expressions to methods as if it is data
         */
        util.handleJoiner((x, y) -> x + y);
        util.handleJoiner(joinWithSpace);
        util.handleJoiner(joinReverse);
    }
}

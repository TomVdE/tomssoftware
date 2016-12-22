package be.tvde.lambdas.book_examples.lambdas_as_parameters;

/**
 * Created by tomvde on 22/12/2016.
 */
public class LambdaUtilTest2 {

    public static void main(String[] args) {
        //2 methods in thes class have same name --> method overloading
        LamdbaUtil2 util = new LamdbaUtil2();


        //Compile time error because method ambiguity
        //util.handle((x, y) -> x + y);

        //solution 1 -> use explicit lambda
        util.handle((double x, double y) -> { return x + y;});

        //solution 2 --> use a cast
        util.handle((Adder) (x, y) -> { return x + y; } );

        //solution 3 -> first assign lambda expression to a variable of desired type
        Adder adder = (x, y) -> { return x + y;};
        util.handle(adder);
    }
}

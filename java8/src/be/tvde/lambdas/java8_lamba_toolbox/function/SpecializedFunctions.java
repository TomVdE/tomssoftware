package be.tvde.lambdas.java8_lamba_toolbox.function;

import java.util.function.*;

/**
 * Created by tomvde on 22/12/2016.
 */
public class SpecializedFunctions {

    public static void main(String[] args) {
        SpecializedFunctions app = new SpecializedFunctions();

        app.exampleIntFunction();
        app.exampleToIntFunction();
    }

    public void exampleIntFunction() {
        IntFunction<String> intFunction = x -> {
            return Integer.toString(x);
        };
        System.out.println(intFunction.apply(99));
        DoubleFunction<String> doubleFunction = y -> {
            return Double.toString(y);
        };
        System.out.println(doubleFunction.apply(12.12));




    }
    public void exampleToIntFunction() {
        ToIntFunction<String> f = s -> { return s.length();};


        System.out.println(f.applyAsInt("Hello world"));
    }
}

package be.tvde.lambdas.java8_lamba_toolbox.function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * Created by tomvde on 21/12/2016.
 */
public class FunctionApp {

    public static void main(String[] args) {
        FunctionApp app = new FunctionApp();

        app.exampleIntToDoubleFunction();
        app.exampleFunction();
        app.exampleBiFunction();
    }

    public void exampleIntToDoubleFunction() {
        IntToDoubleFunction incrementalCosts = time -> 5.1 + 0.15 * time;

        System.out.println(incrementalCosts.applyAsDouble(10));
    }

    public void exampleFunction() {
        Function<String, Integer> wordCount = (String s) -> s.split(" ").length;

        System.out.println(wordCount.apply("dit is een test"));
    }

    public void exampleBiFunction() {
        BiFunction<String, Integer, Boolean> exceedsMaxLength = (s, maxLength) -> {
            int actualLength = s.length();
            return actualLength > maxLength;
        };

        System.out.println(exceedsMaxLength.apply("Hello World", 15));
    }
}

package be.tvde.lambdas.java8_lamba_toolbox.function;

import java.util.function.Function;

/**
 * Created by tomvde on 16/12/2016.
 */
public class FunctionApp {

    public static void main(String[] args) {
        FunctionApp app = new FunctionApp();

        app.functionExample1();
        app.performCalculation((n) -> { return "" + n * 4; }, 99);

    }

    private void functionExample1() {
        Function<Integer, String> converter = (i) -> Integer.toString(i);

        System.out.println(converter.apply(3).toUpperCase());
    }

    private void performCalculation(Function<Integer, String> calculation, Integer i) {
        String s = calculation.apply(i);

        System.out.println(s);
    }
}

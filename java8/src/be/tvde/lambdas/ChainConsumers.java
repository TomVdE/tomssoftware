package be.tvde.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by tomvde on 30/11/2016.
 */
public class ChainConsumers {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four");

        List<String> result = new ArrayList<String>();


        Consumer<String> printConsumer = System.out::println;
        Consumer<String> addConsumer = s -> result.add(s);

        strings.forEach(printConsumer.andThen(addConsumer));
    }
}

package be.tvde.app.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by tomvde on 28/11/2016.
 */
public class ForEach {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");

        List<String> result = new ArrayList<>();
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = s -> result.add(s);

        strings.forEach(c1.andThen(c2));

        System.out.println("size of result: " + result.size());


    }
}

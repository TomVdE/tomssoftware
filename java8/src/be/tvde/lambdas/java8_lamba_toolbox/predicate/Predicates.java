package be.tvde.lambdas.java8_lamba_toolbox.predicate;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by tomvde on 28/11/2016.
 */
public class Predicates {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = (String s) -> s.length() > 10;

        Predicate<String> p3 = p1.and(p2);

        Predicate<String> p4 = p1.negate();


        System.out.println(p4.test("Hello"));

    }
}

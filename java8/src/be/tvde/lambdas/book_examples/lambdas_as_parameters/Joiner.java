package be.tvde.lambdas.book_examples.lambdas_as_parameters;

/**
 * Created by tomvde on 22/12/2016.
 */
@FunctionalInterface
public interface Joiner {
    String join(String s1, String s2);
}

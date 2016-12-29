package be.tvde.lambdas.book_examples.method_references;

/**
 * Created by tomvde on 23/12/2016.
 */
public interface Priced {

    default double getPrice() {
        return 1.0;
    }
}

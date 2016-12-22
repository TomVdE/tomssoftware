package be.tvde.lambdas.book_examples;

import java.util.Comparator;

/**
 * Created by tomvde on 22/12/2016.
 */
public class Examples {

    public static void main(String[] args) {
        StringToIntMapper mapper = (String str) -> ((str == null || str.length() == 0) ? 0 : str.length());
    }
}

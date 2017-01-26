package be.tvde.lambdas.data_processing;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tomvde on 12/01/2017.
 */
public class ListApp {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("tom", "sofie", "romy", "fil", "maria");

        names.replaceAll(String::toUpperCase);
        names.sort(Comparator.comparing);
    }
}

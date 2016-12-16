package be.tvde.lambdas.example3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tomvde on 25/11/2016.
 */
public class ComparatorLambda {
    public static void main(String[] args) {
        //annonymous class implementation
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, comparator);
        for (String s: list) {
            System.out.println(s);
        }



        //lamba implementation
        Comparator<String> comparatorLambda = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };
        List<String> list1 = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list1, comparator);
        list1.forEach(System.out::println);
    }
}

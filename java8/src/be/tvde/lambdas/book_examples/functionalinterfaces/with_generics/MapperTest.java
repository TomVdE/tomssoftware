package be.tvde.lambdas.book_examples.functionalinterfaces.with_generics;

/**
 * Created by tomvde on 22/12/2016.
 */
public class MapperTest {

    public static void main(String[] args) {
        String[] names = {"tvde", "svde", "fvde", "rl", "mt" };

        int[] lengthMapping = Mapper.mapToInt(names, (String name) -> name.length());
        printMapping(names, lengthMapping);

        Integer[] numbers = {7, 3, 67};
        int [] countMapping = Mapper.mapToInt(numbers, (Integer n) -> n * n);
        printMapping(numbers, countMapping);
    }

    public static void printMapping(Object[] from, int[] to) {
        for (int i = 0; i < from.length; i++) {
            System.out.println(from[i] + " mapped to " + to[i]);
        }

    }
}

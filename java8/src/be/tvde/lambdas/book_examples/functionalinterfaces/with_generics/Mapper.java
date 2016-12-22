package be.tvde.lambdas.book_examples.functionalinterfaces.with_generics;

/**
 * Created by tomvde on 22/12/2016.
 */
@FunctionalInterface
public interface Mapper<T> {

    //Abstract method
    int map(T source);

    //static method with generics
    /*
        accepts an array of type U and a Mapper of a type that is U itself
        or a supertype of U
     */
    public static <U> int[] mapToInt(U[] list, Mapper<? super U> mapper)  {
        int[] mappedValues = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            //Map the object to an int
            mappedValues[i] = mapper.map(list[i]);
        }
        return mappedValues;
    }
}

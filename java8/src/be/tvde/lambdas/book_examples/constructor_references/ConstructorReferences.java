package be.tvde.lambdas.book_examples.constructor_references;

import be.tvde.lambdas.book_examples.method_references.Item;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by tomvde on 24/12/2016.
 */
public class ConstructorReferences {

    public static void main(String[] args) {
        ConstructorReferences cr = new ConstructorReferences();

        Supplier<String> s = () -> new String();
        //empty String
        System.out.println(s.get());
        Supplier<String> s1 = String::new;
        //empty String
        System.out.println(s1);


        Function<String, String> f = helloWorld -> new String(helloWorld);
        System.out.println(f.apply("hello world"));
        Function<String, String> f1 = String::new;
        System.out.println(f1.apply("test with constructor reference"));


        BiFunction<String, Double, Item> itemFunction = (name, price) -> new Item(name, price);
        System.out.println(itemFunction.apply("Article 1", 27.12));

        BiFunction<String, Double, Item> itemFunction1 = Item::new;
        System.out.println(itemFunction1.apply("Article2", 99.99));

        Supplier<Item> func1 = Item::new;
        Function<String,Item> func2 = Item::new;
        BiFunction<String,Double, Item> func3 = Item::new;
        System.out.println(func1.get());
        System.out.println(func2.apply("Apple"));
        System.out.println(func3.apply("Apple", 0.75));


    }
}

package be.tvde.lambdas.book_examples.method_references;

import be.tvde.date_time_api.Person;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by tomvde on 24/12/2016.
 */
public class Possibilities {

    public static void main(String[] args) {
        Possibilities p = new Possibilities();

        p.exampleStaticMethodReferences();

        p.exampleInstanceMethodReferences();

        p.exampleSupertypeInstanceMethodReference();
    }

    private void exampleSupertypeInstanceMethodReference() {
        //General syntax TypeName.super::instanceMethod
        //keyword super is used as a qualifier to invoke the overridden method in a class or an interface
        //keyword super is only available in an INSTANCE CONTEXT

        //See ItemTest.java

    }

    private void exampleInstanceMethodReferences() {
        //General syntax is one of the following:
        //  - objectRef::instanceMethod (bound receiver)
        //Supplier<Integer> supplier = () -> "Tom".length();
        Supplier<Integer> supplier = "Tom"::length;
        System.out.println(supplier.get());

        //Consumer<String> c = (s) -> System.out.println(s);
        Consumer<String> c = System.out::println;
        c.accept("HelloWorld");

        //  - ClassName::instanceMethod (unbound receiver)
        //Function<Person, String> fNameFunc = (Person p) -> p.getName();
        Function<Person, String> fNameFunc = Person::getName;
        System.out.println(fNameFunc.apply(new Person("tvde", null)));


        String greeting = "Hello";
        String name = " Tom";
        // BiFunction<String, String, String> func1 = (s1, s2) -> s1.concat(s2);
        // Uses an instance method reference on an unbound receiver
        BiFunction<String, String, String> func2 = String::concat;
        System.out.println(func2.apply(greeting, name));



    }

    public void exampleStaticMethodReferences() {
        //General syntax TypeName::staticMethod
        Function<Integer, String> f = Integer::toBinaryString;
        System.out.println(f.apply(17));

        BiFunction<Integer, Integer, Integer> bif = Integer::sum;
        System.out.println(bif.apply(17, 57));


        //Integer class has several valueOf() overloaded methods:
        // static Integer valueOf(int i);
        // static Integer valueOf(String s);
        // static Integer valueOf(String s, int radix);
        //Compiler can determine which version we want based on the abstract method type
        //of the functional interface
        Function<Integer, Integer> f1 = Integer::valueOf;
        System.out.println(f1.apply(17));
        Function<String, Integer> f2 = Integer::valueOf;
        System.out.println(f2.apply("99"));
        BiFunction<String, Integer, Integer> f3 = Integer::valueOf;
        System.out.println(f3.apply("10011", 2));

    }
}

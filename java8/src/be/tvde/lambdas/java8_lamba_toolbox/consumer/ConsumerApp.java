package be.tvde.lambdas.java8_lamba_toolbox.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer<T> represents an operation that accepts a single input argument and returns no result
 *
 */
public class ConsumerApp {

    public static void main(String[] args) {
        ConsumerApp app = new ConsumerApp();

        app.consumerExample1();


        List<Student> students = Arrays.asList(
                new Student("John", "Kerstraat"),
                new Student("Mark", "Stationstraat")
        );
        Consumer<Student> printer = (student) -> System.out.println(student);
        app.consumeAllStudents(students, printer);

    }

    /**
     *
     */
    private void consumerExample1() {
        Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
        c.accept("Dit is een TEST");
    }

    private void consumeAllStudents(List<Student> students, Consumer<Student> printer) {
        students.forEach(printer);
    }
}

class Student {
    private String name;
    private String street;

    public Student(String name, String street) {
        this.name = name;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

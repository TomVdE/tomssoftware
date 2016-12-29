package be.tvde.date_time_api;

import java.time.LocalDate;

/**
 * Created by tomvde on 22/12/2016.
 */
public class Person {
    private String name;
    private LocalDate dateOfBirth;

    public Person() { }

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

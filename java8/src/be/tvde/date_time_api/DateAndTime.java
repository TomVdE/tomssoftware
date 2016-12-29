package be.tvde.date_time_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by tomvde on 22/12/2016.
 */
public class DateAndTime {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            DateAndTime.class.getResourceAsStream("people.txt")
                    )
            );

            Stream<String> stream = reader.lines();
        ) {
            Function<String, Person> f = (String line) -> {
                String[] s = line.split(" ");
                String name = s[0].trim();
                int year = Integer.parseInt(s[1]);
                Month month = Month.of(Integer.parseInt(s[2]));
                int day = Integer.parseInt(s[3]);
                Person p = new Person(name, LocalDate.of(year, month, day));
                persons.add(p);
                return p;
            };
            stream.map(f).forEach(System.out::println);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }

    }
}

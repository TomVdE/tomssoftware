package be.tvde.date_time_api;

import java.time.*;

/**
 * Created by tomvde on 22/12/2016.
 */
public class InstantTest {


    public static void main(String[] args) throws InterruptedException {

        //Concept of Instant (point in time, with nano precision)
        System.out.println(Instant.now());

        Instant now = Instant.now();

        System.out.println(Instant.MAX.toString()); //31/12 23:59:59:999 1 billion years in the future
        System.out.println(Instant.MIN.toString()); //01/01 00:00:00:000 1 billion years ago

        Instant start = Instant.now();
        for (int i = 0; i < 10; i++) {
            //System.out.println(i);
            Thread.sleep(100);
        }

        Instant end = Instant.now();

        //Concept of Duration (amount of time between 2 instants)
        Duration elapsed = Duration.between(start,end);
        System.out.println(elapsed.toMillis());
        elapsed.minusMillis(15);
        elapsed.plusMillis(15);

        //LocalDate (point in time, day precision)
        LocalDate now1 = LocalDate.now();
        System.out.println(now1.toString());
        LocalDate dateofBirth = LocalDate.of(1564, Month.APRIL, 23);

        //Period (amount of time between 2 LocalDates
        Period p = dateofBirth.until(now1);
        System.out.println("# years = " + p.getYears());


    }
}

package be.tvde.innerclasses.member_inner_classes;

/**
 * Created by tomvde on 22/12/2016.
 */
public class Car {

    private int year;

    //Member inner class
    public class Tire {
        private double radius;

        public Tire(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    } //Member inner class declaration ends here

    public Car(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
/*
fqcn for Car: be.tvde.member_inner_classes.Car
fqcn for Tire: be.tvde.member_inner_classes.Car.Tire

Tire is declared public --> you can use its name outside Car class
Tire class' constructor is declared public --> you can create an object of Tire outside the Car class

You must have an object of Car before you can create an object of Tire!
 */

package be.tvde.innerclasses.member_inner_classes;

/**
 * Created by tomvde on 22/12/2016.
 */
public class UseCar {

    public static void main(String[] args) {
        Car c = new Car(2017);

        //General syntax: OuterClassReference.new MemberInnerClassConstructor()
        Car.Tire t = c.new Tire(15);
    }
}

package be.tvde.lambdas.book_examples.method_references;

import java.util.function.Supplier;

/**
 * Created by tomvde on 23/12/2016.
 */
public class Item implements Priced {

    private String name = "Unknown";
    private double price = 0.0;

    public Item() {
        System.out.println("Constructor Item() called");
    }

    public Item(String name) {
        this.name = name;
        System.out.println("Constructor Item(String) called");
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("constructor Item(String, double called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void test() {
        Supplier<String> s1 = this::toString;
        System.out.println("this::toString: " + s1.get());

        Supplier<String> s2 = Item.super::toString;
        System.out.println("Item.super::toString: " + s2.get());

        Supplier<Double> s3 = this::getPrice;
        System.out.println("this::getPrice: " + s3.get());

        Supplier<Double> s4 = Priced.super::getPrice;
        System.out.println("Priced::getPrice: " + s4.get());
    }
}

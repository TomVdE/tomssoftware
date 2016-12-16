package be.tvde.app.lambdas.supplier;

import java.util.function.Supplier;

/**
 * Created by tomvde on 28/11/2016.
 */
public class SupplierApp {
    public static void main(String[] args) {
        System.out.println(maker(Employee::new));
    }

    private static Employee maker(Supplier<Employee> fx) {
        return fx.get();
    }
}

class Employee {
    @Override
    public String toString() {
        return "A EMPLOYEE";
    }
}

package be.tvde.innerclasses.effectively_final_variables;

/**
 * Created by tomvde on 29/12/2016.
 */
public class AccessingLocalVariables {

    public static void main(String[] args) {
        int x = 100;
        final int y = 200;

        class LocalInner {
            void print() {
                // Accessing the local varibale x is fine as
                // it is effectively final.

                System.out.println("x = " + x);

                // The local variable y is effectively final as
                // it has been declared final.
                System.out.println("y = " + y);


            }
        }

        /* Uncommenting the following statement will make the variable x no longer
           an effectively final variable and the LocalIneer class wil not compile.
           Following line would be possible only if local variable x is not referenced in the
           LocalInner class
        */
        //x = 100;
        LocalInner li = new LocalInner();
        li.print();
    }
}

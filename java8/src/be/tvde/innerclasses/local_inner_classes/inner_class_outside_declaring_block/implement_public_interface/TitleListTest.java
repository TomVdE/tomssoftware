package be.tvde.innerclasses.local_inner_classes.inner_class_outside_declaring_block.implement_public_interface;

import java.util.Iterator;

/**
 * Created by tomvde on 24/12/2016.
 */
public class TitleListTest {

    public static void main(String[] args) {
        TitleList tl = new TitleList();
        // Add two titles
        tl.addTitle("Beginning Java 8");
        tl.addTitle("Scripting in Java");

        Iterator iterator = tl.titleIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

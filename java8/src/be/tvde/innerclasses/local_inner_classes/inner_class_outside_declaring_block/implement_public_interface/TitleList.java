package be.tvde.innerclasses.local_inner_classes.inner_class_outside_declaring_block.implement_public_interface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by tomvde on 24/12/2016.
 */
public class TitleList {

    private ArrayList<String> titleList = new ArrayList<>();

    public void addTitle (String title) {
        titleList.add(title);
    }

    public void removeTitle(String title) {
        titleList.remove(title);
    }

    public Iterator<String> titleIterator() {
        // A local inner class - TitleIterator
        //
        class TitleIterator implements Iterator<String> {
            int count = 0;

            @Override
            public boolean hasNext() {
                return (count < titleList.size());
            }

            @Override
            public String next() {
                return titleList.get(count++);
            }
        }// Local Inner Class TitleIterator ends here

        // Create an object of the local inner class and return the reference
        TitleIterator titleIterator = new TitleIterator();
        return titleIterator;       }
}

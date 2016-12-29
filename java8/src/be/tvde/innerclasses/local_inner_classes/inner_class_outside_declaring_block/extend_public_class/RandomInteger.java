package be.tvde.innerclasses.local_inner_classes.inner_class_outside_declaring_block.extend_public_class;

import java.util.Random;

/**
 * Created by tomvde on 27/12/2016.
 */
public class RandomInteger {

    protected Random rand = new Random();

    public int getValue() {
        return rand.nextInt();
    }
}

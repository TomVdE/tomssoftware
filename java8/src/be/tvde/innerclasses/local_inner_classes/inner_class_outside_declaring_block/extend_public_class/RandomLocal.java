package be.tvde.innerclasses.local_inner_classes.inner_class_outside_declaring_block.extend_public_class;

/**
 * Created by tomvde on 27/12/2016.
 */
public class RandomLocal {

    public RandomInteger getRandomInteger() {

        //Local inner class that inherits from RandomInteger
        class RandomIntegerLocal extends RandomInteger {
            @Override
            public int getValue() {
                //Get 2 random integer and
                //return the average ignoring the fraction part
                long n1 = rand.nextInt();
                long n2 = rand.nextInt();

                int value = (int) ((n1 + n2)/2);
                return value;
            }
        }// end Local inner class

        return new RandomIntegerLocal();

    }
}

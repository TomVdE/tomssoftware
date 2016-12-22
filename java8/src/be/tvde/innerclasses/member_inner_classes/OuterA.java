package be.tvde.innerclasses.member_inner_classes;

/**
 * Created by tomvde on 22/12/2016.
 */
public class OuterA {

    public class InnerA {
        public class InnerAA {
            public class InnerAAA{

            }
        }
    }
}

class UseOuterA {
    public static void main(String[]args){
        OuterA outerA = new OuterA();

        OuterA.InnerA innerA = outerA.new InnerA();
        OuterA.InnerA.InnerAA innerAA = innerA.new InnerAA();
        OuterA.InnerA.InnerAA.InnerAAA innerAAA = innerAA.new InnerAAA();

    }
}

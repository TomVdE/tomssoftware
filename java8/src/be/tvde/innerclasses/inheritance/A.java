package be.tvde.innerclasses.inheritance;

/**
 * Created by tomvde on 29/12/2016.
 */
public class A {

    public class B {

    }

    //Inner class C extends from inner class B
    public class C extends B {

    }

    //Inner class D extends from top level class A
    public class D extends A {

    }
}

class E extends A {
    public class F extends B {

    }
}

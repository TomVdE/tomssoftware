lambda is of type 'functional interface'
a lambda is an instance of a functional interface --> lambda != a method

function interface:
    - an interface with only one ABSTRACT method
    - methods from the Object class don't count ex. equals(Object o)

    - can be annotated with @FunctionalInterface --> compile time checking


A lambda can be put in a variable
    - lamba's can be taken as a method parameter
    - lamba's can be returned by a method
    - lambda's can be moved around in the code

!! a lamba expression is created without using new:
    - instantiating process is less heavy (less overhead) (static initializer blocks, instance initializer blocks,µ
                                                                constructor)
    - lamba is an object without an identity --> do not treat it as a normal object
                                                        - don't call toString(), getClass(), equals(), hashCode(), ...
                                                        - just use it as a piece of code


Why do we need lambda's?
========================

O.O. programming: objects containing state and behavior

Each method invocation (behavior) can potentially modify state of the object --> side effects
Program state depends on the order in which code is executed.
Mutating objects cause challenges in parallel programming (concurrent) ex. processing big data volumes

Functional programming is therefor more useful in concurrent, prallel and event-driven programming

Functions do not modify data, including its input --> no side-eefects --> order of execution of functions
    does not matter in functional programming

Prior to Java 8 you had to use anonymous classes which can do the some but more elaborate syntax.


Syntax
======

(<LambdaParametersList>) -> { <LambdaBody> }

Body of Lambda may
    declare local variables,
    use statements including break, continue and return
    throw exceptions
    ...

Lambda expressions
    do not have a name
    do not have a return type --> inferred by compiler
    do not have a throws clause --> inferred by compiler
    can not declare type paramters = no generics

Where lambda's can be used
==========================

- assignment context: lambda expression may appear to the right-hand side of the assignment operator
    ReferenceType variable1 = LambdaExpression;
- method invocation context: lambda expression may appear as an argument to a method or constructor call
    referenceVariable.method(LambdaExpression); --> util.handleJoiner(LambdaExpression);
- return context: lambda expression may appear in a return statement inside a method
    return LambdaExpression
- Cast Context: lambda expression may be used if it is preceded by a cast
    (Joiner) LambdaExpression

Functional Interface
====================

Have EXACTLY 1 abstract method.
Following methods do not count:
    - static methods
    - default methods
    - public methods inherited from the Object class (equals() ...)

Example: Comparator interface:
            has serveral default methods --> don't count
            has serveral static methods --> don't count
            has boolean equals(Object obj) method --> re-declaration of equals() method in the object class
                so don't count although it is an abstrct method!

@FunctionalInterface
====================
Optional -> if you omit, your interface still can be a functional interface

Adding the annotation -> protects you from changing a functional interface into a non-functional interface
Annotation only usable on an interface, not on a class!!

Functional interfaces can be generic:

    example from the jdk

    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);
    }


    Own example:

    @FunctionalInterface
    public interface Processor {
        <T> void process(T[] list;
    }

!!!Lambda expression cannot declare type parameters and therefore, it cannot have a target type whose
abstract method is generic!!!
In such case, you need to use a method reference OR anonymous class
inner class = class declared within another class (= outer class)
    if inner class is explicitly or implicitly declared static --> nested class

inner class can be enclosing class for another inner class --> no limit on the level of nesting

- instance of inner class can only exist within an instance of its eclosing class
    --> you must have an instance of the enclosing class before you can create an instance of an inner class.
    --> usefull to enforce rule that one object cannot exist without the other
        ex. a processor cannot exist without a computer
            president cannot exist without company
- inner class has full access to all members, including private memebers, of its enclosing class

Member inner class
------------------

Declared inside a class the same way a member field or member method is declared
Can be declared public/private/protected or package-level
Instance of inner class can only exist within the instance of its enclosing class

Local inner class
-----------------

Declared inside a block, ex.:
    inside a method
    inside a static initializer block
    inside a non-static initializer block
    inside a constructor

Its scope is limited to the block in which declared
No use of public, private, protected


Example see TitleList:
    titleIterator() declares local inner class TitleIterator.
    This local class can use the private instance variable titleList of its enclosing class

public class SomeTopLevelClass {
       // Some code for SomeTopLevelClass goes here
       public void someMethod() {
            class SomeLocalInnerClass {
                // Some code for SomeLocalInnerClass goes here
            }

            // SomeLocalInnerClass can only be used here
       }
}

someMethod() method of SomeTopLevelClass declares the SomeLocalInnerClass local inner class.
The name of the local inner class, SomeLocalInnerClass, can only be used inside the someMethod() method.
This implies that objects of the SomeLocalInnerClass can only be created and used inside the someMethod() method.
This limits the use of a local inner class to only being used inside its enclosing block—in your case the someMethod() method.

To use a local inner class outside its enclosing block, the local inner class must do one or both of the following:

    - Implement a public interface
    - Inherit from another public class and override some of its superclass methods

The name of the interface or another class must be available outside the enclosing block that defines the local inner class.


Anonymous inner class
---------------------

The same as a local inner class with one difference: it does not have a name.
Since it does not have a name, it cannot have a constructor.

An anonymous class is a one-time class => definition + creation at the same time => You cannot create more than one
object of an anonymous class.

new <interface-name or class-name> (<argument-list>) {
       // Anonymous class body goes here
}

The <argument-list> is used only if the new operator is followed by a class name.
It is left empty if the new operator is followed by an interface name.
If <argument-list> is present, it contains the actual parameter list for a constructor of the existing
class to be invoked.

The above syntax can be broken into two for simplicity: the first syntax is used when the anonymous class implements
an interface and the second one is used when it inherits a class.

new Interface() {
    // Anonymous class body goes here
}
and
new Superclass(<argument-list-for-a-superclass-constructor>) {
       // Anonymous class body goes here
}

You can use an instance initializer:

new Object() {
       // An instance initializer
       {
            System.out.println ("Hello from an anonymous class.");
       }
}

Since an anonymous inner class is the same as a local class without a class name.

Static Member Class != an Inner Class
-------------------------------------

A member class defined within the body of another class may be declared static.

A static member class is not an inner class. It is considered a top-level class. It is also called a nested
top-level class. Since it is a top-level class, you do not need an instance of its enclosing class to create
its object.
An instance of class A and an instance of class B can exist independently because both are top-level classes.
A static member class can be declared public, protected, package-level,
or
private to restrict its accessibility outside its enclosing class.

What is the use of a static member class if it is nothing but another top-level class? 2 advantages:

- A static member class can access the static members of its enclosing class including the private static members.
In your example, if class A has any static members, those static members can be accessed inside class B.
However, class B cannot access any instance members of class A because an instance of class B can exist without
an instance of class A.

- A package acts like a container for top-level classes by providing a namespace. Within a namespace, all entities
must have unique names. Top-level classes having static member classes provide an additional layer of namespaces.
A static member class is the direct member of its enclosing top-level class, not a member of the package in which
it is declared.

Creating Objects of Inner Classes
---------------------------------

- Objects of a local inner class are created using the new operator inside the block, which declares the class.
- An object of an anonymous class is created at the same time the class is declared
- A static member class is another type of top-level class. You create objects of a static member class the same way you
create objects of a top-level class.

An instance of a member inner class always exists within an instance of its enclosing class. The new operator is used
to create the instance of the member inner class with a slightly different syntax. The general syntax to create an
instance of a member inner class is as follows:

OuterClassReference.new MemberInnerClassConstructor()

See OuterA.java and UserCar.java

Accessing Enclosing Class Members
---------------------------------

An inner class has access to all instance members, instance fields, and instance methods of its enclosing class.

See Outer + OuterTest
See Outer2 + Outer2Test

Restrictions on Accessing Local Variables
-----------------------------------------

A local inner class is declared inside a block—typically inside a method of a class. A local inner class can access
the instance variables of its enclosing class as well as the local variables, which are in scope.

The instance of an inner class exists within an instance of its enclosing class. Therefore, accessing the instance
variables of the enclosing class inside a local inner class is not a problem because they exist throughout the life
cycle of the instance of the local inner class.

The local variables in a method exist only during the execution of that method. All local variables become inaccessible
when method execution is over.
Java makes a copy of the local variables that are used inside a local inner class and stores that copy along with the
inner class object.
To guarantee that the values of the local variables can be reproduced when accessed inside the local inner class code
after the method call is over, Java puts a restriction that the local variables must be EFFECTIVELY FINAL.
An effectively final variable is a variable whose value does not change after it is initialized.
One way to have an effectively final variable is to declare the variable final.
Another way is not to change its value after it is initialized.

Therefore, a local variable or an argument to a method must be effectively final if it is used inside a local inner
class. This restriction also applies to an anonymous inner class declared inside a method.

See AccessingLocalVariables.java

Inner Class and Inheritance
---------------------------

An inner class can inherit from another inner class, a top-level class, or its enclosing class

No static Members in an Inner Class
-----------------------------------

The keyword static in Java makes a construct a top-level construct. Therefore, you cannot declare any static members
(fields, methods, or initializers) for an inner class.

However, it is allowed to have static fields in an inner class that are compile-time constants.

Closures and Callbacks
----------------------

In functional programming, a higher order function is an anonymous function that can be treated as a data object.
That is, it can be stored in a variable and passed around from one context to another. It might be invoked in a
context that did not necessarily define it. Note that a higher order function is an anonymous function, so the invoking
context does not have to know its name.

A closure is a higher order function packaged with its defining environment. A closure carries with it the variables
in scope when it was defined, and it can access those variables even when it is invoked in a context other than the
context in which it was defined.

In object-oriented programming, a function is called a method and it is always part of a class. An anonymous class in
Java allows a method to be packaged in an object that can be treated much as a higher order function. The object can be
stored in a variable and passed around from one method to another. The method defined in an anonymous class can be
invoked in a context other than the one in which was defined. However, one important difference between a higher order
function and a method defined in an anonymous class is that a higher order function is anonymous, whereas a method in
an anonymous class is named. The invoker of the anonymous class method must know the method name. An anonymous class
carries with it its environment. An anonymous class can use the local variables and the parameters of a method
inside which it is defined. However, Java places a restriction that local variables and parameters to the method must
be effectively final if they are accessed inside an anonymous class.








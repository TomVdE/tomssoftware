lamba is of type 'functional interface'

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






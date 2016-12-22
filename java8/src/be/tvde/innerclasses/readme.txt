inner class = class declared within another class (= outer class)
    if inner class is explicitly or implicitly declared static --> nested class

inner class can be enclosing class for another inner class --> no limit on the level of nesting

- instance of inner class can only exist within an instance of its eclosing class
    --> you must have an instance of the enclosing class before you can create an instance of an inner class.
    --> usefull to enforce rule that one object cannot exist without the other
        ex. a processor cannot exist without a computer
            president cannot exist without company
- inner class has full access to all members, including private memebers, of its enclosing class






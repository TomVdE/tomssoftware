//example of revealing module pattern

//disadvantage here is that we are creating global 
//variables: createWorker and worker  = they live in the 
//global scope = defined outside any function

//in other languages global variables are bad practise because they are 
//source to confusion.
//In JavaScript these are even worse. Because JavaScript is not strongly typed, 
//you can easily redefine/overwrite global variables without you noticing it.

//createWorker function creates what is called in JavaScript a scope
//variables defines inside that function (workCount, task1, task2) are 
//only visible inside the function (not visible outside createWorker)

//==> try to avoid global variables --> surround these code with one more function
//see script1.js
var createWorker = function() {
    //private implementation details
    var workCount = 0;

    var task1 = function() {
        workCount++;
        console.log("task 1 " + workCount);
    };

    var task2 = function() {
        workCount++;

        console.log("task 2 " + workCount);
    };
    //end private implementation details

    //public api -> object literal notation
    return {
        job1: task1,
        job2: task2,
        job3: function() {
            console.log("task 3");
        }
    };
};

var worker = createWorker();

worker.job1();
worker.job2();
worker.job3();
worker.job2();

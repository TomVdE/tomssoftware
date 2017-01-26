var program = function() {


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
}

program();
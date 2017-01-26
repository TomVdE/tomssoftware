(function() {
    var app = angular.module("githubViewer", []);
    //if you omit the 2nd argument, you would write
    //var app = angular.module("githubViewer");
    //with this line, you ask a reference to that module, which would only work
    //if someone else would already have defined the module

    var MainCtrl = function($scope, github, $interval, $log, $anchorScroll, $location) {
        var onUserComplete = function(data) {
            $scope.user = data;
            
            github.getRepos($scope.user).then(onRepos, onError);
        };

        var onError = function(reason) {
            $scope.error = "Could not fetch the data";
        };

        var onRepos = function(data) {
            $scope.repos = data;
            //$scope.user.repos = response.data; would also be possible
            $location.hash("userDetails");
            $anchorScroll();
        };

        var decrementCountdown = function() {
            $scope.countdown -= 1;
            if ($scope.countdown < 1) {
                $scope.search($scope.username);
            }
        }

        var countdownInterval = null;
        var startCountdown = function() {
            //interval is a service, but must be used as a function (angular knows different types of services)   
            countdownInterval = $interval(decrementCountdown, 1000, 5); //5 ticks and stop
        }

        //JavaScript object literal syntax
        var person = {
            firstName: 'Tom',
            lastName: 'VdE'
        };

        $scope.username = "angular";
        $scope.message = 'Github Viewer';
        $scope.person = person;
        $scope.search = function(username) {
            $log.info("Searching for " + username);
            github.getUser(username).then(onUserComplete, onError);

            if (countdownInterval) {
                $interval.cancel(countdownInterval);
                $scope.countdown = null;
            }
        }
        $scope.repoSortOrder = '-stargazers_count';
        $scope.countdown = 5;

        $scope.helloWorld = function() {
            alert('You just double clicked');
        };

        startCountdown();
    };

    app.controller("MainCtrl", ["$scope", "github", "$interval", "$log", "$anchorScroll", "$location", MainCtrl]);
}());


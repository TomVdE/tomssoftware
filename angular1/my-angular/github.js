(function() {
    //create the service -> if this function gets invoked (by angular), it returns 
    //an object with the public api = REVEALING MODULE design pattern
    var github = function($http) {  //our github service has a dependency on the http service

        //here go the implementation details
        var getUser = function(username) {
            //var getUserPromis = $http.get("https://api.github.com/users/" + username);

            return $http.get("https://api.github.com/users/" + username)
                    .then(function(response) {
                        return response.data; //whatever you return here, it will be wrapped in a promise by .then
                                                // the caller will receive a promise
                    });
        };

        var getRepos = function(user) {
            return $http.get(user.repos_url)
                    .then(function(response) {
                        return response.data;
                    });
        };

        //the public api
        return {
            getUser: getUser,
            getRepos: getRepos
        };
    };

    //we omitted the 2nd argument, so we ask a reference to the module, 
    //this only work because the module was defined in myAngular.js which is 
    //loaded first in angular.html
    var module = angular.module("githubViewer");
    module.factory("github", github); //1st argument is name of the service, 2nd argument is a reference to a service that returns an object
    
}());
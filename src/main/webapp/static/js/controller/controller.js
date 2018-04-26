'use strict';

App.controller('NBPController', ['$scope', 'NBPservice', function($scope, NBPservice) {
    var self = this;
    self.salary={salary:0};
    self.rate={rate:0};

    $scope.codes= [
        {name:'USD'},
        {name:'EUR'}
    ];
    $scope.myCode = $scope.codes[0];


    self.showRate = function (code, salary) {
        NBPservice.getRate(code, salary)
            .then(
                function (value) {
                    self.rate=value;
                },
                function (err) {
                    console.error('Error');
                }
            );
    };
}]);
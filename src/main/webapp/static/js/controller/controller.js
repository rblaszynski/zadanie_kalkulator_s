'use strict';

App.controller('Controller', ['$scope', 'Service', function($scope, Service) {
    var self = this;

    self.calcResult='Miesięczny zarobek netto: 0 PLN';
    self.salary=0;

    self.showRate = function (code, salary) {
        Service.getRate(code, salary)
            .then(
                function (value) {
                    self.calcResult=value;
                },
                function (err) {
                    console.error('Error');
                }
            );
    };

    self.getCodes = function () {
        Service.getCodes()
            .then(
                function (value) {
                    $scope.codes=value;
                    $scope.myCode=$scope.codes[0];
                },
                function (err) {
                    console.error('Error');
                }
            );
    };

    self.getCodes();
}]);


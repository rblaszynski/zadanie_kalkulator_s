'use strict';

App.factory('Service', ['$http', '$q', function($http, $q){

    var factory =
        {
            getRate : getRate,
            getCodes : getCodes
        };

    return factory;

        function getRate(code, salary) {
            return $http.get('http://localhost:8080/calculate/'+code+'/'+salary)
                .then(
                    function (response)
                    {
                        if(response.data>0) return ('Miesięczny zarobek netto: '+response.data+' PLN');
                        else return ('Miesięczna strata: '+(response.data*-1)+' PLN');
                    },
                    function (err) {
                        console.error('Error');
                        return $q.reject(err);
                    }
                );
        }

        function getCodes() {
            return $http.get('http://localhost:8080/countries/codes')
                .then(
                    function (response)
                    {
                        return response.data;
                    },
                    function (err) {
                        console.error('Error');
                        return $q.reject(err);
                    }
                );
        }
}]);

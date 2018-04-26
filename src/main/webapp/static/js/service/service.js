'use strict';

App.factory('NBPservice', ['$http', '$q', function($http, $q){

    return {
        getRate: function (code, salary) {
            return $http.get('http://localhost:8080/'+code+'/'+salary)
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
    }
}]);

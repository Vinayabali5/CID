(function() {

    angular
        .module('StudentConcessionTypeService', [])
        .factory('StudentConcessionType', StudentConcessionTypeService);

    StudentConcessionTypeService.$inject = ['$http', 'GLOBAL'];

    function StudentConcessionTypeService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/students/';

        var factory = {
            query: function() {
                return $http.get(url);
            },
            get: function(studentId) {
                if (studentId) {
                    return $http.get(url + studentId + '/concessionTypes');
                } else {
                    return null;
                }
            },
            save: function(studentConcessionType, callback) {
                if (studentConcessionType && studentConcessionType.studentId) {
                    return $http.put(url + studentConcessionType.studentId + '/concessionTypes', studentConcessionType).then(function(response) {
                        if (callback) {
                            callback();
                        }
                        return response.data;
                    }, function(response) {
                        return {
                            status: response.status,
                            error: response.data
                        };
                    });
                } else {
                    return null;
                }
            }
        };
        return factory;
    }

}());

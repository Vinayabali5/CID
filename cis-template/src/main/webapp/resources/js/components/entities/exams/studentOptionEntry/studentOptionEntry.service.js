(function() {

    angular.module('StudentOptionEntryService', [])
        .factory('StudentOptionEntry', StudentOptionEntryService);

    StudentOptionEntryService.$inject = ['$http', 'GLOBAL', 'APP'];

    function StudentOptionEntryService($http, GLOBAL, APP) {
        var self = this;
        var url = GLOBAL.API + '/';

        // Public Interface

        var factory = {
            query: findAll,
            getId: findById,
            create: create,
            save: save,
            delete: deleteByIds,
            getByOptionId: getByIds,
            markExamAmendment: markExamAmendment
        };

        return factory;

        // Private Interface

        function findAll() {
            return $http.get(url + 'studentOptionEntries');
        }

        function findById(studentId) {
            var year = APP.getYear();
            return $http.get(url + 'students/' + studentId + '/optionEntries', {
                params: {
                    yearId: year.id
                }
            });
        }

        function create(studentOptionEntry, callback) {
            if (studentOptionEntry.studentId) {
                return $http.post(url + 'students/' + studentOptionEntry.studentId + '/optionEntries', studentOptionEntry).then(function(response) {
                    if (callback) {
                        callback(response.data);
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

        function save(studentId, examOptionId, data, callback) {
            if (studentId && examOptionId) {
                return $http.put(url + 'students/' + studentId + '/optionEntries/' + examOptionId, data).then(function(response) {
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

        function deleteByIds(studentId, examOptionId, callback) {
            return $http.delete(url + 'students/' + studentId + '/optionEntries/' + examOptionId).then(function(response) {
                if (callback) {
                    callback(response.data);
                }
                return response.data;
            }, function(response) {
                return {
                    status: response.status,
                    error: response.data
                };
            });
        }

        function getByIds(studentId, examOptionId) {
            return $http.get(url + 'students/' + studentId + '/optionEntries/' + examOptionId);
        }

        function markExamAmendment(studentId, callback) {
            return $http.post(url + 'students/' + studentId + '/examAmendmentsRequired').then(function(response) {
                if (callback) {
                    callback(response.data);
                }
                return response.data;
            }, function(response) {
                return {
                    status: response.status,
                    error: response.data
                };
            });
        }

    }

}());

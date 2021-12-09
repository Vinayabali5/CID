/**
 * The ComponentService module for accessing Component data from the REST API
 */
(function() {

    angular
        .module('SeatingPlanService', [])
        .factory('SeatingPlan', SeatingPlanService);

    SeatingPlanService.$inject = ['$http', 'GLOBAL'];

    function SeatingPlanService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/seating-plans/';

        var factory = {
            query: function() {
                return $http.get(url);
            },
            queryByExamComponentId: function(examComponentId) {
                return $http.get(url + 'byComponentId/' + examComponentId);
            },
            get: function(id) {
                if (id) {
                    return $http.get(url + id);
                } else {
                    return null;
                }
            },
            create: function(seatingPlan, callback) {
                if (seatingPlan) {
                    //					return $http.post(urlStudents + seatingPlan.studentId + urlSeatingPlans, seatingPlan).then(function(response) {
                    return $http.post(url + seatingPlan.examRoomId, seatingPlan).then(function(response) {
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
            },
            save: function(seatingPlan, callback) {
                if (seatingPlan && seatingPlan.studentId) {
                    return $http.put(url + seatingPlan.examRoomId, seatingPlan).then(function(response) {
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
            },
            delete: function(seatingPlan, callback) {
                if (seatingPlan && seatingPlan.studentId && seatingPlan.examComponentId) {
                    return $http.delete(url + 'byStudentAndExam/' + seatingPlan.studentId + '/' + seatingPlan.examComponentId).then(function(response) {
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
                }
            }
        };

        return factory;
    }

}());

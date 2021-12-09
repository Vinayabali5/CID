(function() {

    angular
        .module('ExamSessionService', [])
        .factory('ExamSession', ExamSessionService);

    ExamSessionService.$inject = ['$http', 'GLOBAL'];

    function ExamSessionService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/examSessions/';

        var factory = {
            query: function() {
                return $http.get(url);
            },
            get: function(id) {
                if (id) {
                    return $http.get(url + id);
                } else {
                    return null;
                }
            },
            queryByDateAndSession: function(date, session) {
                return $http.get(url + date.getTime() + '/' + session);
            },
            create: function(examSession, callback) {
                if (examSession) {
                    return $http.post(url, examSession).then(function(response) {
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
            save: function(examSession, callback) {
                if (examSession && examSession.id) {
                    return $http.put(url + examSession.id, examSession).then(function(response) {
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

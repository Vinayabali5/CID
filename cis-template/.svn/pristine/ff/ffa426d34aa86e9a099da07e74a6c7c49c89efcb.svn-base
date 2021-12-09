(function() {

    angular
        .module('ExamRoomService', [])
        .factory('ExamRoom', ExamRoomService);

    ExamRoomService.$inject = ['$http', 'GLOBAL'];

    function ExamRoomService($http, GLOBAL) {
        var self = this;
        //var url = GLOBAL.API + '/examRooms/';
        var url = GLOBAL.API + '/seating-plan/';

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
            queryByExamSessionIdAndRoomId: function(sessionId, roomId) {
                return $http.get(url + sessionId + '/' + roomId);
            },
            queryByDateAndSession: function(date, session) {
                return $http.get(url + 'session/' + date.getTime() + '/' + session);
            },
            create: function(examRoom, callback) {
                if (examRoom) {
                    return $http.post(url, examRoom).then(function(response) {
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
            save: function(examRoom, callback) {
                if (examRoom && examRoom.id) {
                    return $http.put(url + examRoom.id, examRoom).then(function(response) {
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
            delete: function(examRoom, callback) {
                if (examRoom && examRoom.id) {
                    return $http.delete(url + examRoom.id);
                } else {
                    return null;
                }
            }

        };

        return factory;
    }

}());

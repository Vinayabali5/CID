(function() {

    angular
        .module('StudentRemarkPermissionService', [])
        .factory('StudentRemarkPermission', StudentRemarkPermissionService);

    StudentRemarkPermissionService.$inject = ['$http', 'GLOBAL'];

    function StudentRemarkPermissionService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/studentRemarkPermissions/';

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
            create: function(studentRemarkPermission, callback) {
                if (studentRemarkPermission) {
                    return $http.post(url, studentRemarkPermission).then(function(response) {
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
            save: function(studentRemarkPermission, callback) {
                if (studentRemarkPermission && studentRemarkPermission.id) {
                    return $http.put(url + studentRemarkPermission.id, studentRemarkPermission).then(function(response) {
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

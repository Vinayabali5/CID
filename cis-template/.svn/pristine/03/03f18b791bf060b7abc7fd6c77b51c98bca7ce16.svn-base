(function() {

    angular
        .module('TutorGroupRemarkPermissionService', [])
        .factory('TutorGroupRemarkPermission', TutorGroupRemarkPermissionService);

    TutorGroupRemarkPermissionService.$inject = ['$http', 'GLOBAL'];

    function TutorGroupRemarkPermissionService($http, GLOBAL) {

        var self = this;
        var url = GLOBAL.API + '/tutorGroups/';

        var factory = {
            query: function() {
                return $http.get(url);
            },

            get: function(tutorGroupId) {
                if (tutorGroupId) {
                    return $http.get(url + tutorGroupId + '/remarkPermissions');
                } else {
                    return null;
                }
            },

            save: function(remarkPermission, tutorGroupId) {
                if (remarkPermission && tutorGroupId) {
                    return $http.post(url + tutorGroupId + '/remarkPermissions', remarkPermission).then(function(response) {
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

(function() {

    angular
        .module('CourseComponentService', [])
        .factory('CourseComponent', CourseComponentService);

    CourseComponentService.$inject = ['$http', 'GLOBAL'];

    function CourseComponentService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/course-components/';

        var factory = {
            query: function() {
                return $http.get(url);
            },

            get: function(courseId, optionId, componentId) {
                if (courseId && optionId && componentId) {
                    return $http.get(url + courseId + "/" + optionId + "/" + componentId);
                } else {
                    return null;
                }
            },

            create: function(courseComponent, callback) {
                if (courseComponent) {
                    return $http.post(url, courseComponent).then(function(response) {
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

            delete: function(courseId, optionId, componentId, callback) {
                if (courseId && optionId && componentId) {
                    return $http.delete(url + courseId + "/" + optionId + "/" + componentId);
                } else {
                    return null;
                }
            }
        };

        return factory;
    }

}());

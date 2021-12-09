(function() {

    angular
        .module('CourseSyllabusService', [])
        .factory('CourseSyllabus', CourseSyllabusService);

    CourseSyllabusService.$inject = ['$http', 'GLOBAL'];

    function CourseSyllabusService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/course-syllabi/';

        var factory = {
            query: function() {
                return $http.get(url);
            },

            get: function(courseId, syllabusId) {
                if (courseId && syllabusId) {
                    return $http.get(url + courseId + "/" + syllabusId);
                } else {
                    return null;
                }
            },

            create: function(courseSyllabus, callback) {
                if (courseSyllabus) {
                    return $http.post(url, courseSyllabus).then(function(response) {
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

            delete: function(courseId, syllabusId, callback) {
                if (courseId && syllabusId) {
                    return $http.delete(url + courseId + "/" + syllabusId);
                } else {
                    return null;
                }
            }
        };

        return factory;
    }

}());

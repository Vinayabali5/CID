/**
 * This is the factory definition for the CourseSpec Data Service. This defines how to handle data about CourseSpec objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CourseSpecService', ['ui-notification'])
        .factory('CourseSpec', courseSpecFactory);

    courseSpecFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'APP', 'Notification'];

    function courseSpecFactory($q, $http, $rootScope, GLOBAL, APP, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/courseSpecs/';

        //Public Interface
        var factory = {
            lookup: lookup,
            valid: valid
        };

        return factory;

        //Private Interface
        /**
         * This method is used to get Course Spec description of an instance of a CourseSpec Id from the API collection.
         * @param  {String} spec of the CourseSpec object that is to be retrieved.
         * @return {CourseSpec} An CourseSpec object as identified by the specId.
         */
        function lookup(spec) {
            var deferred = $q.defer();
            if (spec != undefined && spec != null) {
                $http.get(url + spec).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-spec-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
            } else {
                deferred.reject({
                    message: "No ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to check if the Course Spec id valid or not.
         * @param  {String} spec of the CourseSpec object that is to be verified.
         * @return {CourseSpec} An CourseSpec object as identified by the spec.
         */
        function valid(spec) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (spec != undefined && spec != null) {
                $http.get(url + spec + '/valid', {
                    params: {
                        academicYearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-spec-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
            } else {
                deferred.reject({
                    message: "No ID Supplied"
                });
            }
            return deferred.promise;
        }
    }
})();

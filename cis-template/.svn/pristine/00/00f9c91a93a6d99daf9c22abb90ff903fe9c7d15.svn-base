/**
 * This is the factory definition for the StudentWarning Data Service. This defines how to handle data about StudentWarning objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentWarningService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentWarning', studentWarningFactory);

    studentWarningFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification', 'APP'];

    function studentWarningFactory($q, $http, $rootScope, GLOBAL, Notification, APP) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/students/';

        var factory = {
            query: getAll,
            get: getByStudentId,
            getStudentWarning: getByStudent,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentWarning from the API collection.
         *
         * @return {StudentWarning} An array of StudentWarning objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('studentWarning-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StudentWarning from the API collection.
         * @param  {int} studentId of the StudentWarning object that is to be retrieved.
         * @return {StudentWarning} An StudentWarning object as identified by the studentId.
         */
        function getByStudent(studentId) {
            var deferred = $q.defer();
            year = APP.getYear();
            if (studentId !== null) {
                $http.get(url + studentId + '/warning-code-changes', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-warning-code-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentWarning from the API collection.
         * @param  {int} studentId of the StudentWarning object that is to be retrieved.
         * @return {StudentWarning} An StudentWarning object as identified by the studentId.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            year = APP.getYear();
            if (studentId !== null) {
                $http.get(url + studentId + '/warnings', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-warning-by-studentId-loaded', response.data);
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
         * This method is used to save changes to an existing StudentWarning object.
         *
         * @param  {StudentWarning} studentWarning An StudentWarning object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentWarning data is provided then the method returns null.
         */
        function save(studentWarning, callback) {
            var deferred = $q.defer();
            if (studentWarning && studentWarning.studentId) {
                $http.put(url + studentWarning.studentId + '/warnings', studentWarning).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('studentWarning-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            }
            return deferred.promise;
        }
    }
})();

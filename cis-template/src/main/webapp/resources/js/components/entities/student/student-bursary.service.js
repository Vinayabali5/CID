/**
 * This is the factory definition for the StudentBursary Data Service. This defines how to handle data about StudentBursary objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentBursaryService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentBursary', studentBursaryFactory);

    studentBursaryFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentBursaryFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/students/';

        var factory = {
            query: getAll,
            get: getByStudentId,
            save: save
        };

        return factory;

        /**
         * This method is used to retrieve all the StudentBursary from the API collection.
         *
         * @return {StudentBursary} An array of StudentBursary objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-bursaries-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a StudentBursary from the API collection.
         * @param  {int} id of the StudentBursary object that is to be retrieved.
         * @return {StudentBursary} An StudentBursary object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + studentId + '/bursary').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-bursary-loaded', response.data);
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
         * This method is used to save changes to an existing StudentBursary object.
         *
         * @param  {StudentBursary} studentBursary An StudentBursary object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentBursary data is provided then the method returns null.
         */
        function save(studentBursary, callback) {
            var deferred = $q.defer();
            if (studentBursary && studentBursary.studentId) {
                $http.put(url + studentBursary.studentId + '/bursary', studentBursary).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-bursary-saved', response.data);
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

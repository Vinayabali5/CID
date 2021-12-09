/**
 * This is the factory definition for the StudentReferralReason Data Service. This defines how to handle data about StudentReferralReason objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentReferralReasonService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentReferralReason', studentReferralReasonFactory);

    studentReferralReasonFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentReferralReasonFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save,
            delete: deleteById,
            getByStudentId: getByStudentId
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentRefferalReason from the API collection.
         *
         * @return {StudentRefferalReason} An array of StudentRefferalReason objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'student-referral-reasons').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-referral-reasons-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentRefferalReason from the API collection.
         * @param  {int} id of the StudentRefferalReason object that is to be retrieved.
         * @return {StudentRefferalReason} An StudentRefferalReason object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'student-referral-reasons/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-referral-reason-loaded', response.data);
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
         * This method is used to retrieve all the StudentReferralReason from the API collection.
         *
         * @return {StudentReferralReason} An array of StudentReferralReason objects.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/student-referral-reasons').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-referral-reason-by-studentId-loaded', response.data);
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
         * This method is used to delete an instance of a StudentReferralReason from the API Collection.
         * @param {int} id of the StudentReferralReason object that is to be deleted.
         * @return {StudentReferralReason} A StudentReferralReason object as identified by the id.
         */
        function deleteById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.delete(url + 'student-referral-reasons/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-referral-reason-deleted', response.data);
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
         * This method is used to create a new instance of an StudentReferralReason object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentReferralReason} studentReferralReason An StudentReferralReason object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentReferralReason data is provided then the method returns null.
         */
        function create(studentReferralReason, callback) {
            var deferred = $q.defer();
            if (studentReferralReason != undefined && studentReferralReason != null) {
                $http.post(url + 'student-referral-reasons', studentReferralReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-referral-reason-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentReferralReason ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentReferralReason object.
         *
         * @param  {StudentReferralReason} StudentReferralReason An StudentReferralReason object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentReferralReason data is provided then the method returns null.
         */
        function save(studentReferralReason, callback) {
            var deferred = $q.defer();
            if (studentReferralReason && studentReferralReason.id) {
                $http.put(url + 'student-referral-reasons/' + studentReferralReason.id, studentReferralReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-referral-reason-saved', response.data);
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

/**
 * This is the factory definition for the ILPInterview Data Service. This defines how to handle data about ILPInterview objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ILPInterviewService', ['ui-notification'])
        .factory('ILPInterview', ilpInterviewFactory);

    ilpInterviewFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function ilpInterviewFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            getById: getById,
            getByStudentId: getByStudentId,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the ILPInterview from the API collection.
         *
         * @return {ILPInterview} An array of ILPInterview objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'ilpInterviews').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('ilpInterviews-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a ILPInterview from the API collection.
         * @param  {int} id of the ILPInterview object that is to be retrieved.
         * @return {ILPInterview} An ILPInterview object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'ilpInterviews/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilpInterview-loaded', response.data);
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
         * This method is used to retrieve an instance of a ILPInterview from the API collection.
         * @param  {int} id of the ILPInterview object that is to be retrieved.
         * @return {ILPInterview} An ILPInterview object as identified by the id.
         */
        function getByStudentId(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'students/' + id + '/ilpInterviews').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilpInterviews-loaded', response.data);
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
         * This method is used to create a new instance of an ILPInterview object in the database by POSTing the
         * required data to the API.
         *
         * @param  {ILPInterview} ILPInterview An ILPInterview object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ILPInterview data is provided then the method returns null.
         */
        function create(ilpInterview, callback) {
            var deferred = $q.defer();
            if (ilpInterview != undefined && ilpInterview != null) {
                $http.post(url + 'ilpInterviews', ilpInterview).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilpInterview-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No ILPInterview ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing ILPInterview object.
         *
         * @param  {ILPInterview} ILPInterview An ILPInterview object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ILPInterview data is provided then the method returns null.
         */
        function save(ilpInterview, callback) {
            var deferred = $q.defer();
            if (ilpInterview && ilpInterview.id) {
                $http.put(url + 'ilpInterviews/' + ilpInterview.id, ilpInterview).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilpInterview-saved', response.data);
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

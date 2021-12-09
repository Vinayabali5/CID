/**
 * This is the factory definition for the Correspondence Data Service. This defines how to handle data about CorrespondenceService objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CorrespondenceService', ['ui-notification'])
        .factory('Correspondence', correspondenceFactory);

    correspondenceFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function correspondenceFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';
        //Public Factory
        var factory = {
            query: getAll,
            get: getByStudentId,
            getId: getById,
            create: create,
            save: save
        };

        return factory;
        //Private Interface
        /**
         * This method is used to retrieve all the Correspondence from the API collection.
         *
         * @return {Correspondence} An array of Correspondence objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('correspondence-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Correspondence from the API collection.
         * @param  {int} studentId of the Correspondence object that is to be retrieved.
         * @return {Correspondence} An Correspondence object as identified by the studentId.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/correspondence').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('correspondence-loaded', response.data);
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
         * This method is used to retrieve an instance of a Correspondence from the API collection.
         * @param  {int} id of the Correspondence object that is to be retrieved.
         * @return {Correspondence} An Correspondence object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'correspondences/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('correspondence-loaded', response.data);
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
         * This method is used to create a new instance of an Correspondence object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Correspondence} correspondence An Correspondence object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Correspondence data is provided then the method returns null.
         */
        function create(correspondence, callback) {
            var deferred = $q.defer();
            if (correspondence != undefined && correspondence != null) {
                $http.post(url + 'correspondences', correspondence).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('correspondence-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Correspondence ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Correspondence object.
         *
         * @param  {Correspondence} correspondence An Correspondence object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Correspondence data is provided then the method returns null.
         */
        function save(correspondence, callback) {
            var deferred = $q.defer();
            $http.put(url + 'correspondences/' + correspondence.id, correspondence).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('correspondence-saved', response.data);
                if (callback) {
                    callback();
                }
            }, function(response) {
                deferred.reject(response);
                Notification.error("Error:" + response.data.message);
            });
            return deferred.promise;
        }
    }
})();

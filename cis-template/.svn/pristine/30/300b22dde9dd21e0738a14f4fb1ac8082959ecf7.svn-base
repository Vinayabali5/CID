/**
 * This is the factory definition for the CorrespondenceType Data Service. This defines how to handle data about CorrespondenceService objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CorrespondenceTypeService', ['ui-notification'])
        .factory('CorrespondenceType', correspondenceTypeFactory);

    correspondenceTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function correspondenceTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/correspondenceTypes/';
        //Public Factory
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        //Private Interface
        /**
         * This method is used to retrieve all the CorrespondenceType from the API collection.
         *
         * @return {CorrespondenceType} An array of CorrespondenceType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('correspondence-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a CorrespondenceType from the API collection.
         * @param  {int} id of the CorrespondenceType object that is to be retrieved.
         * @return {CorrespondenceType} An CorrespondenceType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('correspondence-types-loaded', response.data);
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
         * This method is used to create a new instance of an CorrespondenceType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CorrespondenceType} correspondenceType An CorrespondenceType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CorrespondenceType data is provided then the method returns null.
         */
        function create(correspondenceType, callback) {
            var deferred = $q.defer();
            if (correspondenceType != undefined && correspondenceType != null) {
                $http.post(url, correspondenceType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('correspondence-type-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CorrespondenceType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CorrespondenceType object.
         *
         * @param  {CorrespondenceType} correspondenceType An CorrespondenceType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CorrespondenceType data is provided then the method returns null.
         */
        function save(correspondenceType, callback) {
            var deferred = $q.defer();
            $http.put(url + correspondenceType.id, correspondenceType).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('correspondence-type-saved', response.data);
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

/**
 * This is the factory definition for the EntryQualificationType Data Service. This defines how to handle data about EntryQualificationType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('EntryQualificationTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('EntryQualificationType', entryQualifiactionTypeFactory);

    entryQualifiactionTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function entryQualifiactionTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/entryQualificationTypes/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the EntryQualificationType from the API collection.
         *
         * @return {EntryQualificationType} An array of EntryQualificationType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('entryQualification-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a EntryQualificationType from the API collection.
         * @param  {int} id of the EntryQualificationType object that is to be retrieved.
         * @return {EntryQualificationType} An EntryQualificationType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entryQualification-types-loaded', response.data);
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
         * This method is used to create a new instance of an EntryQualificationType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {EntryQualificationType} entryQualificationType An EntryQualificationType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no EntryQualificationType data is provided then the method returns null.
         */
        function create(entryQualificationType, callback) {
            var deferred = $q.defer();
            if (entryQualificationType != undefined && entryQualificationType != null) {
                $http.post(url, entryQualificationType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entryQualification-type-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No EntryQualificationType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing EntryQualificationType object.
         *
         * @param  {EntryQualificationType} entryQualificationType An EntryQualificationType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no EntryQualificationType data is provided then the method returns null.
         */
        function save(entryQualificationType, callback) {
            var deferred = $q.defer();
            if (entryQualificationType && entryQualificationType.id) {
                $http.put(url + entryQualificationType.id, entryQualificationType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entryQualification-type-saved', response.data);
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

/**
 * This is the factory definition for the NoteType Data Service. This defines how to handle data about NoteType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('NoteTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('NoteType', noteTypeFactory);

    noteTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function noteTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/noteTypes/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the NoteType from the API collection.
         *
         * @return {NoteType} An array of NoteType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('note-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a NoteType from the API collection.
         * @param  {int} id of the NoteType object that is to be retrieved.
         * @return {NoteType} An NoteType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-types-loaded', response.data);
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
         * This method is used to create a new instance of an NoteType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {NoteType} noteType An NoteType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no NoteType data is provided then the method returns null.
         */
        function create(noteType, callback) {
            var deferred = $q.defer();
            if (noteType != undefined && noteType != null) {
                $http.post(url, noteType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-type-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No NoteType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing NoteType object.
         *
         * @param  {NoteType} noteType An NoteType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no NoteType data is provided then the method returns null.
         */
        function save(noteType, callback) {
            var deferred = $q.defer();
            if (noteType && noteType.id) {
                $http.put(url + noteType.id, noteType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-type-saved', response.data);
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

/**
 * This is the factory definition for the Note Data Service. This defines how to handle data about Note objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('NoteService', ['cid.app.constants', 'ui-notification'])
        .factory('Note', noteFactory);

    noteFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function noteFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/notes/';

        var factory = {
            query: getAll,
            get: getById,
            getByPersonId: getByPersonId,
            create: create,
            delete: deleteById,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Note from the API collection.
         *
         * @return {Note} An array of Note objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('notes-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Note from the API collection.
         * @param  {int} id of the Note object that is to be retrieved.
         * @return {Note} An Note object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('notes-loaded', response.data);
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
         * This method is used to retrieve an instance of a Note from the API collection.
         * @param  {int} personId of the Note object that is to be retrieved.
         * @return {Note} An Note object as identified by the id.
         */
        function getByPersonId(personId) {
            var deferred = $q.defer();
            if (personId != undefined && personId != null) {
                $http.get(url + personId + '/notes').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-loaded', response.data);
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
         * This method is used to create a new instance of an Note object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Note} note An Note object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Note data is provided then the method returns null.
         */
        function create(note, callback) {
            var deferred = $q.defer();
            if (note !== undefined) {
                $http.post(url, note).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                });
            } else {
                deferred.reject({
                    message: "No Note ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Note object.
         *
         * @param  {Note} note An Note object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Note data is provided then the method returns null.
         */
        function save(note, callback) {
            var deferred = $q.defer();
            if (note !== undefined && note.id) {
                $http.put(url + note.id, note).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-saved', response.data);
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

        /**
         * This method is used to delete an instance of a Note from the API collection.
         * @param  {int} noteId of the Note object that is to be retrieved.
         * @return {Note} An Note object as identified by the noteId.
         */
        function deleteById(noteId) {
            var deferred = $q.defer();
            if (noteId) {
                $http.delete(url + 'person-note/' + noteId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('note-saved', response.data);
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

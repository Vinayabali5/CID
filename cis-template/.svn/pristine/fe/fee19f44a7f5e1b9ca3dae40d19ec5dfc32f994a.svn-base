/**
 * This is the factory definition for the Person Data Service. This defines how to handle data about Person objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PersonService', ['cid.app.constants', 'ui-notification'])
        .factory('Person', personFactory);

    personFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function personFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/people/';
        var factory = {
            get: getById,
            getPersonRoles: getPersonRoles,
            createPersonRoles: createPersonRoles,
            create: create,
            save: save,
            contacts: getContactsById,
            notes: getNotesById,
            deletePersonRoles: deletePersonRoles,
            getRoles: getRoles
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve an instance of a Person from the API collection.
         * @param  {int} id of the Person object that is to be retrieved.
         * @return {Person} An Person object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-loaded', response.data);
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
         * This method is used to retrieve an instance of a Person from the API collection.
         * @param  {int} id of the Person object that is to be retrieved.
         * @return {Person} An Person object as identified by the id.
         */
        function getPersonRoles(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id + '/roles').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-loaded', response.data);
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

        function getRoles(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id + '/personRoles').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-loaded', response.data);
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
         * This method is used to create a new instance of an Person object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Person} Person An Person object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Person data is provided then the method returns null.
         */
        function create(person, callback) {
            var deferred = $q.defer();
            if (person != undefined && person != null) {
                $http.post(url, person).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Person ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an Person object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Person} Person An Person object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Person data is provided then the method returns null.
         */
        function createPersonRoles(addRole, callback) {
            var deferred = $q.defer();
            if (addRole.personId && addRole.roleId) {
                $http.post(url + 'createRole', addRole).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Person ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is sued to delete the Person Role from the table.
         */
        function deletePersonRoles(personId, roleId) {
            var deferred = $q.defer();
            if (personId && roleId) {
                $http.delete(url + personId + '/roles/' + roleId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-changed', response.data);
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Person ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Person object.
         *
         * @param  {Person} Person An Person object with the data to be updated.
         * @param  {Function} successCallback
         * @param  {Function} failureCallback  A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Person data is provided then the method returns null.
         */
        function save(person, callback) {
            var deferred = $q.defer();
            if (person && person.id) {
                $http.put(url + person.id, person).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-saved', response.data);
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
         * This method is used to get Contacts for a Person with personId from the API collection.
         *
         * @param  {int} personId of the Person to retrieve the contacts for.
         * @return {Person} An array of contacts
         */
        function getContactsById(personId) {
            var deferred = $q.defer();
            if (personId !== undefined && personId !== null) {
                $http.get(url + personId + '/contacts').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-loaded', response.data);
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
         * This method is used to get Notes for a Person with personId from the API collection.
         *
         * @param  {int} personId of the Person to retrieve the notes for.
         * @return {Person} An array of notes
         */
        function getNotesById(personId) {
            var deferred = $q.defer();
            if (personId !== undefined && personId !== null) {
                $http.get(url + personId + '/notes').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('person-notes-loaded', response.data);
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

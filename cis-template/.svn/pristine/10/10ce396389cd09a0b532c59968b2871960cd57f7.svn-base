/**
 * This is the factory definition for the Contact Data Service. This defines how to handle data about ContactService objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ContactService', ['ui-notification'])
        .factory('Contact', contactFactory);

    contactFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function contactFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/contacts/';
        // Public Interface
        var factory = {
            query: getAll,
            search: searchByPersonId,
            get: getById,
            delete: deleteById,
            contacts: contactsByPersonId,
            create: create,
            save: save,
            deleteAddress: deleteAddress
        };

        return factory;
        //Private Interface
        /**
         * This method is used to retrieve all the Contact from the API collection.
         *
         * @return {Contact} An array of ContactService objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('contacts-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Contact from the API collection.
         * @param  {int} personId of the Contact object that is to be retrieved.
         * @return {Contact} An Contact object as identified by the personId.
         */
        function searchByPersonId(personId) {
            var deferred = $q.defer();
            if (personId != undefined && personId != null) {
                $http.get(url + personId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('contacts-by-personId-loaded', response.data);
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
         * This method is used to retrieve an instance of a Contact from the API collection.
         * @param  {int} id of the Contact object that is to be retrieved.
         * @return {Contact} An Contact object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('contacts-loaded', response.data);
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
         * This method is used to delete an instance of a Contact from the API collection.
         * @param  {int} id of the Contact object that is to be deleted.
         * @return {Contact} An Contact object as identified by the id.
         */
        function deleteById(id) {
            if (id) {
                return $http.delete(url + id);
            } else {
                return null;
            }
        }
        /**
         * This method is used to retrieve an instance of a Contact from the API collection.
         * @param  {int} personId of the Contact object that is to be retrieved.
         * @return {Contact} An Contact object as identified by the id.
         */
        function contactsByPersonId(personId) {
            var deferred = $q.defer();
            if (personId != undefined && personId != null) {
                $http.get(url + personId + '/contacts').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('contact-loaded', response.data);
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
         * This method is used to create a new instance of an Contact object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Contact} contact An Contact object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Contact data is provided then the method returns null.
         */
        function create(contact, callback) {
            var deferred = $q.defer();
            if (contact != undefined && contact != null) {
                $http.post(url, contact).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('contact-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Contact ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Contact object.
         *
         * @param  {Contact} contact An Contact object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Contact data is provided then the method returns null.
         */
        function save(contact, callback) {
            var deferred = $q.defer();
            $http.put(url + contact.id, contact).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('contact-saved', response.data);
                if (callback) {
                    callback();
                }
            }, function(response) {
                deferred.reject(response);
                Notification.error("Error:" + response.data.message);
            });
            return deferred.promise;
        }


        /**
         * This method is used to delete Address from an existing Contact object.
         *
         * @param  {Contact} contact An Contact object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Contact data is provided then the method returns null.
         */
        function deleteAddress(contact, callback) {
            var deferred = $q.defer();
            if (contact && contact.id) {
                $http.put(url + contact.id + '/address', contact).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('contact-delete', response.data);
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

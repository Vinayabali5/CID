/**
 * This is the factory definition for the Letter Data Service. This defines how to handle data about Letter objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('LetterService', ['cid.app.constants', 'ui-notification'])
        .factory('Letter', letterFactory);

    letterFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function letterFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            getAllAuthorised: getAllAuthorised,
            getAllGoingTonight: getAllGoingTonight,
            getAllToProduce: getAllToProduce,
            getByStudentId: getByStudentId,
            getByStudentIdAndLetterId: getByStudentIdAndLetterId,
            create: create,
            save: save,
            delete: deleteById,
            deleteILPEntry: deleteILPEntry
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Letter from the API collection.
         *
         * @return {Letter} An array of Letter objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'ilp-letters').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('ilp-letter-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Letter from the API collection.
         * @param  {int} id of the Letter object that is to be retrieved.
         * @return {Letter} An Letter object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'ilp-letters/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-loaded', response.data);
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
         * This method is used to retrieve all the Authorised Letter from the API collection.
         *
         * @return {Letter} An array of Authorised Letter objects.
         */
        function getAllToProduce() {
            var deferred = $q.defer();
            $http.get(url + 'ilp-letters/to-produce').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('ilp-letter-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve all the Authorised Letter from the API collection.
         *
         * @return {Letter} An array of Authorised Letter objects.
         */
        function getAllAuthorised() {
            var deferred = $q.defer();
            $http.get(url + 'ilp-letters/authorised').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('ilp-letter-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve all the Authorised Letter from the API collection.
         *
         * @return {Letter} An array of Authorised Letter objects.
         */
        function getAllGoingTonight() {
            var deferred = $q.defer();
            $http.get(url + 'ilp-letters/going-tonight').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('ilp-letter-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Letter from the API collection.
         * @param  {int} id of the Letter object that is to be retrieved.
         * @return {Letter} An Letter object as identified by the id.
         */
        function getByStudentId(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'students/' + id + '/ilp-letters').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-loaded', response.data);
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
         * This method is used to retrieve an instance of a Letter from the API collection.
         * @param  {int} id of the Letter object that is to be retrieved.
         * @return {Letter} An Letter object as identified by the id.
         */
        function getByStudentIdAndLetterId(studentId, letterId) {
            var deferred = $q.defer();
            if (studentId != undefined && letterId != null) {
                $http.get(url + 'students/' + studentId + '/ilp-letter/' + letterId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-loaded', response.data);
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
         * This method is used to create a new instance of an Letter object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Letter} letter An Letter object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Letter data is provided then the method returns null.
         */
        function create(letter, callback) {
            var deferred = $q.defer();
            if (letter != undefined && letter != null) {
                $http.post(url + 'ilp-letter', letter).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-saved', response.data);
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
         * This method is used to save changes to an existing Letter object.
         *
         * @param  {Letter} letter An Letter object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Letter data is provided then the method returns null.
         */
        function save(letter, callback) {
            var deferred = $q.defer();
            if (letter && letter.id) {
                $http.put(url + 'ilp-letter/' + letter.id, letter).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-saved', response.data);
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
         * This method is used to delete an instance of a Letter from the API collection.
         * @param  {int} id of the Letter object that is to be deleted.
         * @return {Letter} An Letter object as identified by the id.
         */
        function deleteById(id) {
            var deferred = $q.defer();
            if (id) {
                $http.delete(url + 'ilp-letters/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-deleted', response.data);
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
         * This method is used to delete an instance of a Letter and ILPInterview from the API collection.
         * @param  {int} id of the Letter object that is to be deleted.
         * @return {Letter} An Letter object as identified by the id.
         */
        function deleteILPEntry(id) {
            var deferred = $q.defer();
            if (id) {
                $http.delete(url + 'ilp-letters/' + id + '/ilpEntry').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-deleted', response.data);
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

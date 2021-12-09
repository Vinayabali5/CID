/**
 * This is the factory definition for the TutorGroup Data Service. This defines how to handle data about TutorGroup objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('TutorGroupService', ['cid.app.constants', 'ui-notification'])
        .factory('TutorGroup', tutorGroupFactory);

    tutorGroupFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function tutorGroupFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/tutorGroups/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save,
            getValid: getValid,
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the TutorGroup from the API collection.
         *
         * @return {TutorGroup} An array of TutorGroup objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('tutor-groups-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a TutorGroup from the API collection.
         * @param  {int} id of the TutorGroup object that is to be retrieved.
         * @return {TutorGroup} An TutorGroup object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('tutor-group-loaded', response.data);
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
         * This method is used to create a new instance of an TutorGroup object in the database by POSTing the
         * required data to the API.
         *
         * @param  {TutorGroup} tutorGroup An TutorGroup object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no tutorGroup data is provided then the method returns null.
         */
        function create(tutorGroup, callback) {
            var deferred = $q.defer();
            if (tutorGroup != undefined && tutorGroup != null) {
                $http.post(url, tutorGroup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('tutor-group-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No TutorGroup ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing TutorGroup object.
         *
         * @param  {TutorGroup} tutorGroup An TutorGroup object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no tutorGroup data is provided then the method returns null.
         */
        function save(tutorGroup, callback) {
            var deferred = $q.defer();
            if (tutorGroup && tutorGroup.id) {
                $http.put(url + tutorGroup.id, tutorGroup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('tutor-group-saved', response.data);
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
         * This method is used to retrieve all the  Valid TutorGroup from the API collection.
         *
         * @return {TutorGroup} An array of TutorGroup objects.
         */
        function getValid(inUse) {
            var deferred = $q.defer();
            $http.get(url, {
                params: {
                    inUse: inUse
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('tutor-group-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
    }

})();

/**
 * This is the factory definition for the WorkPlacementMode Data Service. This defines how to handle data about WorkPlacementMode objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('WorkPlacementModeService', ['ui-notification'])
        .factory('WorkPlacementMode', workPlacementModeFactory);

    workPlacementModeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function workPlacementModeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/work-placement-modes/';

        //Pubic Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;


        //Private Interface
        /**
         * This method is used to retrieve all the WorkPlacementMode from the API collection.
         *
         * @return {WorkPlacementMode} An array of WorkPlacementMode objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('work-placement-modes-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a WorkPlacementMode from the API collection.
         * @param  {int} id of the WorkPlacementMode that is to be retrieved.
         * @return {WorkPlacementMode} An WorkPlacementMode object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('work-placement-modes-loaded', response.data);
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
         * This method is used to create a new instance of an WorkPlacementMode object in the database by POSTing the
         * required data to the API.
         *
         * @param  {WorkPlacementMode} workPlacementMode An WorkPlacementMode object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no WorkPlacementMode data is provided then the method returns null.
         */
        function create(workPlacementMode, callback) {
            var deferred = $q.defer();
            if (workPlacementMode != undefined && workPlacementMode != null) {
                $http.post(url, workPlacementMode).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('work-placement-modes-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No WorkPlacementMode ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing WorkPlacementMode object.
         *
         * @param  {WorkPlacementMode} workPlacementMode An WorkPlacementMode object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no WorkPlacementMode data is provided then the method returns null.
         */
        function save(workPlacementMode, callback) {
            var deferred = $q.defer();
            $http.put(url + workPlacementMode.id, workPlacementMode).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('work-placement-modes-saved', response.data);
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

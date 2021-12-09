/**
 * This is the factory definition for the PossibleGradeSet Data Service. This defines how to handle data about PossibleGradeSet objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PossibleGradeSetService', ['cid.app.constants', 'ui-notification'])
        .factory('PossibleGradeSet', possibleGradeSetFactory);

    possibleGradeSetFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function possibleGradeSetFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/possibleGradeSets/';

        var factory = {
            query: getAll,
            get: getById,
            getPossibleGradesBySetId: getPossibleGradeSetId,
            create: create,
            save: save
        };

        return factory;

        /**
         * This method is used to retrieve all the PossibleGradeSet from the API collection.
         *
         * @return {PossibleGradeSet} An array of PossibleGradeSet objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('possible-grade-set-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a PossibleGradeSet from the API collection.
         * @param  {int} id of the PossibleGradeSet object that is to be retrieved.
         * @return {PossibleGradeSet} An PossibleGradeSet object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grade-set-loaded', response.data);
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
         * This method is used to retrieve an instance of a PossibleGradeSet from the API collection.
         * @param  {int} id of the PossibleGradeSet object that is to be retrieved.
         * @return {PossibleGradeSet} An array of PossibleGradeSet object as identified by the id.
         */
        function getPossibleGradeSetId(id) {
            var deferred = $q.defer();
            $http.get(url + id + '/possibleGrades').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('possible-grade-set-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an PossibleGradeSet object in the database by POSTing the
         * required data to the API.
         *
         * @param  {PossibleGradeSet} possibleGradeSet An PossibleGradeSet object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PossibleGradeSet data is provided then the method returns null.
         */
        function create(possibleGradeSet, callback) {
            var deferred = $q.defer();
            if (possibleGradeSet != undefined && possibleGradeSet != null) {
                $http.post(url, possibleGradeSet).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grade-set-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No PossibleGradeSet ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing PossibleGradeSet object.
         *
         * @param  {PossibleGradeSet} possibleGradeSet An PossibleGradeSet object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PossibleGradeSet data is provided then the method returns null.
         */
        function save(possibleGradeSet, callback) {
            var deferred = $q.defer();
            if (possibleGradeSet && possibleGradeSet.id) {
                $http.put(url + possibleGradeSet.id, possibleGradeSet).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grade-set-saved', response.data);
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
    }
})();

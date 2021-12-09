/**
 * This is the factory definition for the PossibleGrade Data Service. This defines how to handle data about PossibleGrade objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PossibleGradeService', ['cid.app.constants', 'ui-notification'])
        .factory('PossibleGrade', possibleGradeFactory);

    possibleGradeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function possibleGradeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/possibleGrades/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            getByGradeSetId: getByGradeSetId,
            save: save
        };

        return factory;

        /**
         * This method is used to retrieve all the PossibleGrade from the API collection.
         *
         * @return {PossibleGrade} An array of PossibleGrade objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url, {
                cache: true
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('possible-grades-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a PossibleGrade from the API collection.
         * @param  {int} id of the PossibleGrade object that is to be retrieved.
         * @return {PossibleGrade} An PossibleGrade object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grade-loaded', response.data);
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
         * This method is used to create a new instance of an PossibleGrade object in the database by POSTing the
         * required data to the API.
         *
         * @param  {PossibleGrade} possibleGrade An PossibleGrade object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PossibleGrade data is provided then the method returns null.
         */
        function create(possibleGrade, callback) {
            var deferred = $q.defer();
            if (possibleGrade != undefined && possibleGrade != null) {
                $http.post(url, possibleGrade).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grades-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No PossibleGrade ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing PossibleGrade object.
         *
         * @param  {PossibleGrade} possibleGrade An PossibleGrade object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PossibleGrade data is provided then the method returns null.
         */
        function save(possibleGrade, callback) {
            var deferred = $q.defer();
            if (possibleGrade && possibleGrade.id) {
                $http.put(url + possibleGrade.id, possibleGrade).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grades-saved', response.data);
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
         * This method is used to retrieve an instance of a PossibleGrade from the API collection.
         * @param  {int} gradeSetId of the PossibleGrade object that is to be retrieved.
         * @return {PossibleGrade} An PossibleGrade object as identified by the id.
         */
        function getByGradeSetId(gradeSetId) {
            var deferred = $q.defer();
            if (gradeSetId != undefined && gradeSetId != null) {
                $http.get(url + gradeSetId + '/gradeSets').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('possible-grade-gradeSets-loaded', response.data);
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

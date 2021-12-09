/**
 *
 */
(function() {
    'use strict';

    angular
        .module('ExamSeriesService', ['ui-notification'])
        .factory('ExamSeries', examSeriesFactory);

    examSeriesFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'APP', 'Notification'];

    function examSeriesFactory($q, $http, $rootScope, GLOBAL, APP, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/exam-series/';
        // Public Interface
        var factory = {
            query: getAll,
            getByYear: getByYear,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the ExamSeries from the API collection.
         *
         * @return {ExamSeries} An array of ExamSeries objects.
         */
        function getAll() {
            var deferred = $q.defer();
            var year = APP.getYear();
            $http.get(url, {
                params: {
                    yearId: year.id
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('exam-series-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve the ExamSeries of a Year from the API collection.
         *
         * @param  {ExamSeries} year of the ExamSeries object that is to be retrieved.
         * @return {ExamSeries} List of ExamSeries valid for a year
         */
        function getByYear(yearId) {
            var deferred = $q.defer();
            $http.get(url, {
                params: {
                    yearId: yearId
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('exam-series-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a ExamSeries from the API collection.
         * @param  {int} id of the ExamSeries object that is to be retrieved.
         * @return {ExamSeries} An ExamSeries object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('exam-series-loaded', response.data);
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
         * This method is used to create a new instance of an ExamSeries object in the database by POSTing the
         * required data to the API.
         *
         * @param  {ExamSeries} ethnicity An ExamSeries object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ExamSeries data is provided then the method returns null.
         */
        function create(examSeries, callback) {
            var deferred = $q.defer();
            if (examSeries != undefined && examSeries != null) {
                $http.post(url, examSeries).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('exam-series-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Course ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing ExamSeries object.
         *
         * @param  {ExamSeries} examS An ExamSeries object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ExamSeries data is provided then the method returns null.
         */
        function save(examSeries, callback) {
            var deferred = $q.defer();
            $http.put(url + examSeries.id, examSeries).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('exam-series-saved', response.data);
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

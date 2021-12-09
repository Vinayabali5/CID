/**
 * This is a student search service that is used to search for a student based on various elements.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053, Y090, Y091]
 *
 * @type Factory
 */
(function() {
    'use strict';

    angular
        .module('cid.search.student', [])
        .factory('StudentSearch', studentSearchSerivce);

    studentSearchSerivce.$inject = ['$log', '$http', '$q', 'GLOBAL', 'APP'];

    function studentSearchSerivce($log, $http, $q, GLOBAL, APP) {
        var url = GLOBAL.API + '/search/student';

        // Public Interface

        var factory = {
            search: search
        };

        return factory;

        // Private Interface

        /**
         * This method is used to perform a student search operation on the API. The method takes a search object that will contain
         * the data to be searched for on the API.
         *
         * @param {object} search The search object will contain the various fields to use in a search on the API. Currently supported
         *                        options are: year, surname, firstName, ref
         * @return {promise} containing the data return from the API or null if the search params are not supplied.
         */
        function search(search) {
            var deferred = $q.defer();
            if (search) {
                var reqParams = '?';
                if (search.year) {
                    reqParams += 'yearId=' + search.year + '&';
                } else {
                    reqParams += 'yearId=' + APP.getYear().id + '&';
                }
                if (search.surname) {
                    reqParams += 'surname=' + search.surname + '&';
                }
                if (search.firstName) {
                    reqParams += 'firstName=' + search.firstName + '&';
                }
                if (search.reference) {
                    reqParams += 'studentId=' + search.reference + '&';
                }
                if (search.candidateNo) {
                    reqParams += 'candidateNo=' + search.candidateNo + '&';
                }
                var requestParams = reqParams.slice(0, -1);
                $http.get(url + requestParams).then(function(response) {
                    deferred.resolve(response);
                }, function(error) {
                    deferred.reject(error);
                    $log.error(error);
                });
            } else {
                deferred.reject({
                    data: {
                        code: 1,
                        message: 'No search parameters supplied.'
                    }
                });
            }
            return deferred.promise;
        }
    }
}());

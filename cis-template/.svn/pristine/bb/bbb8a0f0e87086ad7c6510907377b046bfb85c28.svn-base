/**
 * This is a course search service that is used to search for a course based on various elements.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053, Y090, Y091]
 *
 * @type Factory
 */
(function() {
    'use strict';

    angular
        .module('cid.search.course', [])
        .factory('CourseSearch', courseSearchService);

    courseSearchService.$inject = ['$http', 'GLOBAL', 'APP'];

    function courseSearchService($http, GLOBAL, APP) {
        var url = GLOBAL.API + '/courseSearch';

        // Public Interface
        var factory = {
            search: search
        };

        return factory;

        // Private Interface

        /**
         * This method is used to perform a course search operation on the API. The method takes a search object that will contain
         * the data to be searched for on the API.
         *
         * @param {object} search The search object will contain the various fields to use in a search on the API. Currently supported
         * options are: search
         * @return {promise} containing the data return from the API or null if the search params are not supplied.
         */
        function search(search) {
            if (search) {
                var year = APP.getYear();
                var reqParams = '?';
                if (search.searchText) {
                    reqParams += 'search=' + search.searchText + '&';
                }
                var requestParams = reqParams.slice(0, -1);
                return $http.get(url + requestParams, {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }
        }
    }
}());

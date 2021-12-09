(function() {

    angular
        .module('StudentEmailSearchService', [])
        .factory('StudentEmail', StudentEmailSearchService);

    StudentEmailSearchService.$inject = ['$http', 'GLOBAL'];

    function StudentEmailSearchService($http, GLOBAL) {
        var url = GLOBAL.API + '/search/studentEmail';

        return {
            query: function() {
                return $http.get(url);
            },
            search: function(searchParams) {
                if (searchParams && searchParams instanceof Object) {
                    return $http.get(url, {
                        params: searchParams
                    });
                }
            }
        };
    }

}());

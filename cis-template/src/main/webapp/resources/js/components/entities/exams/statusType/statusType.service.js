(function() {

    angular
        .module('StatusTypeService', [])
        .factory('StatusType', StatusTypeService);

    StatusTypeService.$inject = ['$http', 'GLOBAL'];

    function StatusTypeService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/statusTypes/';

        var factory = {
            query: function() {
                return $http.get(url);
            },
            get: function(id) {
                if (id) {
                    return $http.get(url + id);
                } else {
                    return null;
                }
            },
            create: function(statusType, callback) {
                if (statusType) {
                    return $http.post(url, statusType).then(function(response) {
                        if (callback) {
                            callback();
                        }
                        return response.data;
                    }, function(response) {
                        return {
                            status: response.status,
                            error: response.data
                        };
                    });
                } else {
                    return null;
                }
            },
            save: function(statusType, callback) {
                if (statusType && statusType.id) {
                    return $http.put(url + statusType.id, statusType).then(function(response) {
                        if (callback) {
                            callback();
                        }
                        return response.data;
                    }, function(response) {
                        return {
                            status: response.status,
                            error: response.data
                        };
                    });
                } else {
                    return null;
                }
            }

        };
        return factory;
    }
}());

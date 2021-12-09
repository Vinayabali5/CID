(function() {

    angular
        .module('EdiStatusTypeService', [])
        .factory('EdiStatusType', EdiStatusTypeService);

    EdiStatusTypeService.$inject = ['$http', 'GLOBAL'];

    function EdiStatusTypeService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/ediStatusTypes/';

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
            create: function(ediStatusType, callback) {
                if (ediStatusType) {
                    return $http.post(url, ediStatusType).then(function(response) {
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
            save: function(ediStatusType, callback) {
                if (ediStatusType && ediStatusType.id) {
                    return $http.put(url + ediStatusType.id, ediStatusType).then(function(response) {
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

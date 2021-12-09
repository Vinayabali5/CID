/**
 * The ComponentService module for accessing Component data from the REST API
 */
(function() {

    angular
        .module('ComponentService', [])
        .factory('Component', ComponentService);

    ComponentService.$inject = ['$http', 'GLOBAL'];

    function ComponentService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/components/';

        var factory = {
            query: function() {
                return $http.get(url);
            },
            queryByDateAndSession: function(date, session) {
                return $http.get(url + date.getTime() + '/' + session);
            },
            get: function(id) {
                if (id) {
                    return $http.get(url + id);
                } else {
                    return null;
                }
            },
            create: function(component, callback) {
                if (component) {
                    return $http.post(url, component).then(function(response) {
                        if (callback) {
                            callback(response);
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
            save: function(component, callback) {
                if (component && component.id) {
                    return $http.put(url + component.id, component).then(function(response) {
                        if (callback) {
                            callback(response);
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

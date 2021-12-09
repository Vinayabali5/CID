(function() {

    angular
        .module('OptionComponentService', [])
        .factory('OptionComponent', OptionComponentService);

    OptionComponentService.$inject = ['$http', 'GLOBAL'];

    function OptionComponentService($http, GLOBAL) {
        var self = this;
        var url = GLOBAL.API + '/option-components';

        var factory = {
            create: function(optionComponent, callback) {
                if (optionComponent) {
                    return $http.post(url, optionComponent).then(function(response) {
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

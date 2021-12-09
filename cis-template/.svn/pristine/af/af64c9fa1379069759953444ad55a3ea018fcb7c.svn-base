(function() {

    angular
        .module('cid.app.variables', [])
        .factory('APP', variablesFactory);

    variablesFactory.$inject = ['$rootScope'];

    function variablesFactory($rootScope) {
        var _currentYear = {};

        var _currentState;
        var _currentStateParams;

        var _previousState;
        var _previousStateParams;


        return {
            setYear: function(data) {
                $rootScope.$emit('year-changed', data);
                _currentYear = data;
            },
            getYear: function() {
                return _currentYear;
            },
            setCurrentState: function(data) {
                _currentState = data;
            },
            getCurrentState: function() {
                return _currentState;
            },
            setCurrentStateParams: function(data) {
                _currentStateParams = data;
            },
            getCurrentStateParams: function() {
                return _currentStateParams;
            },
            setPreviousState: function(data) {
                _previousState = data;
            },
            getPreviousState: function() {
                return _previousState;
            },
            setPreviousStateParams: function(data) {
                _previousStateParams = data;
            },
            getPreviousStateParams: function() {
                return _previousStateParams;
            },
        };
    }
})();

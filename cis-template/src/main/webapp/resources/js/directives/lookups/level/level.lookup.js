angular.module('Lookups').directive('levelLookup', function(Level) {
    return {
        restrict: 'E',
        scope: {
            levelId: '=',
        },
        link: function(scope, element) {
            if (scope.levelId !== undefined) {
                Level.get(scope.levelId).then(function(response) {
                    scope.level = response.data.description;
                }, function(response) {
                    scope.level = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/level/level.lookup.html',
    };
});

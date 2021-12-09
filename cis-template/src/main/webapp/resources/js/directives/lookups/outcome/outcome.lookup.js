angular.module('Lookups').directive('outcomeLookup', function(Outcome) {
    return {
        restrict: 'E',
        scope: {
            outcomeId: '=',
        },
        link: function(scope, element) {
            if (scope.outcomeId !== undefined) {
                Outcome.get(scope.outcomeId).then(function(response) {
                    scope.outcome = response.data.description;
                }, function(response) {
                    scope.outcome = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/outcome/outcome.lookup.html',
    };
});

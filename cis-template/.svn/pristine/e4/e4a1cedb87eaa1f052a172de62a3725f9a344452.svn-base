angular.module('Lookups').directive('periodLookup', function(Period) {
    return {
        restrict: 'E',
        scope: {
            periodId: '=',
        },
        link: function(scope, element) {
            if (scope.periodId !== undefined) {
                Period.get(scope.periodId).then(function(response) {
                    scope.period = response.data.description;
                }, function(response) {
                    scope.period = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/period/period.lookup.html',
    };
});

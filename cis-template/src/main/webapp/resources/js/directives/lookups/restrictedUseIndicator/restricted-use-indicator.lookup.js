angular.module('Lookups').directive('restrictedUseIndicatorLookup', function(RestrictedUseIndicator) {
    return {
        restrict: 'E',
        scope: {
            restrictedUseIndicatorId: '=',
        },
        link: function(scope, element) {
            if (scope.restrictedUseIndicatorId !== undefined) {
                RestrictedUseIndicator.get(scope.restrictedUseIndicatorId).then(function(response) {
                    scope.restrictedUseIndicator = response.data.description;
                }, function(response) {
                    scope.restrictedUseIndicator = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/restrictedUseIndicator/restricted-use-indicator.lookup.html',
    };
});

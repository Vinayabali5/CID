angular.module('Lookups').directive('ethnicityLookup', function(Ethnicity) {
    return {
        restrict: 'E',
        scope: {
            ethnicityId: '=',
        },
        link: function(scope, element) {
            if (scope.ethnicityId !== undefined) {
                Ethnicity.get(scope.ethnicityId).then(function(response) {
                    scope.ethnicity = response.data.description;
                }, function(response) {
                    scope.ethnicity = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/ethnicity/ethnicity.lookup.html',
    };
});

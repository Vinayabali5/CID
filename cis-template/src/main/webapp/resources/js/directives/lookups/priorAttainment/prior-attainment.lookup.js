angular.module('Lookups').directive('priorAttainmentLookup', function(PriorAttainment) {
    return {
        restrict: 'E',
        scope: {
            priorAttainmentId: '=',
        },
        link: function(scope, element) {
            if (scope.priorAttainmentId !== undefined) {
                PriorAttainment.get(scope.priorAttainmentId).then(function(response) {
                    scope.priorAttainment = response.data.description;
                }, function(response) {
                    scope.priorAttainment = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/priorAttainment/prior-attainment.lookup.html',
    };
});

angular.module('Lookups').directive('aimTypeLookup', function(AimType) {
    return {
        restrict: 'E',
        scope: {
            aimTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.aimTypeId !== undefined) {
                AimType.get(scope.aimTypeId).then(function(response) {
                    scope.aimType = response.data.description;
                }, function(response) {
                    scope.aimType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/aimType/aim-type.lookup.html',
    };
});

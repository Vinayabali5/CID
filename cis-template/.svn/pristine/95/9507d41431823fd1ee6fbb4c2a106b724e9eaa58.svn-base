angular.module('Lookups').directive('yearGroupLookup', function(YearGroup) {
    return {
        restrict: 'E',
        scope: {
            yearGroupId: '=',
        },
        link: function(scope, element) {
            if (scope.yearGroupId !== undefined) {
                YearGroup.get(scope.yearGroupId).then(function(response) {
                    scope.yearGroup = response.data.description;
                }, function(response) {
                    scope.yearGroup = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/yearGroup/year-group.lookup.html',
    };
});

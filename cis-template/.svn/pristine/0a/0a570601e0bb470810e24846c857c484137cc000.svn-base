angular.module('Lookups').directive('nationalityLookup', function(Nationality) {
    return {
        restrict: 'E',
        scope: {
            nationalityId: '=',
        },
        link: function(scope, element) {
            if (scope.nationalityId !== undefined) {
                Nationality.get(scope.nationalityId).then(function(response) {
                    scope.nationality = response.data.description;
                }, function(response) {
                    scope.nationality = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/nationality/nationality.lookup.html',
    };
});

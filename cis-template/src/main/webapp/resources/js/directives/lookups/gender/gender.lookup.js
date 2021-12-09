angular.module('Lookups').directive('genderLookup', function(Gender) {
    return {
        restrict: 'E',
        scope: {
            genderId: '=',
        },
        link: function(scope, element) {
            if (scope.genderId !== undefined) {
                Gender.get(scope.genderId).then(function(response) {
                    scope.gender = response.data.description;
                }, function(response) {
                    scope.gender = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/gender/gender.lookup.html',
    };
});

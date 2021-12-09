angular.module('Lookups').directive('schoolLookup', function(School) {
    return {
        restrict: 'E',
        scope: {
            schoolId: '=',
        },
        link: function(scope, element) {
            if (scope.schoolId !== undefined) {
                School.get(scope.schoolId).then(function(response) {
                    scope.school = response.data.name;
                }, function(response) {
                    scope.school = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/school/school.lookup.html',
    };
});

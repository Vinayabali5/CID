angular.module('Lookups').directive('schoolTypeLookup', function(SchoolType) {
    return {
        restrict: 'E',
        scope: {
            schoolTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.schoolTypeId !== undefined) {
                SchoolType.get(scope.schoolTypeId).then(function(response) {
                    scope.schoolType = response.data.description;
                }, function(response) {
                    scope.schoolType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/schoolType/school-type.lookup.html',
    };
});

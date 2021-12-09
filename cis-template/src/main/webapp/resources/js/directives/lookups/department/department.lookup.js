angular.module('Lookups').directive('departmentLookup', function(Department) {
    return {
        restrict: 'E',
        scope: {
            departmentId: '=',
        },
        link: function(scope, element) {
            if (scope.departmentId !== undefined) {
                Department.get(scope.departmentId).then(function(response) {
                    scope.department = response.data.description;
                }, function(response) {
                    scope.department = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/department/department.lookup.html',
    };
});

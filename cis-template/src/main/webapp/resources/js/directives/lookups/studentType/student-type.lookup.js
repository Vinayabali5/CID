angular.module('Lookups').directive('studentTypeLookup', function(StudentType) {
    return {
        restrict: 'E',
        scope: {
            studentTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.studentTypeId !== undefined) {
                StudentType.get(scope.studentTypeId).then(function(response) {
                    scope.studentType = response.data.description;
                }, function(response) {
                    scope.studentType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/studentType/student-type.lookup.html',
    };
});

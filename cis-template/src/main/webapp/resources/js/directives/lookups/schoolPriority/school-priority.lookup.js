angular.module('Lookups').directive('schoolPriorityLookup', function(SchoolPriority) {
    return {
        restrict: 'E',
        scope: {
            schoolPriorityId: '=',
        },
        link: function(scope, element) {
            if (scope.schoolPriorityId !== undefined) {
                SchoolPriority.get(scope.schoolPriorityId).then(function(response) {
                    scope.schoolPriority = response.data.code;
                }, function(response) {
                    scope.schoolPriority = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/schoolPriority/school-priority.lookup.html',
    };
});

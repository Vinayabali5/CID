angular.module('Lookups').directive('staffTypeLookup', function(StaffType) {
    return {
        restrict: 'E',
        scope: {
            staffTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.staffTypeId !== undefined) {
                StaffType.get(scope.staffTypeId).then(function(response) {
                    scope.staffType = response.data.description;
                }, function(response) {
                    scope.staffType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/staffType/staff-type.lookup.html',
    };
});

angular.module('Lookups').directive('attendanceCodeLookup', function(AttendanceCode) {
    return {
        restrict: 'E',
        scope: {
            attendanceCodeId: '=',
        },
        link: function(scope, element) {
            if (scope.attendanceCodeId !== undefined) {
                AttendanceCode.get(scope.attendanceCodeId).then(function(response) {
                    scope.attendanceCode = response.data.description;
                }, function(response) {
                    scope.attendanceCode = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/attendanceCode/attendance-code.lookup.html',
    };
});

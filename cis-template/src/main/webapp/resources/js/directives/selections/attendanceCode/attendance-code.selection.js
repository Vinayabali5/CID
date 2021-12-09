angular.module('SelectionBoxes').directive('attendanceCodeSelection', ['AttendanceCode', function(AttendanceCode) {
    return {
        restrict: 'E',
        scope: {
            id: '@',
            class: '@',
            readonly: '=?',
            ngRequired: '=',
            ngmodelvar: '=ngModel',
            altNullText: '=altNullText'

        },
        link: function(scope, element, attrs) {
            element[0].removeAttribute('id');
            element[0].removeAttribute('class');
            element[0].removeAttribute('readonly');
            element[0].disable = scope.readonly;
        },
        controller: ['AttendanceCode', function(AttendanceCode) {
            var vm = this;
            vm.attendanceCodes = [];
            AttendanceCode.query().then(function(response) {
                vm.attendanceCodes = response.data;
            }, function(response) {
                alert("Error Retrieving AttendanceCodes");
            });
        }],
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/selections/attendanceCode/attendance-code.selection.html',
    };
}]);

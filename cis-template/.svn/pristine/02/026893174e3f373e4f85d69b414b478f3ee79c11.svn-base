(function() {

    angular
        .module('SelectionBoxes')
        .directive('attendanceMonitoringSelection', AttendanceMonitoringSelectionDirective);

    AttendanceMonitoringSelectionDirective.$inject = ['AttendanceMonitoring'];

    function AttendanceMonitoringSelectionDirective(AttendanceMonitoring) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['AttendanceMonitoring', function(AttendanceMonitoring) {
                var vm = this;
                vm.attendanceMonitorings = [];
                AttendanceMonitoring.query().then(function(response) {
                    vm.attendanceMonitorings = response.data;
                }, function(err) {
                    alert("Error Retrieving AttendanceMonitorings");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/attendanceMonitoring/attendance-monitoring.selection.html',
        };
    }

})();

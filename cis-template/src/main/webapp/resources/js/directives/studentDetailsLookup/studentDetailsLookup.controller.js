/**
 * This is the Student Details Lookup Directive Controller, it is used to handle the student details lookup directive data and controls.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentDetailsLookupDirective')
        .controller('StudentDetailsLookupDirectiveController', StudentDetailsLookupDirectiveController);

    StudentDetailsLookupDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'Student'];

    function StudentDetailsLookupDirectiveController($log, $scope, $rootScope, Student) {
        /* jshint validthis:true */
        var vm = this;
        vm.message = '';
        vm.init = init;

        function init() {
            if (vm.student === undefined && vm.studentId) {
                $log.log('II Loading student-details directive with a studentId');
                vm.message = 'Loading...';
                Student.get(vm.studentId).then(function(response) {
                    vm.student = response.data;
                    vm.message = '';
                    $log.log(vm.student);
                }, function(response) {
                    $log.error('EE Failed to retireve the student details for studentId: ' + vm.studentId);
                });
            }
            if (!vm.studentId) {
                $log.log('II Loading student-details-lookup requires a student-id attribute');
            }
        }
    }
})();

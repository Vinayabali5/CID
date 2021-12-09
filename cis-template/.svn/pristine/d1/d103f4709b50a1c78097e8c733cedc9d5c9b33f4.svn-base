/**
 * This is the StudentYearDetailsDirectiveController, it is used to handle the student Year Details Directive Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentYearDetailsDirective')
        .controller('StudentYearDetailsDirectiveController', StudentYearDetailsDirectiveController);

    StudentYearDetailsDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'Student'];

    function StudentYearDetailsDirectiveController($log, $scope, $rootScope, Student) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        vm.message = '';
        vm.studentYear = vm.studentYear ? vm.studentYear : {};

        vm.hasLeft = hasLeft;
        vm.nonStarter = nonStarter;

        // Private Interface

        /**
         * This method is used to determine if the student has left the college. A leave is someone that has a start date and and end date.
         * 
         * @returns 
         */
        function hasLeft() {
            if (vm.studentYear !== null && vm.studentYear !== undefined) {
                if (vm.studentYear.endDate !== null && vm.studentYear.startDate !== null) {
                    return true;
                }
            }
            return false;
        }

        /**
         * This method is used to determine if the student was a non-starter. A non-starter is a student without a start date. 
         * 
         * @returns true if the student year start date is NULL.
         */
        function nonStarter() {
            return vm.studentYear !== null && vm.studentYear !== undefined && vm.studentYear.startDate == null;
        }
    }

})();

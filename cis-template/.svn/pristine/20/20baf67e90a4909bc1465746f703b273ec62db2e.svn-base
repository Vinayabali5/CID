/**
 * This is the Student Admissions Details Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentAdmissionsDetailsDirective')
        .controller('StudentAdmissionsDetailsDirectiveController', StudentAdmissionsDetailsDirectiveController);

    StudentAdmissionsDetailsDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'Student'];

    function StudentAdmissionsDetailsDirectiveController($log, $scope, $rootScope, Student) {
        var vm = this;

        this.message = '';

        this.studentAdmissions = this.studentAdmissions ? this.studentAdmissions : {};

        this.init = function() {};


        this.hasData = function() {
            if (vm.studentAdmissions) {
                return true;
            } else {
                return false;
            }
        };

        this.init();
    }
})();

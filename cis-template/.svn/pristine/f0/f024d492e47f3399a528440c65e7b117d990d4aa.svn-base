/**
 * This is the StudentConcessionType Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentConcessionTypeTableDirective')
        .controller('StudentConcessionTypeTableDirectiveController', StudentConcessionTypeTableDirectiveController);

    StudentConcessionTypeTableDirectiveController.$inject = ['$log', '$scope', '$state', '$rootScope', 'StudentConcessionType'];

    function StudentConcessionTypeTableDirectiveController($log, $scope, $state, $rootScope, StudentConcessionType) {
        var vm = this;

        vm.studentId = $scope.studentId ? $scope.studentId : undefined;
        vm.studentConcessionTypes = vm.studentConcessionTypes ? vm.studentConcessionTypes : [];

        this.init = function() {
            $log.debug('StudentConcessionTypeTableDirectiveController::init called');
        };

        StudentConcessionType.get(vm.studentId).then(function(response) {
            $log.debug(response.data);
            vm.studentConcessionTypes = response.data;
        }, function(response) {
            $log.debug("EE - Failed to retrieve data for StudentConcessionType");
        });


    }


})();

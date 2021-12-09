/**
 * This is the DuplicateDetection Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('DuplicateDetectionDirective')
        .controller('DuplicateDetectionController', DuplicateDetectionController);

    DuplicateDetectionController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', '$uibModal', 'ApplicationForm'];

    function DuplicateDetectionController($log, $scope, $state, $rootScope, $uibModalInstance, $uibModal, ApplicationForm) {
        /* jshint validthis:true */
        var vm = this;

        vm.findDuplicates = findDuplicates;
        vm.duplicateApplication = clear;
        vm.continueApplication = continueApplication;
        vm.selectTwin = selectTwin;

        function findDuplicates() {
            var _dupData = {};
            var surname = application.surname;
            var dob = application.dob;
            if (surname !== null && dob !== null) {
                ApplicationForm.duplicateDetection(surname, dob);
            }
        }

        function selectTwin() {
            // Auto fill the contact details
        }

        function clear() {
            if (confirm("This will clear the current Application form." + "\n" + "Are you sure?")) {
                $uibModalInstance.dismiss('cancel');
            }
        }

        function continueApplication() {
            // continue the application
        }

    }

})();

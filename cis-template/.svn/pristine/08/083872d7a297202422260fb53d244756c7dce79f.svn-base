/**
 * The CollegeFundPaymentEditorController is used to define the main controller for the CollegeFundPaymentEditorDirective.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y022, Y023, Y024, Y031, Y032, Y033, Y034, Y035, Y036, Y090, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('CollegeFundPaymentEditorDirective')
        .controller('CollegeFundPaymentEditorController', CollegeFundPaymentEditorController);

    CollegeFundPaymentEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'CollegeFundPayment'];

    function CollegeFundPaymentEditorController($log, $scope, $state, $rootScope, $uibModal, CollegeFundPayment) {
        // Variables and Constants
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};

        // Public Interface
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.collegeFundPayment = vm.collegeFundPayment ? vm.collegeFundPayment : [];

        vm.loadCollegeFundPayment = loadCollegeFundPayment;
        vm.addCollegeFundPayment = addCollegeFundPayment;
        vm.editCollegeFundPayment = editCollegeFundPayment;

        // Private Interface

        /**
         * This method is used to load the CollegeFundPayments for a specified studentId
         *
         * @param  {Integer} studentId The ID of the student
         */
        function loadCollegeFundPayment(studentId) {
            $log.info('II Loading CollegeFundPayment Data');
            CollegeFundPayment.getByStudent(studentId).then(function(response) {
                $log.info('II CollegeFundPayment Loaded');
                vm.collegeFundPayment = response.data;
            }, function(response) {
                $log.error('EE CollegeFundPayment could not be loaded');
            });
        }

        /**
         * This methods is used to open the add new college fund payments dialog box
         *
         * @param {Integer} studentId The ID of the student
         */
        function addCollegeFundPayment(studentId) {
            $log.log('CollegeFundPaymentEditorController::addContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/college-fund-payment-editor/views/college-fund-payment-editor-dialog.html',
                controller: 'CollegeFundPaymentEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    collegeFundPaymentEntity: function() {
                        var collegeFundPayment = {};
                        collegeFundPayment.studentId = studentId;
                        return collegeFundPayment;
                    }
                }
            });
            // Reload CollegeFundPayment after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadCollegeFundPayment(vm.studentId);
            });
        }

        /**
         * This methods is used to open the edit college fund payment dialog box
         *
         * @param  {Integer} id The ID of the college fund payment to be edited
         */
        function editCollegeFundPayment(id) {
            $log.log('CollegeFundPaymentEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/college-fund-payment-editor/views/college-fund-payment-editor-dialog.html',
                controller: 'CollegeFundPaymentEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    collegeFundPaymentEntity: function(Contact) {
                        return CollegeFundPayment.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            // Reload CollegeFundPayment after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadCollegeFundPayment(vm.studentId);
            });
        }
    }
})();

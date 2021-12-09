/**
 * This is the Enrolments Editor Directive Controller.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('EnrolmentsEditorDirective')
        .controller('EnrolmentsEditorDirectiveController', EnrolmentsEditorDirectiveController);

    EnrolmentsEditorDirectiveController.$inject = ['$scope', '$rootScope', '$uibModal', 'Student', 'Enrolment', 'Logger', 'GLOBAL'];

    function EnrolmentsEditorDirectiveController($scope, $rootScope, $uibModal, Student, Enrolment, Logger, GLOBAL) {
        /* jshint validthis:true */
        var vm = this;
        var DEBUG = GLOBAL.DEBUG;

        vm.dialog = {};

        vm.enrolments = vm.enrolments ? vm.enrolments : [];
        vm.studentId = vm.studentId ? vm.studentId : undefined;

        // Public Interface
        vm.init = init;
        vm.loadEnrolments = loadEnrolments;
        vm.editEnrolment = editEnrolment;
        vm.withdraw = withdraw;

        // Private Interface

        function init() {
            Logger.debug('EnrolmentsEditorController::init called');
            if (vm.studentId !== undefined) {
                vm.loadEnrolments(vm.studentId);
            }
        }

        function loadEnrolments(studentId) {
            Logger.debug('II Loading Enrolments Data');
            Student.enrolments(studentId).then(function(response) {
                Logger.debug('II Contacts Loaded');
                vm.enrolments = response.data;
            }, function(response) {
                Logger.error('EE Enrolments could not be loaded');
            });
        }

        /**
         * This method is used to reload the enrolments for the currently loaded student.
         *
         * @return {void}
         */
        function reloadEnrolments() {
            Logger.debug('II Reloading the enrolment information');
            vm.loadEnrolments(vm.studentId);
        }

        /**
         * This method is used by the modal dialog box to handle the cancelling of the dialog.
         *
         * @return {void}
         */
        function handleCancel() {
            // Do nothinng
            Logger.debug('II Dialog box cancelled.');
        }

        /**
         * This method is used to load a dialog box that will allow the end-user to ediit the enrolment information.
         *
         * @param  {Integer} id the enrolmentId for the enrolment to be edited.
         * @return {void}
         */
        function editEnrolment(id) {
            Logger.debug('EnrolmentsEditorController::editEnrolment called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/enrolments-editor/views/enrolmentEditorDialog.html',
                controller: 'EnrolmentsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    enrolmentEntity: function() {
                        return Enrolment.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            bootbox.alert("Failed to retrieve enrolment.");
                        });
                    }
                }
            });
            // Reload enrolments after dialog closed
            modalInstance.result.then(reloadEnrolments, handleCancel);
        }

        function withdraw(enrolment) {
            Logger.debug('II EnrolmentsEditorDirective :: Withdraw Started');
            Logger.debug(enrolment);
            var modalOptions = {
                templateUrl: 'js/directives/enrolments-editor/views/withdraw.html',
                controller: 'EnrolmentsEditorWithdrawDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    enrolmentEntity: function() {
                        return {
                            data: enrolment
                        };
                    }
                },
                scope: $scope,
            };
            var modalInstance = $uibModal.open(modalOptions);
            // Reload enrolments after dialog closed
            modalInstance.result.then(reloadEnrolments(), handleCancel());
        }
    }

})();

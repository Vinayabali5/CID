/**
 * This is the Student Related staff Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('dialogs-edit-ilp')
        .controller('StudentRelatedStaffEditorDialogController', StudentRelatedStaffEditorDialogController);

    StudentRelatedStaffEditorDialogController.$inject = ['$scope', '$uibModalInstance', '$cidConfig', 'Logger', 'EmailEntry', 'StaffList', 'StaffEmailing'];

    function StudentRelatedStaffEditorDialogController($scope, $uibModalInstance, $cidConfig, Logger, EmailEntry, StaffList, StaffEmailing) {
        /* jshint validthis:true */
        var vm = this;

        $scope.tinymceOptions = $cidConfig.tinymceOptions;

        $scope.email = EmailEntry.data !== undefined ? EmailEntry.data : null;
        $scope.staffList = StaffList.data !== undefined ? StaffList.data : null;
        $scope.model = [];


        vm.sendEmail = sendEmail;
        vm.sendStaffILPNotificationEmail = sendStaffILPNotificationEmail;
        vm.testEmail = testEmail;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('student related staff-sendEmail', result);
            $uibModalInstance.close(result);
        };

        function sendEmail() {
            Logger.log('Student Related staff Controller:: send email called');
            if ($scope.email) {
                //$scope.email.staffList = $scope.model;
                StaffEmailing.create($scope.email, onSaveFinished);
            }
        }

        function sendStaffILPNotificationEmail() {
            Logger.log('Student Related staff Controller:: send email called');
            if ($scope.email) {
                //$scope.email.staffList = $scope.model;
                StaffEmailing.createEamil($scope.email, onSaveFinished);
            }
        }

        function testEmail() {
            Logger.log('Student Related staff Controller:: test email called');
            if ($scope.email) {
                //$scope.email.staffList = $scope.model;
                var email = $scope.email;
                email.staffList = [email.staffId];
                StaffEmailing.create(email, onSaveFinished);
            }
        }

        function cancel() {
            Logger.log('Student related staff Controller::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();

/**
 * This is the ILP Interviews Editor Dialog Controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('ILPInterviewsEditorDirective')
        .controller('ILPInterviewsEditorDialogController', ILPInterviewsEditorDialogController);

    ILPInterviewsEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'ilpInterviewsEntity', 'ILPInterview', 'Auth', 'USER', 'APP'];

    function ILPInterviewsEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, ilpInterviewsEntity, ILPInterview, Auth, USER, APP) {
        /* jshint validthis:true */
        var vm = this;
        vm.ilpInterview = ilpInterviewsEntity !== undefined ? ilpInterviewsEntity : {};
        vm.studentId = vm.ilpInterview ? vm.ilpInterview : undefined;
        vm.staffId = vm.ilpInterview.staffId ? vm.ilpInterview.staffId : undefined;
        vm.currentUser = Auth.getUser();
        vm.currentYear = APP.getYear();
        vm.save = save;
        vm.cancel = cancel;

        vm.ilpInterview.interviewDate = new Date();
        vm.ilpInterview.studentId = vm.ilpInterview.studentId;
        vm.ilpInterview.staffId = vm.currentUser.staffId;
        vm.ilpInterview.academicYearId = vm.currentYear.id;

        var onSaveFinished = function(result) {
            $scope.$emit('ilpInterviews-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This closes the ilpInterviews editor dialog box without saving 
         */
        function cancel() {
            $log.log('ILPInterviewsDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        /**
         * This saves the ilpInterviews and closes that dialog box
         */
        function save() {
            $log.log('ILPInterviewsDialogController::save called');
            $log.info(vm.ilpInterview);
            if (vm.ilpInterview.id) {
                ILPInterview.save(vm.ilpInterview, onSaveFinished);
            } else {
                ILPInterview.create(vm.ilpInterview, onSaveFinished);
            }
        }


    }
})();

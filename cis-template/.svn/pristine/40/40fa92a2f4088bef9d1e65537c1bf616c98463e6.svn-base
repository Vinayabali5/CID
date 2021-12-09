/**
 * This is the Interview Type Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular.module('InterviewTypesEditorDirective')
        .controller('InterviewTypesEditorDialogController', InterviewTypesEditorDialogController);

    InterviewTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'ILPInterviewType', 'interviewTypesEntity'];

    function InterviewTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, ILPInterviewType, interviewTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.interviewTypes = interviewTypesEntity !== undefined ? interviewTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('interviewTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.interviewTypes.id) {
                ILPInterviewType.save(vm.interviewTypes, onSaveFinished);
            } else {
                if (vm.interviewTypes.id !== null) {
                    ILPInterviewType.create(vm.interviewTypes, onSaveFinished);
                }
            }
        }

    }

})();

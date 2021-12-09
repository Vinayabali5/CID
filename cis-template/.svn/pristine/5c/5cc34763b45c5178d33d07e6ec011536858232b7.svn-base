/**
 * This is the Subjects Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('SubjectsEditorDirective')
        .controller('SubjectsEditorDialogController', SubjectsEditorDialogController);

    SubjectsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Subject', 'subjectsEntity'];

    function SubjectsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Subject, subjectsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.subjects = subjectsEntity !== undefined ? subjectsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('subjects-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.subjects.id) {
                Subject.save(vm.subjects, onSaveFinished);
            } else {
                if (vm.subjects.id !== null) {
                    Subject.create(vm.subjects, onSaveFinished);
                }
            }
        }

    }


})();

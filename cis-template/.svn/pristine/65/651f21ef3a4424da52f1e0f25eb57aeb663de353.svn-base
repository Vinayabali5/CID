/**
 * This is the Exam Boards Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ExamBoardsEditorDirective')
        .controller('ExamBoardsEditorDialogController', ExamBoardsEditorDialogController);

    ExamBoardsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'ExamBoard', 'examBoardsEntity'];

    function ExamBoardsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, ExamBoard, examBoardsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.examBoards = examBoardsEntity !== undefined ? examBoardsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('exam-boards-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.examBoards.id !== null) {
                ExamBoard.create(vm.examBoards, onSaveFinished);
            }
        }

        function save() {
            if (vm.examBoards.id) {
                ExamBoard.save(vm.examBoards, onSaveFinished);
            }
        }

    }

})();

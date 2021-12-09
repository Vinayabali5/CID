/**
 * This is the Exam Board Editor Controller
 */
(function() {
    'use strict';

    angular
        .module('ExamBoardsEditorDirective')
        .controller('ExamBoardsEditorController', ExamBoardsEditorController);

    ExamBoardsEditorController.$inject = ['$log', '$scope', '$state', '$uibModal', 'ExamBoard'];

    function ExamBoardsEditorController($log, $scope, $state, $uibModal, ExamBoard) {
        /*jshint validthis: true */
        var vm = this;

        vm.editExamBoards = editExamBoards;
        vm.addExamBoards = addExamBoards;
        vm.loadExamBoards = loadExamBoards;

        function loadExamBoards() {
            ExamBoard.query().then(function(response) {
                $scope.examBoards = response.data;
                $log.info("Loading ExamBoards ");
            }, function(response) {
                $log.error("Failed to load ExamBoards");
            });
        }

        function editExamBoards(examBoardId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/exam-boards-editor/views/exam-boards-editor-edit-dialog.html',
                controller: 'ExamBoardsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    examBoardsEntity: function(ExamBoard) {
                        return ExamBoard.get(examBoardId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadExamBoards();
            });
        }

        function addExamBoards() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/exam-boards-editor/views/exam-boards-editor-add-dialog.html',
                controller: 'ExamBoardsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    examBoardsEntity: function() {
                        var examBoards = {};
                        return examBoards;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadExamBoards();
            });
        }

    }
})();

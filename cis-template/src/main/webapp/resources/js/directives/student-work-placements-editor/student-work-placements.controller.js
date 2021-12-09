/**
 * This is the Work Placement Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentWorkPlacementsEditorDirective')
        .controller('StudentWorkPlacementsEditorController', StudentWorkPlacementsEditorController);

    StudentWorkPlacementsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentWorkPlacement'];

    function StudentWorkPlacementsEditorController($log, $scope, $state, $rootScope, $uibModal, StudentWorkPlacement) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentWorkPlacements = vm.studentWorkPlacements ? vm.studentWorkPlacements : [];
        vm.init = init;
        vm.loadStudentWorkPlacements = loadStudentWorkPlacements;
        vm.editStudentWorkPlacement = editStudentWorkPlacement;
        vm.addStudentWorkPlacement = addStudentWorkPlacement;

        function init() {
            $log.info('II WorkPlacements Editor Initialised');
            vm.loadStudentWorkPlacements(vm.studentId);
        }

        function loadStudentWorkPlacements(studentId) {
            $log.info('II Loading WorkPlacements Data');
            StudentWorkPlacement.getByStudentId(studentId).then(function(response) {
                $log.log('WorkPlacementsEditorController::work placement called');
                vm.studentWorkPlacements = response.data;
            }, function(response) {
                $log.error('EE StudentWorkPlacements could not be loaded');
            });
        }

        function editStudentWorkPlacement(id) {
            $log.log('WorkPlacementsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-work-placements-editor/views/student-work-placements-editor-dialog.html',
                controller: 'StudentWorkPlacementsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentWorkPlacementEntity: ['StudentWorkPlacement', function(StudentWorkPlacement) {
                        return StudentWorkPlacement.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentWorkPlacements(vm.studentId);
            });
        }


        //Create New Work Placement
        function addStudentWorkPlacement(studentId) {
            $log.log('WorkPlacementsEditorController:: AddWorkPlacement called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-work-placements-editor/views/student-work-placements-editor-dialog.html',
                controller: 'StudentWorkPlacementsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentWorkPlacementEntity: [function() {
                        var studentWorkPlacements = {};
                        studentWorkPlacements.studentId = studentId;
                        return studentWorkPlacements;
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentWorkPlacements(vm.studentId);
            });
        }

    }
})();

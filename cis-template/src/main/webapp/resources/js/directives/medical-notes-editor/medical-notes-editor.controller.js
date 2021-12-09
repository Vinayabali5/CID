/**
 * This is the Medical Notes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('MedicalNotesEditorDirective')
        .controller('MedicalNotesEditorController', MedicalNotesEditorController);

    MedicalNotesEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Student'];

    function MedicalNotesEditorController($log, $scope, $rootScope, $uibModal, Student) {
        /* jshint validthis:true */
        var vm = this;
        vm.student = vm.student ? vm.student : {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.init = init;
        vm.loadStudent = loadStudent;
        vm.editMedicalNotes = editMedicalNotes;

        $scope.hasData = function() {
            if ($scope.student && $scope.student !== undefined) {
                return true;
            } else {
                return false;
            }
        };


        function init() {
            $log.log('StudentYearDetailsDirectiveController::init called');
            if (vm.student === undefined) {
                vm.loadStudent(vm.studentId);
            } else {
                vm.studentId = vm.student.studentId;
            }
        }

        function loadStudent(studentId) {
            Student.get(studentId).then(function(response) {
                $log.info('II StudentYear Loaded');
                vm.student = response.data;
                $log.info(vm.student);
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        }

        function editMedicalNotes(studentId) {
            $log.log('MedicalNotesDetailsDirectiveController::editSummary called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/medical-notes-editor/views/medical-notes-editor-dialog.html',
                controller: 'MedicalNotesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentEntity: ['Student', function(Student) {
                        return Student.get(vm.studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudent(vm.studentId);
            });
        }

    }
})();

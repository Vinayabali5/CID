/**
 * This is the Student Special Category Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentRiskLevelEditorDirective')
        .controller('StudentRiskLevelEditorController', studentRiskLevelEditorController);

    studentRiskLevelEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'StudentRiskLevel'];

    function studentRiskLevelEditorController($log, $scope, $rootScope, $uibModal, StudentRiskLevel) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentRiskLevels = vm.studentRiskLevels ? vm.studentRiskLevels : [];
        vm.init = init;
        vm.loadStudentRiskLevel = loadStudentRiskLevel;
        vm.editStudentRiskLevel = editStudentRiskLevel;
        vm.addStudentRiskLevel = addStudentRiskLevel;
        vm.deleteStudentRiskLevel = deleteStudentRiskLevel;
        vm.hasData = hasData;
        vm.hasId = hasId;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadStudentRiskLevel(vm.studentId);
        }

        // Private Interface

        function loadStudentRiskLevel(studentId) {
            StudentRiskLevel.getByStudentId(studentId).then(function(response) {
                $log.info('II StudentRiskLevels Loaded');
                vm.studentRiskLevels = response.data;
            }, function(response) {
                $log.error('EE studentRiskLevel could not be loaded');
            });
        }

        // update the contact information
        function editStudentRiskLevel(id) {
            $log.log('StudentRiskLevelDetailsDirectiveController :: editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-risk-level-editor/views/student-risk-level-editor-dialog.html',
                controller: 'StudentRiskLevelEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentRiskLevelEntity: ['StudentRiskLevel', function(StudentRiskLevel) {
                        return StudentRiskLevel.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                vm.loadStudentRiskLevel(vm.studentId);
            });
        }

        function deleteStudentRiskLevel(index, id) {
            $log.log('StudentRiskLevelsEditorController::deleteStudentRiskLevel called');
            if (id) {
                var msg = "Are you sure you want to delete this Student Risk Level?";
                if (window.confirm(msg)) {
                    StudentRiskLevel.delete(id).then(function(response) {
                        $log.info("II RiskLevel ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete RiskLevel ($studentId)");
                    }).finally(function() {
                        vm.loadStudentRiskLevel(vm.studentId);
                        vm.studentRiskLevels.splice(index, 1);
                        $scope.active = vm.studentRiskLevels.length;
                    });
                }
            }
        }

        function addStudentRiskLevel(studentId) {
            $log.log('StudentRiskLevelDetailsDirectiveController :: addStudentRiskLevel called');
            if (studentId !== null && studentId !== undefined) {
                var modalInstance = $uibModal.open({
                    templateUrl: 'js/directives/student-risk-level-editor/views/student-risk-level-editor-dialog.html',
                    controller: 'StudentRiskLevelEditorDialogController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    resolve: {
                        studentRiskLevelEntity: function() {
                            var studentRiskLevel = {};
                            studentRiskLevel.studentId = studentId;
                            return studentRiskLevel;
                        }
                    }
                });

                modalInstance.result.then().finally(function() {
                    loadStudentRiskLevel(vm.studentId);
                });
            } else {
                $log.error('EE No Student ID Specified');
            }
        }

        function hasData() {
            if (vm.studentRiskLevels && vm.studentRiskLevels !== undefined) {
                return true;
            } else {
                return false;
            }
        }

        function hasId() {
            if (vm.studentId != null && vm.studentId !== undefined) {
                return true;
            } else {
                return false;
            }
        }

    }
})();

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
        .module('StudentSpecialCategoryEditorDirective')
        .controller('StudentSpecialCategoryEditorController', studentSpecialCategoryEditorController);

    studentSpecialCategoryEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Student', 'GLOBAL'];

    function studentSpecialCategoryEditorController($log, $scope, $rootScope, $uibModal, Student, GLOBAL) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.specialCategories = vm.specialCategories ? vm.specialCategories : [];

        vm.loadStudentSpecialCategory = loadStudentSpecialCategory;
        vm.editStudentSpecialCategory = editStudentSpecialCategory;
        vm.addStudentSpecialCategory = addStudentSpecialCategory;
        vm.hasData = hasData;
        vm.hasId = hasId;


        // Private Interface

        function loadStudentSpecialCategory(studentId) {
            Student.specialCategories(studentId).then(function(response) {
                $log.log(response);
                vm.specialCategories = response.data;
            }, function(response) {
                $log.error('EE specialCategory could not be loaded');
            });
        }

        // update the contact information
        function editStudentSpecialCategory(id) {
            $log.log('StudentSpecialCategoryDetailsDirectiveController :: editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/studentSpecialCategoryEditor/views/studentSpecialCategoryEditorDialog.html',
                controller: 'StudentSpecialCategoryEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentSpecialCategoryEntity: ['StudentSpecialCategory', function(StudentSpecialCategory) {
                        return StudentSpecialCategory.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                vm.loadStudentSpecialCategory(vm.studentId);
            });
        }

        function addStudentSpecialCategory(studentId) {
            $log.log('StudentSpecialCategoryDetailsDirectiveController :: addStudentSpecialCategory called');
            if (studentId) {
                var modalInstance = $uibModal.open({
                    templateUrl: 'js/directives/studentSpecialCategoryEditor/views/studentSpecialCategoryEditorDialog.html',
                    controller: 'StudentSpecialCategoryEditorDialogController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    resolve: {
                        studentSpecialCategoryEntity: function() {
                            var studentSpecialCategory = {};
                            studentSpecialCategory.studentId = studentId;
                            return studentSpecialCategory;
                        }
                    }
                });

                modalInstance.result.then().finally(function() {
                    vm.loadStudentSpecialCategory(vm.studentId);
                });
            } else {
                $log.error('EE No Student ID Specified');
            }
        }

        function hasData() {
            if (vm.specialCategories && vm.specialCategories !== undefined) {
                return true;
            } else {
                return false;
            }
        }

        function hasId() {
            if (vm.studentId && vm.studentId !== undefined) {
                return true;
            } else {
                return false;
            }
        }

    }
})();

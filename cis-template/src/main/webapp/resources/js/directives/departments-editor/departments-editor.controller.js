/**
 * This is the Departments Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('DepartmentsEditorDirective')
        .controller('DepartmentsEditorController', DepartmentsEditorController);

    DepartmentsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Department'];

    function DepartmentsEditorController($log, $scope, $state, $rootScope, $uibModal, Department) {
        /* jshint validthis:true */
        var vm = this;

        vm.editDepartments = editDepartments;
        vm.addDepartments = addDepartments;

        function loadDepartments() {
            Department.query().then(function(response) {
                $scope.departments = response.data;
                $log.info("Loading Department ");
            }, function(response) {
                $log.error("Failed to load Department");
            });
        }

        function editDepartments(departmentId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/departments-editor/views/departments-editorDialog.html',
                controller: 'DepartmentsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    departmentsEntity: function(Department) {
                        return Department.get(departmentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadDepartments();
            });
        }

        function addDepartments() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/departments-editor/views/departments-editorDialog.html',
                controller: 'DepartmentsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    departmentsEntity: function() {
                        var departments = {};
                        return departments;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadDepartments();
            });
        }

    }

})();

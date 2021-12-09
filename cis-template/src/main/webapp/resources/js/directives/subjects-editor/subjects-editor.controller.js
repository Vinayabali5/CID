/**
 * This is the Subjects Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('SubjectsEditorDirective')
        .controller('SubjectsEditorController', SubjectsEditorController);

    SubjectsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Subject'];

    function SubjectsEditorController($log, $scope, $state, $rootScope, $uibModal, Subject) {
        /* jshint validthis:true */
        var vm = this;
        vm.subjects = [];
        vm.subject = {};
        vm.searchText = '';
        vm.visible = false;

        vm.loadSubjects = loadSubjects;
        vm.editSubjects = editSubjects;
        vm.addSubjects = addSubjects;

        vm.applyFilter = applyFilter;
        vm.toggleVisibility = toggleVisibility;
        vm.resetFilters = resetFilters;

        function toggleVisibility() {
            vm.visible = !vm.visible;
        }

        // Apply filters
        $scope.filter = {
            code: '',
            description: ''
        };

        function applyFilter() {
            vm.filterParams = {
                code: $scope.filter.code,
                description: $scope.filter.description
            };
        }

        function resetFilters() {

            vm.filterParams = {
                code: '',
                description: ''
            };

            $scope.filter = {
                code: '',
                description: ''
            };
        }


        vm.changeSort = changeSort;
        vm.isSortedAsc = isSortedAsc;
        vm.isSortedDesc = isSortedDesc;

        vm.sortOrder = '+code';

        function changeSort(field) {
            if (vm.sortOrder == '+' + field) {
                vm.sortOrder = '-' + field;
            } else {
                vm.sortOrder = '+' + field;
            }
        }

        function isSortedAsc(fieldName) {
            if (vm.sortOrder == "+" + fieldName) {
                return true;
            }
            return false;
            // check if sortOrder is an array and if it contains fieldName
        }

        function isSortedDesc(fieldName) {
            if (vm.sortOrder == "-" + fieldName) {
                return true;
            }
            return false;
            // check if sortOrder is an array and if it contains fieldName
        }

        function loadSubjects() {
            Subject.query().then(function(response) {
                vm.subjects = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }


        function editSubjects(subjectId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/subjects-editor/views/subjects-editorDialog.html',
                controller: 'SubjectsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    subjectsEntity: function(Subject) {
                        return Subject.get(subjectId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                vm.loadSubjects();
            });

        }


        function addSubjects() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/subjects-editor/views/subjects-editorDialog.html',
                controller: 'SubjectsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    subjectsEntity: function() {
                        var subjects = {};
                        return subjects;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                vm.loadSubjects();
            });

        }

    }

})();

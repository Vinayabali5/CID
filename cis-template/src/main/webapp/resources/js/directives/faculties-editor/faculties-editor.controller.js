/**
 * This is the FAculties Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('FacultiesEditorDirective')
        .controller('FacultiesEditorController', FacultiesEditorController);

    FacultiesEditorController.$inject = ['$log', '$uibModal', '$scope', 'Faculty'];

    function FacultiesEditorController($log, $uibModal, $scope, Faculty) {
        /* jshint validthis:true */
        var vm = this;

        vm.editFaculties = editFaculties;
        vm.addFaculties = addFaculties;

        function loadFaculties() {
            Faculty.query().then(function(response) {
                $scope.facilties = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editFaculties(facultyId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/faculties-editor/views/faculties-editorDialog.html',
                controller: 'FacultiesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    facultiesEntity: function(Faculty) {
                        return Faculty.get(facultyId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadFaculties();
            });
        }

        function addFaculties() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/faculties-editor/views/faculties-editorDialog.html',
                controller: 'FacultiesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    facultiesEntity: function() {
                        var faculties = {};
                        return faculties;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadFaculties();
            });
        }
    }

})();

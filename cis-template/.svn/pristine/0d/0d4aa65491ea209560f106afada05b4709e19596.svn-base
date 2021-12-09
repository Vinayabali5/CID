/**
 * This is the Schools Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('SchoolsEditorDirective')
        .controller('SchoolsEditorController', SchoolsEditorController);

    SchoolsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'School'];


    function SchoolsEditorController($log, $scope, $state, $rootScope, $uibModal, School) {
        /* jshint validthis:true */

        var vm = this;

        vm.editSchools = editSchools;
        vm.addSchools = addSchools;

        function editSchools(schoolId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/schools-editor/views/school-editorDialog.html',
                controller: 'SchoolsEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    schoolsEntity: function(School) {
                        return School.get(schoolId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }
                }
            });
        }

        function addSchools() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/schools-editor/views/school-editorDialog.html',
                controller: 'SchoolsEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    schoolsEntity: function() {
                        var schools = {};
                        return schools;
                    }
                }
            });
        }

    }
})();

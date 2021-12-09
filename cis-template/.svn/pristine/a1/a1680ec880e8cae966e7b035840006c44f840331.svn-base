/**
 * This is the AcademicYears Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('AcademicYearsEditorDirective')
        .controller('AcademicYearsEditorController', AcademicYearsEditorController);

    AcademicYearsEditorController.$inject = ['$log', '$uibModal', '$scope', 'AcademicYear'];

    function AcademicYearsEditorController($log, $uibModal, $scope, AcademicYear) {
        /* jshint validthis:true */
        var vm = this;

        vm.editAcademicYears = editAcademicYears;
        vm.addAcademicYears = addAcademicYears;

        function loadAcademicYears() {
            AcademicYear.query().then(function(response) {
                $scope.academicYears = response.data;
                $log.info("Loading AcademicYears ");
            }, function(response) {
                $log.error("Failed to load AcademicYears");
            });
        }

        function editAcademicYears(academicYearId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/academic-years-editor/views/academic-years-editorDialog.html',
                controller: 'AcademicYearsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    academicYearsEntity: ['AcademicYear', function(AcademicYear) {
                        return AcademicYear.get(academicYearId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadAcademicYears();
            });
        }

        function addAcademicYears() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/academic-years-editor/views/academic-years-editor-addDialog.html',
                controller: 'AcademicYearsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    academicYearsEntity: [function() {
                        var academicYears = {};
                        return academicYears;
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadAcademicYears();
            });
        }
    }

})();

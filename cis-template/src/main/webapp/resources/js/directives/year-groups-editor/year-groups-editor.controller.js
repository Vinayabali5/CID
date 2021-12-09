/**
 * This is the YearGroups Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('YearGroupsEditorDirective')
        .controller('YearGroupsEditorController', YearGroupsEditorController);

    YearGroupsEditorController.$inject = ['$log', '$uibModal', '$scope', 'YearGroup'];

    function YearGroupsEditorController($log, $uibModal, $scope, YearGroup) {
        /* jshint validthis:true */
        var vm = this;

        vm.editYearGroups = editYearGroups;
        vm.addYearGroups = addYearGroups;

        function loadYearGroups() {
            YearGroup.query().then(function(response) {
                $scope.yearGroups = response.data;
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editYearGroups(yearGroupId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/year-groups-editor/views/year-groups-editorDialog.html',
                controller: 'YearGroupsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    yearGroupsEntity: function(YearGroup) {
                        return YearGroup.get(yearGroupId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadYearGroups();
            });
        }

        function addYearGroups() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/year-groups-editor/views/year-groups-editorDialog.html',
                controller: 'YearGroupsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    yearGroupsEntity: function() {
                        var yearGroups = {};
                        return yearGroups;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadYearGroups();
            });
        }

    }

})();

/**
 * This is the Periods Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('PeriodsEditorDirective')
        .controller('PeriodsEditorController', PeriodsEditorController);

    PeriodsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Period'];

    function PeriodsEditorController($log, $scope, $state, $rootScope, $uibModal, Period) {
        /* jshint validthis:true */
        var vm = this;

        vm.editPeriods = editPeriods;
        vm.addPeriods = addPeriods;

        function editPeriods(periodId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/periods-editor/views/periods-editorDialog.html',
                controller: 'PeriodsEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    periodsEntity: function(Period) {
                        return Period.get(periodId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }
                }
            });
        }

        function addPeriods() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/periods-editor/views/periods-editorDialog.html',
                controller: 'PeriodsEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    periodsEntity: function() {
                        var periods = {};
                        return periods;
                    }
                }
            });
        }

    }

})();

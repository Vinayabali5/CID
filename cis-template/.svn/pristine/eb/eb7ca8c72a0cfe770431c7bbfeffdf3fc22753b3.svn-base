/**
 * This is the Holidays Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('HolidaysEditorDirective')
        .controller('HolidaysEditorController', HolidaysEditorController);

    HolidaysEditorController.$inject = ['$log', '$uibModal', '$scope', 'Holiday'];

    function HolidaysEditorController($log, $uibModal, $scope, Holiday) {
        /* jshint validthis:true */
        var vm = this;

        vm.editHolidays = editHolidays;
        vm.addHolidays = addHolidays;

        function loadHolidays() {
            Holiday.query().then(function(response) {
                $scope.holidays = response.data;
                $log.info("Loading Holidays ");
            }, function(response) {
                $log.error("Failed to load Holidays");
            });
        }

        function editHolidays(holidayId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/holidays-editor/views/holidays-editorDialog.html',
                controller: 'HolidaysEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    holidaysEntity: function(Holiday) {
                        return Holiday.get(holidayId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadHolidays();
            });
        }

        function addHolidays() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/holidays-editor/views/holidays-editorDialog.html',
                controller: 'HolidaysEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    holidaysEntity: function() {
                        var holidays = {};
                        return holidays;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadHolidays();
            });
        }

    }

})();

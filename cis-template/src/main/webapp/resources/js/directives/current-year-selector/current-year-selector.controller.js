/**
 * This is the Current Year Selector Controller,used by CurrentYearSelectorDirective
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('CurrentYearSelectorDirective')
        .controller('CurrentYearSelectorController', CurrentYearSelectorController);

    CurrentYearSelectorController.$inject = ['$scope', '$rootScope', 'AcademicYear', 'Logger', 'GLOBAL', 'APP'];

    function CurrentYearSelectorController($scope, $rootScope, AcademicYear, Logger, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;
        var DEBUG = GLOBAL.DEBUG;
        vm.currentYear = APP.getYear();

        init();

        function init() {
            if (vm.currentYear.id === undefined) {
                AcademicYear.getCurrent().then(function(response) {
                    APP.setYear(response.data);
                    vm.currentYear = APP.getYear();
                });
                getAcademicYear();
            }
            $scope.$watch(function() {
                return vm.currentYear.id;
            }, function() {
                Logger.debug('II Year Changed');
                getAcademicYear();
            });
        }

        function getAcademicYear() {
            if (vm.currentYear.id !== undefined) {
                AcademicYear.get(vm.currentYear.id).then(function(response) {
                    Logger.debug('II Successfully retrieved AcademicYear');
                    Logger.debug(vm.currentYear);
                    APP.setYear(response.data);
                    vm.currentYear = APP.getYear();
                    $rootScope.$emit("current-year-changed");
                }, function(response) {
                    Logger.error('EE Cannot retrieve the defaults current year.');
                    vm.currentYear = undefined;
                });
            }
        }
    }
})();

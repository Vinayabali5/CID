/**
 * This is the Registers Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('RegistersTableDirective')
        .controller('RegistersTableController', RegistersTableController);

    RegistersTableController.$inject = ['$scope'];

    function RegistersTableController($scope) {
        /* jshint validthis:true */
        var vm = this;
        vm.toggleVisibility = toggleVisibility;
        vm.applyFilter = applyFilter;

        function toggleVisibility() {
            vm.visible = !vm.visible;
        }
        $scope.registerFilter = {};
        // Apply filters
        $scope.filter = {
            subjectCode: '',
            group: ''

        };

        function applyFilter() {
            vm.filterParams = {
                subjectCode: $scope.filter.subjectCode,
                group: $scope.filter.group
            };
        }
    }

})();

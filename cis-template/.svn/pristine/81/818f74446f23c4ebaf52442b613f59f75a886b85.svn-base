/**
 * This is the AbsenceTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 * 
 */


(function() {
    'use strict';

    angular
        .module('StaffAbsenceTableDirective', [])
        .directive('staffAbsenceTable', staffAbsenceTable);

    function staffAbsenceTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                staffabsence: '=',
                reasonFilter: '=?filter',
                filterType: '=?filterType',
                showFilter: '=?',
                showDays: '=?',
                showType: '=?',
            },
            templateUrl: 'js/directives/staff-absence-table/staff-absence-table.html',
            controller: ['$scope', function($scope) {
                $scope.filter = {
                    absenceReasonId: ''
                };
            }]
        };
    }
})();

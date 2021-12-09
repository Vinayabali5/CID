/**
 * This is the StudentEntryQualificationsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 * 
 *  @type Directive
 */


(function() {
    'use strict';

    angular
        .module('StudentEntryQualificationsTableDirective', [])
        .directive('studentEntryQualificationsTable', studentEntryQualificationsTable);

    function studentEntryQualificationsTable() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentEntryQualifications: '=?',
            },
            templateUrl: 'js/directives/student-entry-qualifications-table/student-entry-qualifications-table.html'
        };

        return directive;
    }
})();

/**
 * This is the CorrespondenceTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 */

(function() {
    'use strict';

    angular
        .module('CorrespondenceTableDirective', ['EntityServices', 'ngSanitize'])
        .directive('correspondenceTable', correspondenceTable);

    function correspondenceTable() {

        var directive = {
            restrict: 'E',
            scope: {
                showIds: '=?',
                showCourse: '=?',
                showAll: '=?',
                correspondence: '=',
            },
            templateUrl: 'js/directives/correspondence-table/correspondence-table.html',
        };
        return directive;
    }

})();

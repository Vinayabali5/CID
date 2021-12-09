/**
 * This is the ExternalResultsArchiveTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */

(function() {
    'use strict';
    angular
        .module('ExternalResultsArchiveTableDirective', [])
        .directive('externalResultsArchiveTable', externalResultsArchiveTable);

    function externalResultsArchiveTable() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                externalResultsArchive: '=?',
            },
            templateUrl: 'js/directives/external-results-archive-table/external-results-archive-table.html'
        };

        return directive;
    }

})();

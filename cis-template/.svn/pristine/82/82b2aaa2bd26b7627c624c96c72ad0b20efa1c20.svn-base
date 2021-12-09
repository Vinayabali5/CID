/**
 * This is the ReportingPeriod Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 *  
 *   */
(function() {
    'use strict';

    angular
        .module('ReportingPeriodsEditorDirective', ['EntityServices'])
        .directive('reportingPeriodsEditor', reportingPeriodsEditor);

    function reportingPeriodsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                reportingPeriods: '=?',
                showActions: '=?'
            },
            controller: 'ReportingPeriodsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/reporting-periods-editor/views/reporting-periods-editor.html',
        };

        return directive;

    }
})();

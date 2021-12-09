/**
 * This is the PastoralMonitorDetails Directive definition.
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
        .module('PastoralMonitorDetailsDirective', ['EntityServices'])
        .directive('pastoralMonitorDetails', pastoralMonitorDetails);

    function pastoralMonitorDetails() {
        return {
            restrict: 'E',
            scope: {
                pastoralMonitor: '=',
            },
            templateUrl: 'js/directives/pastoral-monitor-details/pastoral-monitor-details.html',
        };
    }
})();

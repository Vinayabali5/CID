/**
 * This is the PastoralMonitor Editor Directive definition.
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
        .module('PastoralMonitorEditorDirective', ['ui.bootstrap.modal', 'EntityServices', 'PastoralMonitorDetailsDirective'])
        .directive('pastoralMonitorEditor', pastoralMonitorEditor);

    function pastoralMonitorEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                id: '@id',
            },
            bindToController: {
                pastoralMonitor: '=',
                studentId: '=',
            },
            controller: 'PastoralMonitorEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/pastoral-monitor-editor/views/pastoral-monitor-editor.html',
        };

        return directive;
    }

})();

/**
 * This is the CentralMonitoring Editor Directive definition.
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
        .module('CentralMonitoringsEditorDirective', ['EntityServices'])
        .directive('centralMonitoringsEditor', centralMonitoringsEditor);

    function centralMonitoringsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                centralMonitorings: '=?',
                showActions: '=?'
            },
            controller: 'CentralMonitoringsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/central-monitorings-editor/views/central-monitorings-editor.html',
        };

        return directive;

    }
})();

/**
 * This is the PunctualityMonitoring Editor Directive definition.
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
        .module('PunctualityMonitoringsEditorDirective', ['EntityServices'])
        .directive('punctualityMonitoringsEditor', punctualityMonitoringsEditor);

    function punctualityMonitoringsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                punctualityMonitorings: '=?',
                showActions: '=?'
            },
            controller: 'PunctualityMonitoringsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/punctuality-monitorings-editor/views/punctuality-monitorings-editor.html',
        };

        return directive;

    }
})();

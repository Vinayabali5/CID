/**
 * This is the AttendanceMonitoring Editor Directive definition.
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
        .module('AttendanceMonitoringsEditorDirective', ['EntityServices'])
        .directive('attendanceMonitoringsEditor', attendanceMonitoringsEditor);

    function attendanceMonitoringsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                attendanceMonitorings: '=?',
                showActions: '=?'
            },
            controller: 'AttendanceMonitoringsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/attendance-monitorings-editor/views/attendance-monitorings-editor.html',
        };

        return directive;

    }
})();

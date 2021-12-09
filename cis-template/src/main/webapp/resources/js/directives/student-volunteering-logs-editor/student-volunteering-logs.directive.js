/**
 * This is the student volunteering LogsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentVolunteeringLogsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentVolunteeringLogsEditor', studentVolunteeringLogsEditor);

    function studentVolunteeringLogsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStudentVolunteeringLogs: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentVolunteeringLogs: '='
            },
            controller: 'StudentVolunteeringLogsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-volunteering-logs-editor/views/student-volunteering-logs-editor.html'
        };

        return directive;

    }

})();

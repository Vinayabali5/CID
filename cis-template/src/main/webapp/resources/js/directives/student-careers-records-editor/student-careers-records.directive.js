/**
 * This is the CareersRecordsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentCareersRecordsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentCareersRecordsEditor', studentCareersRecordsEditor);

    function studentCareersRecordsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStudentCareersRecords: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentCareersRecords: '='
            },
            controller: 'StudentCareersRecordsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-careers-records-editor/views/student-careers-records-editor.html'
        };

        return directive;

    }

})();

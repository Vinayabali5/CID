/**
 * This is the StudentDukeOfEdinburghsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentDukeOfEdinburghsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentDukeOfEdinburghsEditor', studentDukeOfEdinburghsEditor);

    function studentDukeOfEdinburghsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStudentDukeOfEdinburghs: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentDukeOfEdinburghs: '='
            },
            controller: 'StudentDukeOfEdinburghsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-duke-of-edinburghs-editor/views/student-duke-of-edinburghs-editor.html'
        };

        return directive;

    }

})();

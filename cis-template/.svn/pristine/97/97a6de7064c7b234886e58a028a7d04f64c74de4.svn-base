/**
 * This is the EntryQualificationsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentLearningSupportVisitsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentLearningSupportVisitsEditor', studentLearningSupportVisitsEditor);

    function studentLearningSupportVisitsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentLearningSupportVisits: '='
            },
            controller: 'StudentLearningSupportVisitsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-learning-support-visits-editor/views/student-learning-support-visits-editor.html'
        };

        return directive;

    }

})();

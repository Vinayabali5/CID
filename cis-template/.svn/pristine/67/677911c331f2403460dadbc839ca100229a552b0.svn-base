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
        .module('StudentLearningSupportCostsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentLearningSupportCostsEditor', studentLearningSupportCostsEditor);

    function studentLearningSupportCostsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentLearningSupportCosts: '='
            },
            controller: 'StudentLearningSupportCostsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-learning-support-costs-editor/views/student-learning-support-costs-editor.html'
        };

        return directive;

    }

})();

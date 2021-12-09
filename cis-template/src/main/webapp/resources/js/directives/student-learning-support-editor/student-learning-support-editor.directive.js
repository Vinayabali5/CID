/**
 * This is the StudentLearningSupport Editor Directive definition.
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
        .module('StudentLearningSupportEditorDirective', ['ui.bootstrap.modal', 'EntityServices', 'StudentLearningSupportDetailsDirective'])
        .directive('studentLearningSupportEditor', studentLearningSupportEditor);

    function studentLearningSupportEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentLearningSupport: '=',
                studentId: '=',
            },
            bindToController: {
                studentId: '=',
                studentLearningSupport: '='
            },
            controller: 'StudentLearningSupportEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-learning-support-editor/views/student-learning-support-editor.html',
        };

        return directive;
    }

})();

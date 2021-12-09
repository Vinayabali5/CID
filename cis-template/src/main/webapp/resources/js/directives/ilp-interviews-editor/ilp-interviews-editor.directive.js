/**
 * This is the ILPInterviews Editor Directive definition.
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
        .module('ILPInterviewsEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('ilpInterviewsEditor', ilpInterviewsEditor);

    function ilpInterviewsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudentId: '=?',
            },
            bindToController: {
                studentId: '=',
                ilpInterviews: '=?'
            },
            controller: 'ILPInterviewsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/ilp-interviews-editor/views/ilp-interviews-editor.html',
        };

        return directive;
    }

})();

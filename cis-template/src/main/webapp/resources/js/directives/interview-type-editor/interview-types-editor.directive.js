/**
 * This is the InterviewType Editor Directive definition.
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
        .module('InterviewTypesEditorDirective', ['EntityServices'])
        .directive('interviewTypesEditor', interviewTypesEditor);

    function interviewTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                interviewTypes: '=?',
                showActions: '=?'
            },
            controller: 'InterviewTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/interview-type-editor/views/interview-types-editor.html',
        };

        return directive;

    }
})();

/**
 * This is the Subjects Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 *  @type Directive
 *
 *
 */
(function() {
    'use strict';

    angular
        .module('IdentificationViolationsEditorDirective', ['EntityServices'])
        .directive('identificationViolationsEditor', identificationViolationsEditor);

    function identificationViolationsEditor() {
        var directive = {
            restrict: 'E',
            scope: {
                studentId: '=',
                identificationViolations: '=',
                showActions: '=?'
            },
            controller: 'IdentificationViolationsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/identification-violation-editor/views/identification-violation-editor.html',
        };

        return directive;
    }
})();

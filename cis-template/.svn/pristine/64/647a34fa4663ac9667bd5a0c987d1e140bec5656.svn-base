/**
 * This is the StudentWarning Editor Directive definition.
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
        .module('StudentWarningEditorDirective', ['ui.bootstrap.modal', 'EntityServices', 'StudentWarningDetailsDirective'])
        .directive('studentWarningEditor', studentWarningEditor);

    function studentWarningEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                id: '@id',
            },
            bindToController: {
                studentWarning: '=',
                studentId: '=',
            },
            controller: 'StudentWarningEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentWarningEditor/views/studentWarningEditor.html',
        };

        return directive;
    }

})();

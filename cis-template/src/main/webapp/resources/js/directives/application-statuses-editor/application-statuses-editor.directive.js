/**
 * This is the ApplicationStatuss Editor Directive definition.
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
        .module('ApplicationStatusesEditorDirective', ['EntityServices'])
        .directive('applicationStatusesEditor', applicationStatusesEditor);

    function applicationStatusesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                applicationStatuses: '=?',
                showActions: '=?'
            },
            controller: 'ApplicationStatusesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/application-statuses-editor/views/application-statuses-editor.html',
        };

        return directive;

    }
})();

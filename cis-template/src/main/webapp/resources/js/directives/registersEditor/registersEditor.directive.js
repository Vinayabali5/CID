/**
 * This is the RegistersEditorDirective definition.
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
        .module('RegistersEditorDirective', ['ui.bootstrap.modal'])
        .directive('registersEditor', registersEditor);

    function registersEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudentRef: '=?',
                showSessionRef: '=?',
                showFilter: '=?',
                showActions: '=?',
                filter: '=?',
            },
            bindToController: {
                studentId: '=',
                registers: '=',
                filter: '=?'
            },
            controller: 'RegistersEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/registersEditor/views/registersEditor.html',
        };
    }
})();

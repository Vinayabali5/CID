/**
 * This is the Holidays Editor Directive definition.
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
        .module('HolidaysEditorDirective', ['EntityServices'])
        .directive('holidaysEditor', holidaysEditor);

    function holidaysEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                holidays: '=?',
                showActions: '=?'
            },
            controller: 'HolidaysEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/holidays-editor/views/holidays-editor.html',
        };

        return directive;

    }
})();

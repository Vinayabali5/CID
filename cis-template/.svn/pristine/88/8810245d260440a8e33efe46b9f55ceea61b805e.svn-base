/**
 * This is the YearGroup Editor Directive definition.
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
        .module('YearGroupsEditorDirective', ['EntityServices'])
        .directive('yearGroupsEditor', yearGroupsEditor);

    function yearGroupsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                yearGroups: '=?',
                showActions: '=?'
            },
            controller: 'YearGroupsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/year-groups-editor/views/year-groups-editor.html',
        };

        return directive;

    }
})();

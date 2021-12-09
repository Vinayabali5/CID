/**
 * This is the Tutor Groups Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 *
 */

(function() {
    'use strict';

    angular
        .module('TutorGroupsEditorDirective', ['EntityServices'])
        .directive('tutorGroupsEditor', tutorGroupsEditor);

    function tutorGroupsEditor() {
        var directive = {
            restrict: 'E',
            scope: {
                tutorGroups: '=?',
                showActions: '=?'
            },
            controller: 'TutorGroupsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/tutor-groups-editor/views/tutor-groups-editor.html'
        };

        return directive;

    }
})();

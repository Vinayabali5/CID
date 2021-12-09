/**
 * This is the WorkPlacementsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentWorkPlacementsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentWorkPlacementsEditor', studentWorkPlacementsEditor);

    function studentWorkPlacementsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentWorkPlacements: '='
            },
            controller: 'StudentWorkPlacementsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-work-placements-editor/views/student-work-placements-editor.html'
        };

        return directive;

    }

})();

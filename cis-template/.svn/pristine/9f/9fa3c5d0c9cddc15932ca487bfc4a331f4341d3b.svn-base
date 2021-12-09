/**
 * This is the TimetableEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('TimetableEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('timetableEditor', timetableEditor);

    function timetableEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showTimes: '=?',
                showAll: '=?',
                showActions: '=?'
            },
            bindToController: {
                timetable: '=',
                courseGroupId: '=',
            },
            controller: 'TimetableEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/timetable-editor/views/timetable-editor.html'
        };

        return directive;

    }

})();

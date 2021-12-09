/**
 * This is the EnrolmentsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 * 
 *  @type Directive
 */

(function() {
    'use strict';

    angular
        .module('EnrolmentsEditorDirective', ['ui.bootstrap.modal'])
        .directive('enrolmentsEditor', enrolmentsEditorDirective);

    function enrolmentsEditorDirective() {
        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showStudent: '=?',
                showYear: '=?',
                showStatus: '=?',
                showMonitoring: '=?',
                showIlr: '=?',
                showAll: '=?',
                showEnrolment: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                enrolments: '=',
            },
            controller: 'EnrolmentsEditorDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/enrolments-editor/views/list.html',
        };

        return directive;

    }

})();

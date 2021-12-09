/**
 * This is the EnrolmentManagerDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 */

(function() {
    'use strict';

    angular
        .module('EnrolmentManagerDirective', [
            'ui.bootstrap.modal',
            'Lookups',
            'cid.lookup.course-spec-validity',
            'cid.lookup.course-spec',
        ])
        .directive('enrolmentManager', enrolmentManager);

    function enrolmentManager() {
        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showStudent: '=?',
                showYear: '=?',
                showStatus: '=?',
                showAll: '=?',
            },
            bindToController: {
                student: '=',
                enrolments: '=',
            },
            controller: 'EnrolmentManagerDirectiveController',
            controllerAs: 'ctrl',
            //        templateUrl: 'js/directives/enrolment-editor/views/enrolment-checker.html',
            templateUrl: 'js/directives/enrolment-manager/views/enrolment-manager-button.html'

        };

        return directive;
    }

})();

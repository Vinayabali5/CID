/**
 * This is the StudentReferralReason Editor Directive definition.
 *
 * The required params for this directive are the studentId and referralReasons.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 *
 */
(function() {
    'use strict';
    angular
        .module('StudentReferralReasonEditorDirective', ['StudentReferralReasonService'])
        .directive('studentReferralReasonEditor', studentReferralReasonEditor);

    function studentReferralReasonEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showAll: '=?',
                showStudent: '=?',
                showStudentId: '=',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentReferralReason: '='
            },
            controller: 'StudentReferralReasonEditorDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-referral-reason-editor/views/student-referral-reason-editor.html'
        };
        return directive;
    }
})();

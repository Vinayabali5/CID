/**
 * This is the StudentReferralReason Table Directive definition.
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
        .module('StudentReferralReasonTableDirective', [])
        .directive('studentReferralReasonTable', studentReferralReasonTable);

    function studentReferralReasonTable() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentReferralReason: '=?',
            },
            templateUrl: 'js/directives/student-referral-reason-table/student-referral-reason-table.html'
        };

        return directive;
    }
})();

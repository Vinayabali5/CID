/**
 * This is the ContactsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 * @example <college-fund-payment-editor student-id="{ctrl.studentId}" contacts="{ctrl.collegeFundPayments}"></college-fund-payment-editor>
 */
(function() {
    'use strict';

    angular
        .module('CollegeFundPaymentEditorDirective', ['ui.bootstrap.modal'])
        .directive('collegeFundPaymentEditor', collegeFundPaymentEditor);

    function collegeFundPaymentEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                collegeFundPayment: '='
            },
            controller: 'CollegeFundPaymentEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/college-fund-payment-editor/views/college-fund-payment-editor.html',
        };
    }
})();

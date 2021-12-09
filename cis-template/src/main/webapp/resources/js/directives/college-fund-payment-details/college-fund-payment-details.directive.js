/**
 * This directive, is used to display College Fund Payment Details
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y021, Y022, Y023, Y024, Y070, Y074, Y075, ]
 * 
 */


(function() {
    'use strict';
    angular
        .module('CollegeFundPaymentDetailsDirective', [])
        .directive('collegeFundPaymentDetails', collegeFundPaymentDetails);

    function collegeFundPaymentDetails() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                collegeFundPayment: '=',
            },
            templateUrl: 'js/directives/college-fund-payment-details/college-fund-payment-details.html'
        };
        return directive;
    }

})();

/**
 * This directive is used to display an address in a pre formatted way.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y021, Y022, Y023, Y024, Y070, Y074, Y075, ]
 *
 * @author Michael Horgan, Vinaya Bali
 * @example <address-details show-all="true" address="{address object}"></address-details>
 */
(function() {
    'use strict';

    angular
        .module('AddressDetailsDirective', [])
        .directive('addressDetails', addressDetails);

    function addressDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                address: '=',
            },
            templateUrl: 'js/directives/address-details/address-details.html',
        };
    }
})();

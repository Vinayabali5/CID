/**
 * This directive is used for address editor
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */

(function() {
    'use strict';

    angular
        .module('AddressLookupDirective', [
            'ui.bootstrap.modal',
            'PostcodeLookupService',
            'AddressService',
        ])
        .directive('addressLookup', addressLookup);

    addressLookup.$inject = ['$log', 'PostcodeLookup'];

    function addressLookup($log, PostcodeLookup) {

        var directive = {
            restrict: 'E',
            //replace: true,
            scope: {
                showAll: '=?',
                showAddressId: '=?',
                address: '=',
                id: '@id',
                required: '@'
            },
            controller: 'AddressLookupController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/address-lookup/views/address-display.html'
        };

        return directive;
    }
})();

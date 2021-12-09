/**
 * This directive is used for address editor
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */

(function() {
    'use strict';

    angular
        .module('AddressEditorDirective', [
            'ui.bootstrap.modal',
            'PostcodeLookupService',
            'AddressService',
            'AddressDetailsDirective'
        ])
        .directive('addressEditor', addressEditor);

    addressEditor.$inject = ['$log', 'PostcodeLookup'];

    function addressEditor($log, PostcodeLookup) {

        var directive = {
            restrict: 'E',
            replace: true,
            scope: {
                showAll: '=?',
                showAddressId: '=?',
                address: '=',
                id: '@id',
            },
            bindToController: {
                address: '=',
                addressId: '=',
            },
            controller: 'AddressEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/address-editor/views/addressEditor.html'
        };

        return directive;
    }
})();

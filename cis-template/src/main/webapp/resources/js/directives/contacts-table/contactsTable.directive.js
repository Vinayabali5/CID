/**
 * This is the ContactsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 * 
 */


(function() {
    'use strict';

    angular
        .module('ContactsTableDirective', ['EntityServices', 'AddressDetailsDirective'])
        .directive('contactsTable', contactsTable);

    function contactsTable() {
        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showContact: '=?',
                showAll: '=?',
                contacts: '=',
            },
            templateUrl: 'js/directives/contacts-table/contactsTable.html',

        };

        return directive;
    }
})();

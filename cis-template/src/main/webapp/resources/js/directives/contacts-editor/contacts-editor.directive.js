/**
 * This is the ContactsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 * @example <contacts-editor person-id="{ctrl.personId}" contacts="{ctrl.contacts}"></contacts-editor>
 */
(function() {
    'use strict';

    angular
        .module('ContactsEditorDirective', ['ui.bootstrap.modal', 'AddressDetailsDirective'])
        .directive('contactsEditor', contactsEditor);

    function contactsEditor() {
        return {
            restrict: 'E',
            scope: {
                showId: '=?',
                showContact: '=?',
                showPersonId: '=?',
                showAll: '=?',
                showActions: '=?'
            },
            bindToController: {
                personId: '=',
                contacts: '='
            },
            controller: 'ContactsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/contacts-editor/views/contactsEditor.html',
        };
    }
})();

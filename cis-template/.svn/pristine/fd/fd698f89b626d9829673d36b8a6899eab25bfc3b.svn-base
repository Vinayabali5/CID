/**
 * This is the Contacts Table Directive Controller ,used byContactsTableDirective
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('ContactsTableDirective')
        .controller('ContactsTableDirectiveController', ContactsTableDirectiveController);

    ContactsTableDirectiveController.$inject = ['$log', '$scope', '$state', '$rootScope', 'Person', 'Contact'];

    function ContactsTableDirectiveController($log, $scope, $state, $rootScope, Person, Contact) {
        /* jshint validthis:true */
        var vm = this;
        vm.contacts = [];
        vm.init = init;

        function init() {
            $log.log('ContactsTableDirectiveController::init called');
        }
    }

})();

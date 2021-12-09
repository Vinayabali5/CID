/**
 * This is the PersonContactDetailsLookupDirective Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('PersonContactDetailsLookupDirective')
        .controller('PersonContactDetailsLookupDirectiveController', PersonContactDetailsLookupDirectiveController);

    PersonContactDetailsLookupDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'Person'];

    function PersonContactDetailsLookupDirectiveController($log, $scope, $rootScope, Person) {
        /* jshint validthis:true */
        var vm = this;
        this.message = '';

        this.init = function() {
            if (vm.person === undefined && vm.personId) {
                $log.log('II Loading person-details directive with a personId');
                vm.message = 'Loading...';
                Person.get(vm.personId).then(function(response) {
                    vm.person = response.data;
                    vm.message = '';
                    $log.log(vm.person);
                }, function(response) {
                    $log.error('EE Failed to retireve the person details for personId: ' + vm.personId);
                });
            }
            if (vm.person && !vm.personId) {
                $log.log('II Loading person-details directive with a person object');
                vm.message = '';
            }
        };

        this.init();
    }

})();

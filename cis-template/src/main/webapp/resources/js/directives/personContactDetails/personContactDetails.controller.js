/**
 * This is the PersonContactDetails Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('PersonContactDetailsDirective')
        .controller('PersonContactDetailsDirectiveController', PersonContactDetailsDirectiveController);

    PersonContactDetailsDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'Person'];

    function PersonContactDetailsDirectiveController($log, $scope, $rootScope, Person) {
        /* jshint validthis:true */
        var vm = this;
        this.message = '';

        this.init = function() {};

        $scope.hasData = function() {
            if ($scope.person) {
                return true;
            } else {
                return false;
            }
        };

        this.init();


    }

})();

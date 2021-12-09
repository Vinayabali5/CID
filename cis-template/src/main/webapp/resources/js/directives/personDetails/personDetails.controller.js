/**
 * This is the PersonDetailsDirective Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('PersonDetailsDirective')
        .controller('PersonDetailsDirectiveController', PersonDetailsDirectiveController);

    PersonDetailsDirectiveController.$inject = ['$log', '$scope', '$rootScope'];

    function PersonDetailsDirectiveController($log, $scope, $rootScope) {
        /* jshint validthis:true */
        var vm = this;
        this.message = '';

        $scope.hasData = function() {
            if ($scope.person && $scope.person !== undefined) {
                return true;
            } else {
                return false;
            }
        };

    }
})();

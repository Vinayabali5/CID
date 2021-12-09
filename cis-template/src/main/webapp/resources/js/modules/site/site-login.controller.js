/**
 * This is the main sites login controller. This handles the login form processing.
 *
 * Applied Styles: [Y001, Y002, Y010]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('cid.site')
        .controller('MainSiteLoginController', MainSiteLoginController);

    MainSiteLoginController.$inject = ['$log', '$rootScope', '$state', 'Auth'];

    function MainSiteLoginController($log, $rootScope, $state, Auth) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.credentials = {
            username: '',
            password: ''
        };

        vm.message = '';
        vm.error = false;

        vm.login = login;

        // Private Interface

        function login() {
            vm.error = false;
            Auth.login(vm.credentials, function(response) {
                if (response.status == 200) {
                    $state.go('site.home');
                } else {
                    vm.message = response.data.message;
                    vm.error = true;
                }
            }, function(response) {
                vm.message = response.data.message;
                vm.error = true;
            });
        }

    }
})();

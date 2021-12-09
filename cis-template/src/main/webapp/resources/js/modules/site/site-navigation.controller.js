/**
 * This is the main site navigation controller.
 *
 * Styles Applied: [Y001, Y002, Y010, Y021, Y023, Y024, Y031, Y032, Y033, Y034, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('cid.site')
        .controller('MainSiteNavigationController', MainSiteNavigationController);

    MainSiteNavigationController.$inject = ['$rootScope', '$state', 'Logger', 'Auth', 'AUTH_EVENTS', 'GLOBAL', 'APP', 'USER'];

    function MainSiteNavigationController($rootScope, $state, Logger, Auth, AUTH_EVENTS, GLOBAL, APP, USER) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.currentYear = APP.getYear();

        vm.getCurrentYear = getCurrentYear;
        vm.setCurrentYear = setCurrentYear;
        vm.logout = logout;
        vm.authenticated = authenticated;
        vm.userHasRole = userHasRole;

        vm.debug = getDebug;
        vm.reportUrl = getReportUrl;

        vm.currentUser = Auth.getUser;

        vm.userSettings = {
            sideBar: $rootScope.sideBar
        };

        init();

        // Private Interface

        function init() {
            Logger.log('II Initialising the Main Site Navigation Controller');
        }

        function getCurrentYear() {
            return vm.currentYear;
        }

        function setCurrentYear(year) {
            $rootScope.currentYear = year;
        }

        function logout() {
            Logger.log('II Logging Out');
            Auth.logout();
            $state.go('login');
        }

        function authenticated() {
            return Auth.isAuthenticated();
        }

        function userHasRole(role) {
            return Auth.isAuthorised(role);
        }

        function getDebug() {
            return GLOBAL.DEBUG;
        }

        function getReportUrl() {
            return GLOBAL.REPORT_URL;
        }

        function getAppYear() {
            return APP.getYear();
        }

        $rootScope.$watch(getAppYear, function() {
            vm.currentYear = APP.getYear();
        });

        // Register Event Listners
        $rootScope.$on('year-changed', function(data) {
            vm.currentYear = APP.getYear();
        });

    }
})();

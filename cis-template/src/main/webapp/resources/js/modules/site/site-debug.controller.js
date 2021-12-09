/**
 * This is the MainSiteDebugController definition that defines how the debug information is displayed.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('cid.site')
        .controller('MainSiteDebugController', MainSiteDebugController);

    MainSiteDebugController.$inject = ['$scope', '$rootScope', 'Auth', 'Logger', 'GLOBAL', 'APP', 'USER'];

    function MainSiteDebugController($scope, $rootScope, Auth, Logger, GLOBAL, APP, USER) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.info = {};
        vm.currentYear = APP.getYear();
        vm.userGlobals = $rootScope.globals;
        vm.globals = GLOBAL;
        vm.currentUser = Auth.getUser();

        vm.state = stateInformation();

        vm.userSettings = USER.load();

        vm.show = USER.getSetting('debugInfoEnabled');

        vm.visible = isVisible;

        // Public Methods
        vm.toggleShow = toggleShow;

        // Private Interface

        /**
         * This method is used to determine if the debug information panel should be displayed to the user based on the GLOBAL.DEBUG setting
         * and the roles assigned to the user.
         *
         * If the GLOBAL.DEBUG setting is True then the dubug panel will appear for all users.
         * If the current user has the Developer role then the debug panel will appear.
         *
         * @return {Boolean} This returns if the debug panel should appear based on various rules.
         */
        function isVisible() {
            var hasRole = Auth.isAuthorised('ROLE_Developer');
            return GLOBAL.DEBUG === true || hasRole === true;
        }

        function toggleShow() {
            USER.setSetting('debugInfoEnabled', vm.show);
        }

        function getAppYear() {
            return APP.getYear();
        }

        function stateInformation() {
            return {
                toState: APP.getCurrentState(),
                toStateParams: APP.getCurrentStateParams(),
                fromState: APP.getPreviousState(),
                fromStateParams: APP.getPreviousStateParams()
            };
        }

        function getCurrentState() {
            return APP.getCurrentState();
        }

        function getPreviousState() {
            return APP.getPreviousState();
        }

        $rootScope.$watch(getAppYear, function() {
            vm.currentYear = APP.getYear();
        });

        $rootScope.$watchGroup([getCurrentState, getPreviousState], function() {
            vm.state = stateInformation();
        });

    }

})();

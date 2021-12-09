/**
 * This is the Authentication Module
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y070]
 *
 * @type Directive
 */

(function() {
    angular
        .module('cid.core.authentication')
        .directive('permission', PermissionDirective);

    PermissionDirective.$inject = ['Auth', 'Logger'];

    function PermissionDirective(Auth, Logger) {
        PermissionController.$inject = ['$scope', '$element', 'Auth'];

        function PermissionController($scope, $element, Auth) {
            var vm = this;
            $element.hide();
            $scope.$watch(Auth.isAuthenticated, function() {
                Logger.debug('### PERMISSION CHECK ###');
                Logger.debug($scope);
                Logger.debug($element);
                if (Auth.isAuthorised(vm.permission)) {
                    $element.show();
                }
                if (vm.permissionNot !== undefined && vm.permissionNot !== null && Auth.isAuthorised(vm.permissionNot)) {
                    $element.hide();
                }
            });
        }

        return {
            restrict: 'A',
            bindToController: {
                permission: '=',
                permissionNot: '=?'
            },
            controller: PermissionController
        };
    }

})();

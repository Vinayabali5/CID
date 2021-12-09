/**
 * This is the Tutor Group Remark Permission Table 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('TutorGroupRemarkPermissionTableDirective')
        .controller('TutorGroupRemarkPermissionTableDirectiveController', TutorGroupRemarkPermissionTableDirectiveController);

    TutorGroupRemarkPermissionTableDirectiveController.$inject = ['$log', '$scope', '$state', '$rootScope', 'StudentYear'];

    function TutorGroupRemarkPermissionTableDirectiveController($log, $scope, $state, $rootScope, StudentYear) {
        /* jshint validthis:true */
        var vm = this;
        vm.remarkPermission = [];

        vm.init = function() {
            $log.log('StudentConcessionTypeTableDirectiveController::init called');
        };
    }

})();

/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.signin-history')
        .controller('StaffSigninHistoryController', StaffSigninHistoryController);

    StaffSigninHistoryController.$inject = ['$log', '$scope', 'signinHistory', 'Auth'];

    function StaffSigninHistoryController($log, $scope, signinHistory, Auth) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.currentUser = Auth.getUser();

        var staffSignin = signinHistory != null ? signinHistory.data : [];

        $scope.staffSignin = staffSignin;

        $scope.months = [{
            number: 1,
            month: 'Jan'
        }, {
            number: 2,
            month: 'Feb'
        }, {
            number: 3,
            month: 'Mar'
        }, {
            number: 4,
            month: 'April'
        }, {
            number: 5,
            month: 'May'
        }, {
            number: 6,
            month: 'June'
        }, {
            number: 7,
            month: 'Jul'
        }, {
            number: 8,
            month: 'Aug'
        }, {
            number: 9,
            month: 'Sep'
        }, {
            number: 10,
            month: 'Oct'
        }, {
            number: 11,
            month: 'Nov'
        }, {
            number: 12,
            month: 'Dec'
        }];

        $scope.filter = function() {
            $scope.staffSignin = staffSignin.filter(function(o) {
                return angular.forEach(new Date(o.signinTime).getMonth() + 1 == $scope.sel);
            });
        };

    }
})();

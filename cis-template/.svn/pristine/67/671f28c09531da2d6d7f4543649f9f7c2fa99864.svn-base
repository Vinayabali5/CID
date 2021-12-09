/**
 * The Search Module for finding applicants
 */
(function() {
    'use strict';

    angular
        .module('cid.admissions')
        .controller('ApplicationListController', ApplicationListController);

    ApplicationListController.$inject = ['Logger', '$scope', '$http', 'ApplicationForm', 'applicationListEntity'];

    function ApplicationListController(Logger, $scope, $http, ApplicationForm, applicationListEntity) {
        /* jshint validthis:true */
        var vm = this;

        $scope.applicationListEntity = applicationListEntity.data != undefined ? applicationListEntity.data : [];

        $scope.viewby = 25;
        $scope.totalItems = $scope.applicationListEntity.length;
        $scope.currentPage = 1;
        $scope.itemsPerPage = $scope.viewby;
        /* Number of pager buttons to show */
        $scope.maxSize = 10;

        $scope.setPage = function(pageNo) {
            $scope.currentPage = pageNo;
        };

        $scope.pageChanged = function() {
            Logger.log('Page changed to: ' + $scope.currentPage);
        };

        $scope.setItemsPerPage = function(num) {
            $scope.itemsPerPage = num;
            /* reset to first page */
            $scope.currentPage = 1;
        };

    }

})();

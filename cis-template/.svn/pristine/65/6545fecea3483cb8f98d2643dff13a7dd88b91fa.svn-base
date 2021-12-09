/**
 * The Search Module for finding applicants
 */
(function() {
    'use strict';

    angular
        .module('cid.admissions')
        .controller('ApplicationSearchController', ApplicationSearchController);

    ApplicationSearchController.$inject = ['$log', '$scope', '$http', 'ApplicationForm'];

    function ApplicationSearchController($log, $scope, $http, ApplicationForm) {
        /* jshint validthis:true */
        var vm = this;

        /// Public Interface - Variables
        $scope.applicationList = [];
        $scope.message = null;

        // Public Interface - Methods
        $scope.search = search;
        $scope.hasResults = hasResults;

        // Initialise 
        focusInput();

        // Private Interface
        /**
         * This method is used to perform a search for an application based on the name or student ID. 
         * 
         * @param {*} search The is the search value to use for the search
         */
        function search(search) {
            $log.debug('II StudentSearchController :: search called');
            $scope.message = "Loading please wait!";
            ApplicationForm.search(search).then(function(response) {
                $scope.applicationList = response.data;
                $scope.message = null;
            }, function(response) {
                $scope.message = response.data.message;
            });
        }

        /**
         * This method is used to focus the input search field
         * 
         */
        function focusInput() {
            $('input[autofocus]:visible:first').focus();
        }

        /**
         * This method is used to determine if the controller has any search results in memory.
         */
        function hasResults() {
            if ($scope.applicationList !== null && $scope.applicationList.length !== 0) {
                return true;
            }
            return false;
        }

    }
})();

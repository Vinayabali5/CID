/**
 * The Search Module for finding applicants
 */
(function() {
    'use strict';

    angular
        .module('cid.admissions')
        .controller('ApplicationAcceptanceRegistrationController', ApplicationAcceptanceRegistrationController);

    ApplicationAcceptanceRegistrationController.$inject = ['Logger', '$scope', '$http', '$rootScope', 'ApplicationForm', 'StudentLLDDHealthProblemCategory', 'Student'];

    function ApplicationAcceptanceRegistrationController(Logger, $scope, $http, $rootScope, ApplicationForm, StudentLLDDHealthProblemCategory, Student) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - variables
        $scope.llddHealthProblemCategory = [];
        $scope.visible = false;
        $scope.message = null;

        $scope.acceptanceRegistration = null;
        $scope.llddHealthProblemCategory = null;

        // Public Interface - methods
        $scope.search = search;
        $scope.loadAcceptanceRegistration = loadAcceptanceRegistration;
        $scope.save = save;

        $scope.hasResults = hasResults;
        $scope.resultsVisible = resultsVisible;
        $scope.toggleResults = toggleResults;

        // Initialise 
        clearSearchResults();
        clearRecord();
        focusInput();

        // Private Interface

        /**
         * This method is used to perform a search for an application based on the name or student ID. 
         * 
         * @param {*} search The is the search value to use for the search
         */
        function search(search) {
            Logger.debug('II StudentSearchController :: search called');
            clearSearchResults();
            clearRecord();
            $scope.message = "Loading please wait!";
            ApplicationForm.search(search).then(function(response) {
                $scope.applicationList = response.data;
                if ($scope.hasResults()) {
                    $scope.visible = true;
                }
                $scope.message = null;
            }, function(response) {
                $scope.visible = false;
                $scope.message = response.data.message;
            });
        }

        /**
         * This method is used to load an AcceptanceRegistration and all associated data.
         * 
         * @param {Integer} id The ID for the record to load.
         */
        function loadAcceptanceRegistration(id) {
            if (id !== null && id !== undefined) {
                StudentLLDDHealthProblemCategory.getByStudentId(id).then(function(response) {
                    $scope.llddHealthProblemCategory = response.data;
                    $rootScope.$emit('lldd-health-problem-categories.loaded');
                }, function(response) {
                    $log.error("Failed to load lldd-health-problem-categories");
                    $scope.llddHealthProblemCategory = null;
                });
                ApplicationForm.get(id).then(function(response) {
                    if (response.data !== null) {
                        $scope.acceptanceRegistration = response.data;
                    }
                });
            }
            $('#collapseAcceptanceRegistrationDetails').show();
            $scope.searchTerm = "";
            $('input[autofocus]:visible:first').focus();
            if (resultsVisible()) toggleResults();
        }

        /**
         * This method is used to save the AcceptanceRegistration data to the API. 
         */
        function save() {
            if ($scope.acceptanceRegistration.id) {
                ApplicationForm.save($scope.acceptanceRegistration);
                $('#collapseAcceptanceRegistrationDetails').hide();
                $scope.searchTerm = "";
                $('input[autofocus]:visible:first').focus();
            }
        }

        /**
         * This method is used to clear the search results.
         */
        function clearSearchResults() {
            $scope.visible = false;
            $scope.applicationList = [];
        }

        /**
         * This method is used to clear the currently loaded record from memory.
         */
        function clearRecord() {
            $('#collapseAcceptanceRegistrationDetails').hide();
            $scope.acceptanceRegistration = null;
            $scope.llddHealthProblemCategory = null;
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
            if ($scope.applicationList !== null && $scope.applicationList.size !== 0) {
                return true;
            }
            return false;
        }

        /**
         * This method is used to determine if the search results should be visible or not. 
         */
        function resultsVisible() {
            if ($scope.hasResults()) {
                return $scope.visible;
            }
            return false;
        }

        /**
         * This method is used to toggle the visibility of the search results. 
         */
        function toggleResults() {
            $scope.visible = !$scope.visible;
        }

    }
})();

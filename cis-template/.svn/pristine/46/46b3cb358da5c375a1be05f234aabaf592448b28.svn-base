/**
 * This file defines the student records module for the CID system.
 */
(function() {
    'use strict';

    angular
        .module('cid.ilp-letters')
        .controller('ILPLettersController', ILPLettersController);

    ILPLettersController.$inject = ['$scope', '$rootScope', 'Logger', 'Letter', 'APP'];

    function ILPLettersController($scope, $rootScope, Logger, Letter, APP) {
        /* jshint validthis:true */
        var vm = this;

        // Controller Properties and Variables
        vm.loading = false;
        vm.ilpLetters = [];

        $scope.letterListType = "readyToProduce";

        init();

        // Register Event Listners
        $scope.$on('$destroy', $rootScope.$on('ilp-letter-saved', function(data) {
            getLettersByListType();
        }));

        $scope.$on('$destroy', $rootScope.$on('ilp-letter-deleted', function(data) {
            getLettersByListType();
        }));

        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            getLettersByListType();
        }));

        $scope.$watch('letterListType', function(newValue, oldValue) {
            if (newValue != oldValue) {
                getLettersByListType();
            }
        });

        // Private Interface

        function init() {
            getLettersReadyToProcess();
        }

        /**
         * This method is used to called various methods depending on the currently selected letterListType
         */
        function getLettersByListType() {
            switch ($scope.letterListType) {
                case "readyToProduce":
                    getLettersReadyToProcess();
                    break;
                case "goingTonight":
                    getLettersGoingTonight();
                    break;
            }
        }

        /**
         * This method is used to retrieve the ILP Letters that are Ready to Process
         */
        function getLettersReadyToProcess() {
            vm.loading = true;
            Letter.getAllAuthorised().then(function(response) {
                vm.ilpLetters = response.data;
            }).finally(function() {
                vm.loading = false;
            });
        }

        /**
         * This method is used to retrieve the ILP Letter that are due to be sent out
         */
        function getLettersGoingTonight() {
            vm.loading = true;
            Letter.getAllGoingTonight().then(function(response) {
                vm.ilpLetters = response.data;
            }).finally(function() {
                vm.loading = false;
            });
        }

    }

})();

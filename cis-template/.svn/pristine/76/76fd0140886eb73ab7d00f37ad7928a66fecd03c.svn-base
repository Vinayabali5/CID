/**
 * This is the Student Search Directive Controller, it is used to handle the student search directive data and controls.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentSearchDirective')
        .controller('StudentSearchController', StudentSearchController);

    StudentSearchController.$inject = ['$log', '$scope', 'StudentSearch'];

    function StudentSearchController($log, $scope, StudentSearch) {
        //Public Interface
        /* jshint validthis:true */
        var vm = this;
        vm.surname = "";
        vm.firstName = "";
        vm.reference = "";
        vm.candidateNo = "";

        vm.loading = false;
        vm.message = "";
        vm.results = [];
        vm.visible = false;

        //Operations
        vm.displayMessage = displayMessage;
        vm.search = search;
        vm.clear = clear;
        vm.executeCallback = executeCallback;
        vm.hasResults = hasResults;
        vm.isLoading = isLoading;
        vm.resultsVisible = resultsVisible;
        vm.toggleResults = toggleResults;
        vm.hideResults = hideResults;
        vm.showResults = showResults;

        //Private Interface
        function displayMessage(message) {
            $log.log('II StudentSearchController :: displayMessage called');
            vm.message = message;
        }

        function search() {
            $log.log('II StudentSearchController :: search called');
            vm.loading = true;
            vm.displayMessage("Loading please wait!");
            vm.results = [];
            StudentSearch.search({
                surname: vm.surname,
                firstName: vm.firstName,
                reference: vm.reference,
                candidateNo: vm.candidateNo
            }).then(function(response) {
                vm.loading = false;
                vm.results = response.data;
                if (vm.hasResults()) {
                    vm.showResults();
                }
                vm.displayMessage("");
            }, function(response) {
                vm.loading = false;
                vm.visible = false;
                vm.displayMessage(response.data.message);
            });
        }

        function clear() {
            $log.log('II StudentSearchController :: clear called');
            vm.surname = "";
            vm.firstName = "";
            vm.reference = "";
            vm.candidateNo = "";
            vm.loading = false;
            vm.visible = false;
            vm.results = [];
        }

        function executeCallback(id) {
            vm.hideResults();
            vm.callback(id);
        }

        function hasResults() {
            if (vm.results.length !== 0) {
                return true;
            }
            return false;
        }

        function isLoading() {
            return vm.loading;
        }

        function resultsVisible() {
            if (vm.hasResults()) {
                return vm.visible;
            }
            return false;
        }

        function toggleResults() {
            vm.visible = !vm.visible;
        }

        function hideResults() {
            vm.visible = false;
        }

        function showResults() {
            vm.visible = true;
        }

    }

})();

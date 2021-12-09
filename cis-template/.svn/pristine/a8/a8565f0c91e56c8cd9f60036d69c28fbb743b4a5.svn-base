/**
 * This is the Course Search Controller it is used to control the Search Course list.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('CourseSearchDirective')
        .controller('CourseSearchController', CourseSearchController);

    CourseSearchController.$inject = ['$log', '$scope', 'CourseSearch'];

    function CourseSearchController($log, $scope, CourseSearch) {
        /* jshint validthis:true */
        var vm = this;
        vm.searchText = "";

        /** this focus on the first visible input with autofocus when angular is ready **/
        $('input[autofocus]:visible:first').focus();

        vm.loading = false;
        vm.message = "";
        vm.results = [];
        vm.visible = false;
        vm.sortOrder = '+spec';

        vm.displayMessage = displayMessage;
        vm.search = search;
        vm.executeCallback = executeCallback;
        vm.hasResults = hasResults;
        vm.isLoading = isLoading;
        vm.resultsVisible = resultsVisible;
        vm.toggleResults = toggleResults;
        vm.hideResults = hideResults;
        vm.showResults = showResults;

        vm.changeSort = changeSort;
        vm.isSortedAsc = isSortedAsc;
        vm.isSortedDesc = isSortedDesc;



        function displayMessage(message) {
            $log.log('II CourseSearchController :: displayMessage called');
            vm.message = message;
        }

        function search() {
            $log.log('II CourseSearchController :: search called');
            vm.loading = true;
            vm.displayMessage("Loading please wait!");
            vm.results = [];
            CourseSearch.search({
                searchText: encodeURIComponent(vm.searchText)
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

        function executeCallback(id) {
            // vm.hideResults();
            // vm.callback(id);
            if (vm.callback) {
                vm.hideResults();
                vm.callback(id);
            } else {
                $log.warning('WW CourseSearchController - No Callback function defined');
            }
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



        function changeSort(field) {
            if (vm.sortOrder == '+' + field) {
                vm.sortOrder = '-' + field;
            } else {
                vm.sortOrder = '+' + field;
            }
        }

        function isSortedAsc(fieldName) {
            if (vm.sortOrder == "+" + fieldName) {
                return true;
            }
            return false;
            // check if sortOrder is an array and if it contains fieldName
        }

        function isSortedDesc(fieldName) {
            if (vm.sortOrder == "-" + fieldName) {
                return true;
            }
            return false;
            // check if sortOrder is an array and if it contains fieldName
        }

    }
})();

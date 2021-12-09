/**
 *
 */
(function() {

    angular
        .module('ExamSeriesTableDirective')
        .controller('ExamSeriesTableDirectiveController', examSeriesTableController);

    examSeriesTableController.$inject = ['$log', '$scope', '$state', '$rootScope', 'ExamSeries', 'APP'];

    function examSeriesTableController($log, $scope, $state, $rootScope, ExamSeries, APP) {
        var vm = this;

        vm.filterParams = {
            academicYearId: APP.getYear().id
        };
        vm.callGetIndex = callGetIndex;
        vm.searchTerm = '';

        $rootScope.$on("current-year-changed", function() {
            vm.filterParams.academicYearId = APP.getYear().id;
        });

        function callGetIndex(examSeries) {
            $scope.getIndex({
                examSeriesId: examSeries.id
            });
        }
    }
})();

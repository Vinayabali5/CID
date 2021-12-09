/**
 *
 */
(function() {

    angular
        .module('cid.exams.EDIGeneratorTableDirective')
        .controller('EDIGeneratorTableDirectiveController', ediGeneratorTableController);

    ediGeneratorTableController.$inject = ['$log', '$scope', '$state', '$rootScope', 'ExamSeries', 'APP'];

    function ediGeneratorTableController($log, $scope, $state, $rootScope, ExamSeries, APP) {
        var vm = this;

        vm.examBoardList = $scope.examSeriesList;
        vm.filterParams = {
            academicYearId: APP.getYear().id
        };

        $rootScope.$on("current-year-changed", function() {
            vm.filterParams.academicYearId = APP.getYear().id;
        });
    }
})();

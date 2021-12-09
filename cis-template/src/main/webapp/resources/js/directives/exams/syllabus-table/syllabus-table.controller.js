(function() {
    angular
        .module('SyllabusTableDirective')
        .controller('SyllabusTableDirectiveController', syllabusTableController);

    syllabusTableController.$inject = ['$rootScope', '$scope', '$http', '$uibModal', 'Syllabus', 'APP'];

    function syllabusTableController($rootScope, $scope, $http, $uibModal, Syllabus, APP) {
        console.log('SyllabusTableDirectiveController loaded');
        var vm = this;

        vm.init = init;
        vm.loadSyllabi = loadSyllabi;
        vm.search = search;
        vm.setCurrentExamBoard = setCurrentExamBoard;
        vm.viewDetails = viewDetails;

        init();

        /**
         * getSyllabusNonPageable is used to retrieve the syllabuses that match the syllabusCode.
         */
        function getSyllabusNonPageable() {
            console.log('Loading non pageable');
            vm.syllabusList = [];
            var syllabi = $scope.syllabusCode.split(",");
            syllabi.forEach(function(s) {
                Syllabus.search({
                        examBoardId: $scope.curExamBoard,
                        syllabusCode: s.trim(),
                        examYear: $scope.examYear,
                        examSeries: $scope.examSeries
                    })
                    .then(function(data, status, header) {
                        for (i = 0; i < data.data.length; i++) {
                            vm.syllabusList.push(data.data[i]);
                        }
                    });
            });
        }

        /**
         * function init
         */
        function init() {
            vm.curExamBoard = $scope.$parent.curExamBoard;
            vm.syllabus = $scope.syllabus;
            vm.syllabusList = [];
            vm.searchTerm = '';
            vm.orderReverse = false;
            loadSyllabi();
        }

        /**
         * function loadSyllabi
         */
        function loadSyllabi() {
            getSyllabusNonPageable();
        }

        /**
         * function search
         */
        function search() {
            console.log('$scope.search');
            var search = vm.searchTerm;
            var url = this.url;
            if (search.size > 3) {
                var appList = this.applicationList;
                $http.get(url).then(function(response) {
                    $scope.syllabusList = response;
                });
            }
        }

        /**
         * function setCurrentExamBoard
         */
        function setCurrentExamBoard(newExamBoard) {
            vm.curExamBoard = newExamBoard;
        }

        /**
         * function viewDetails
         */
        function viewDetails(headerCode, headerTitle, details) {
            console.log('$scope.viewDetails');
            var detailsViewer = $uibModal.open({
                templateUrl: 'js/modules/entities/genericViewer/genericViewer.html',
                controller: 'GenericViewerController',
                resolve: {
                    headerVal: function() {
                        return headerCode + " - " + headerTitle;
                    },
                    dataSet: function() {
                        return details;
                    }
                }
            });
        }

        $scope.$on('$destroy', $rootScope.$on('exam-syllabus-saved', loadSyllabi));

        $rootScope.$on("current-year-changed", loadSyllabi);
    }
})();

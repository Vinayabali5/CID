(function() {
    angular
        .module('SyllabusTableDirective', [
            'ngResource',
            'ui.bootstrap',
            'EntityServices',
            'OptionTableDirective',
            'GenericViewer',
            'ExpandDirective',

        ])
        .directive('syllabusTable', syllabusTableDirective);

    syllabusTableDirective.$inject = ['$filter'];

    function syllabusTableDirective($filter) {

        var directive = {
            scope: {
                curExamBoard: '=?',
                syllabus: '=',
                syllabusCode: '=',
                expandable: '=',
                filterParams: '=',
                showCode: '=',
                showTitle: '=',
            },
            link: function(scope, element, attrs, ctrl) {
                scope.$watch("syllabusCode", function(newValue, oldValue) {
                    if (newValue != oldValue) {
                        ctrl.loadSyllabi();
                    }
                });
                scope.$watch('filterParams', function(newVal, oldVal) {
                    if (newVal !== undefined) {
                        if (newVal.examSeries.examBoard === null) {
                            newVal.examSeries.examBoard = undefined;
                        }

                        var filtered = $filter('filter')(ctrl.syllabusList, scope.filterParams);

                        ctrl.paginationInfo.totalItems = filtered.length;
                    }
                }, true);
            },
            transclude: true,
            controller: 'SyllabusTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/syllabus-table/views/syllabus-table.html',
        };

        return directive;
    }
})();

angular.module('SelectionBoxes').directive('examSeriesSelection', ['ExamSeries', function(ExamSeries) {
    return {
        restrict: 'E',
        scope: {
            id: '@',
            class: '@',
            readOnly: '=?',
            ngmodelvar: '=ngModel'

        },
        link: function(scope, element, attrs) {
            element[0].removeAttribute('id');
            element[0].removeAttribute('class');
            element[0].removeAttribute('read-only');
            element[0].disable = scope.readOnly;
        },
        controller: ['ExamSeries', function(ExamSeries) {
            var vm = this;
            vm.examSeries = [];

            ExamSeries.query().then(function(response) {
                vm.examSeries = response.data;
            }, function(err) {
                alert("Error Retrieving Exam Series");
            });
        }],
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/selections/examSeries/exam-series.selection.html',

    };
}]);

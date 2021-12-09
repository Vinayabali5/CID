(function() {
    'use strict';

    angular
        .module('SelectionBoxes')
        .directive('interimReportEffortGradeSelection', InterimReportEffortGradeSelectionDirective);

    InterimReportEffortGradeSelectionDirective.$inject = ['InterimReportEffortGrade'];

    function InterimReportEffortGradeSelectionDirective(InterimReportEffortGrade) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['InterimReportEffortGrade', function(InterimReportEffortGrade) {
                var vm = this;
                vm.interimReportEffortGrades = [];
                InterimReportEffortGrade.query().then(function(response) {
                    vm.interimReportEffortGrades = response.data;
                }, function(response) {
                    bootbox.alert("Error Retrieving InterimReportEffortGrades");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/interim-report-effort-grade/interim-report-effort-grade.selection.html',

        };
    }

})();

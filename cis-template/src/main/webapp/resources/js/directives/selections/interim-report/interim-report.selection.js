(function() {

    angular
        .module('SelectionBoxes')
        .directive('interimReportSelection', InterimReportSelectionDirective);

    InterimReportSelectionDirective.$inject = ['InterimReport'];

    function InterimReportSelectionDirective(InterimReport) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['InterimReport', function(InterimReport) {
                var vm = this;
                vm.interimReports = [];
                InterimReport.query().then(function(response) {
                    vm.interimReports = response.data;
                }, function(err) {
                    alert("Error Retrieving InterimReports");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/interim-report/interim-report.selection.html',
        };
    }

})();

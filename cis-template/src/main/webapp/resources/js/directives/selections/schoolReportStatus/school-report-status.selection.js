(function() {

    angular
        .module('SelectionBoxes')
        .directive('schoolReportStatusSelection', SchoolReportStatusSelectionDirective);

    SchoolReportStatusSelectionDirective.$inject = ['SchoolReportStatus'];

    function SchoolReportStatusSelectionDirective(SchoolReportStatus) {
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
            controller: ['SchoolReportStatus', function(SchoolReportStatus) {
                var vm = this;
                vm.schoolReportStatus = [];
                SchoolReportStatus.query().then(function(response) {
                    vm.schoolReportStatus = response.data;
                }, function(err) {
                    alert("Error Retrieving SchoolReportStatuss");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/schoolReportStatus/school-report-status.selection.html',
        };
    }

})();

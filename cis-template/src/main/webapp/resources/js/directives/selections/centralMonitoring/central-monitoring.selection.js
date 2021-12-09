(function() {

    angular
        .module('SelectionBoxes')
        .directive('centralMonitoringSelection', CentralMonitoringSelectionDirective);

    CentralMonitoringSelectionDirective.$inject = ['CentralMonitoring'];

    function CentralMonitoringSelectionDirective(CentralMonitoring) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['CentralMonitoring', function(CentralMonitoring) {
                var vm = this;
                vm.centralMonitorings = [];
                CentralMonitoring.query().then(function(response) {
                    vm.centralMonitorings = response.data;
                }, function(err) {
                    alert("Error Retrieving CentralMonitorings");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/centralMonitoring/central-monitoring.selection.html',
        };
    }

})();

(function() {

    angular
        .module('SelectionBoxes')
        .directive('punctualityMonitoringSelection', PunctualityMonitoringSelectionDirective);

    PunctualityMonitoringSelectionDirective.$inject = ['PunctualityMonitoring'];

    function PunctualityMonitoringSelectionDirective(PunctualityMonitoring) {
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
            controller: ['PunctualityMonitoring', function(PunctualityMonitoring) {
                var vm = this;
                vm.punctualityMonitorings = [];
                PunctualityMonitoring.query().then(function(response) {
                    vm.punctualityMonitorings = response.data;
                }, function(err) {
                    alert("Error Retrieving PunctualityMonitorings");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/punctualityMonitoring/punctuality-monitoring.selection.html',
        };
    }

})();

(function() {

    angular
        .module('SelectionBoxes')
        .directive('statusTypeSelection', StatusTypeSelectionDirective);

    StatusTypeSelectionDirective.$inject = ['StatusType'];

    function StatusTypeSelectionDirective(StatusType) {
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
            controller: ['StatusType', function(StatusType) {
                var vm = this;

                vm.statusTypes = [];

                StatusType.query().then(function(response) {
                    vm.statusTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving StatusTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/statusType/status-type.selection.html',
        };
    }

})();

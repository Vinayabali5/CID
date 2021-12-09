(function() {

    angular
        .module('SelectionBoxes')
        .directive('applicationStatusSelection', ApplicationStatusSelectionDirective);

    ApplicationStatusSelectionDirective.$inject = ['ApplicationStatus'];

    function ApplicationStatusSelectionDirective(ApplicationStatus) {
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
            controller: ['ApplicationStatus', function(ApplicationStatus) {
                var vm = this;
                vm.applicationStatuss = [];
                ApplicationStatus.query().then(function(response) {
                    vm.applicationStatuses = response.data;
                }, function(err) {
                    alert("Error Retrieving ApplicationStatuss");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/applicationStatus/application-status.selection.html',
        };
    }

})();

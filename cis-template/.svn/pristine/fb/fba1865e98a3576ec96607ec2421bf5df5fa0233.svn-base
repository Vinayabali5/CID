(function() {

    angular
        .module('SelectionBoxes')
        .directive('maritalStatusSelection', MaritalStatusSelectionDirective);

    MaritalStatusSelectionDirective.$inject = ['MaritalStatus'];

    function MaritalStatusSelectionDirective(MaritalStatus) {
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
            controller: ['MaritalStatus', function(MaritalStatus) {
                var vm = this;
                vm.maritalStatuss = [];
                MaritalStatus.query().then(function(response) {
                    vm.maritalStatuses = response.data;
                }, function(err) {
                    alert("Error Retrieving MaritalStatuss");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/marital-status/marital-status.selection.html',
        };
    }

})();

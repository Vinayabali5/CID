(function() {

    angular
        .module('SelectionBoxes')
        .directive('disabilitySelection', DisabilitySelectionDirective);

    DisabilitySelectionDirective.$inject = ['Disability'];

    function DisabilitySelectionDirective(Disability) {
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
            controller: ['Disability', function(Disability) {
                var vm = this;
                vm.disabilitys = [];
                Disability.query().then(function(response) {
                    vm.disabilities = response.data;
                }, function(err) {
                    alert("Error Retrieving Disabilities");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/disability/disability.selection.html',
        };
    }

})();

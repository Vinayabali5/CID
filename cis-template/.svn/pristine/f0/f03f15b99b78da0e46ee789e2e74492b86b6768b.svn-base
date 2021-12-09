(function() {

    angular
        .module('SelectionBoxes')
        .directive('volunteeringTypeSelection', VolunteeringTypeSelectionDirective);

    VolunteeringTypeSelectionDirective.$inject = ['VolunteeringType'];

    function VolunteeringTypeSelectionDirective(VolunteeringType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '=',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['VolunteeringType', function(VolunteeringType) {
                var vm = this;
                vm.volunteeringTypes = [];
                VolunteeringType.query().then(function(response) {
                    vm.volunteeringTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving VolunteeringTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/volunteering-type/volunteering-type.selection.html',
        };
    }

})();

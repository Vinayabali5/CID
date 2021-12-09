(function() {

    angular
        .module('SelectionBoxes')
        .directive('nationalitySelection', NationalitySelectionDirective);

    NationalitySelectionDirective.$inject = ['Nationality'];

    function NationalitySelectionDirective(Nationality) {
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
            controller: ['Nationality', function(Nationality) {
                var vm = this;
                vm.nationalities = [];
                Nationality.query().then(function(response) {
                    vm.nationalities = response.data;
                }, function(err) {
                    alert("Error Retrieving Nationalities");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/nationality/nationality.selection.html',
        };
    }

})();

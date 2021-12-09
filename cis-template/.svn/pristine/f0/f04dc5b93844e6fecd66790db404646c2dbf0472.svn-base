(function() {

    angular
        .module('SelectionBoxes')
        .directive('genderSelection', GenderSelectionDirective);

    GenderSelectionDirective.$inject = ['Gender'];

    function GenderSelectionDirective(Gender) {
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
            controller: ['Gender', function(Gender) {
                var vm = this;
                vm.genders = [];
                Gender.query().then(function(response) {
                    vm.genders = response.data;
                }, function(err) {
                    alert("Error Retrieving Genders");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/gender/gender.selection.html',
        };
    }

})();

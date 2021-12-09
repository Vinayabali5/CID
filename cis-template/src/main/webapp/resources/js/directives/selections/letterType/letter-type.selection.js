(function() {

    angular
        .module('SelectionBoxes')
        .directive('letterTypeSelection', LetterTypeSelectionDirective);

    LetterTypeSelectionDirective.$inject = ['LetterType'];

    function LetterTypeSelectionDirective(LetterType) {
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
            controller: ['LetterType', function(LetterType) {
                var vm = this;
                vm.letterTypes = [];
                LetterType.query().then(function(response) {
                    vm.letterTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving LetterTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/letterType/letter-type.selection.html',
        };
    }

})();

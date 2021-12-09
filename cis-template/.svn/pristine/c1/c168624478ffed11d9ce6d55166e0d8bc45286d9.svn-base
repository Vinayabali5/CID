(function() {

    angular
        .module('SelectionBoxes')
        .directive('letterWarningParagraphSelection', LetterWarningParagraphSelectionDirective);

    LetterWarningParagraphSelectionDirective.$inject = ['LetterWarningParagraph'];

    function LetterWarningParagraphSelectionDirective(LetterWarningParagraph) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngchange: '=ngChange'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['$scope', 'LetterWarningParagraph', function($scope, LetterWarningParagraph) {
                var vm = this;
                vm.letterWarningParagraphs = [];
                LetterWarningParagraph.query().then(function(response) {
                    vm.letterWarningParagraphs = response.data;
                }, function(err) {
                    alert("Error Retrieving LetterWarningParagraphs");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/letter-warning-paragraph/letter-warning-paragraph.selection.html',
        };
    }

})();

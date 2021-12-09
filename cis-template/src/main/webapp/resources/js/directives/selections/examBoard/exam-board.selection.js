(function() {
    angular
        .module('SelectionBoxes')
        .directive('examBoardSelection', examBoardSelectionDirective);

    examBoardSelectionDirective.$inject = ['ExamBoard'];

    function examBoardSelectionDirective(ExamBoard) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                includeBlank: '=?',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['ExamBoard', function(ExamBoard) {
                var vm = this;
                vm.examBoards = [];
                ExamBoard.query().then(function(response) {
                    vm.examBoards = response.data;
                }, function(response) {
                    alert("Error Retrieving Contact Types");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/examBoard/exam-board.selection.html',
        };
    }
})();

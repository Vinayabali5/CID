angular.module('Lookups').directive('examBoardLookup', function(ExamBoard) {
    return {
        restrict: 'E',
        scope: {
            examBoardId: '=',
        },
        link: function(scope, element) {
            if (scope.examBoardId !== undefined) {
                ExamBoard.get(scope.examBoardId).then(function(response) {
                    scope.examBoard = response.data.description;
                }, function(response) {
                    scope.examBoard = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/examBoard/exam-board.lookup.html',
    };
});

angular.module('ExamBoardTableDirective', ['ngResource',
        'ui.bootstrap',
        'EntityServices',
    ])
    .directive('examBoardTable', function() {
        return {
            scope: false,
            /*{
			examBoardList: '='
//			curExamBoard: '=?',
//			expandable: '=',
		},*/
            transclude: true,
            replace: true,
            controller: 'ExamBoardTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/examBoardTable/examBoardTable.html',
        };
    });

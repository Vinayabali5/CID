angular.module('SelectionBoxes').directive('examSessionSelection', ['ExamSession', function(Room) {
    return {
        restrict: 'E',
        scope: {
            id: '@',
            class: '@',
            readonly: '=?',
            ngmodelvar: '=ngModel'

        },
        link: function(scope, element, attrs) {
            element[0].removeAttribute('id');
            element[0].removeAttribute('class');
            element[0].removeAttribute('readonly');
            element[0].disable = scope.readonly;
        },
        controller: ['ExamSession', function(ExamSession) {
            var vm = this;
            vm.rooms = [];

            ExamSession.query().then(function(response) {
                vm.examSessions = response.data;
            }, function(response) {
                alert("Error Retrieving Exam Sessions");
            });
        }],
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/selections/examSession/examSession.selection.html',

    };
}]);

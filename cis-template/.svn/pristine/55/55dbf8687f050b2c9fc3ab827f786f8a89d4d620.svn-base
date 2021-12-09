angular.module('SelectionBoxes').directive('examComponentSelection', ['Component', function(Component) {
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

            Component.query().then(function(response) {
                vm.examComponents = response.data;
            }, function(response) {
                alert("Error Retrieving Exam Components");
            });
        }],
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/selections/examComponent/examComponent.selection.html',

    };
}]);

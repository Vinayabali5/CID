(function() {

    angular
        .module('SelectionBoxes')
        .directive('subjectSelection', SubjectSelectionDirective);

    SubjectSelectionDirective.$inject = ['Subject'];

    function SubjectSelectionDirective(Subject) {
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
            controller: ['Subject', function(Subject) {
                var vm = this;
                vm.subjects = [];
                Subject.query().then(function(response) {
                    vm.subjects = response.data;
                }, function(err) {
                    alert("Error Retrieving Subjects");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/subject/subject.selection.html',
        };
    }

})();

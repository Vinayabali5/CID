(function() {

    angular
        .module('SelectionBoxes')
        .directive('tutorGroupSelection', TutorGroupSelectionDirective);

    TutorGroupSelectionDirective.$inject = ['TutorGroup'];

    function TutorGroupSelectionDirective(TutorGroup) {
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
            controller: ['TutorGroup', function(TutorGroup) {
                var vm = this;
                vm.tutorGroups = [];
                TutorGroup.query().then(function(response) {
                    vm.tutorGroups = response.data;
                }, function(err) {
                    alert("Error Retrieving TutorGroups");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/tutorGroup/tutor-group.selection.html',
        };
    }

})();

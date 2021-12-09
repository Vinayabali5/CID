(function() {

    angular
        .module('SelectionBoxes')
        .directive('absenceReasonSelection', AbsenceReasonSelectionDirective);

    AbsenceReasonSelectionDirective.$inject = ['AbsenceReason'];

    function AbsenceReasonSelectionDirective(AbsenceReason) {
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
            controller: ['AbsenceReason', '$scope', function(AbsenceReason, $scope) {
                var vm = this;
                vm.absenceReasons = [];
                AbsenceReason.query().then(function(response) {
                    vm.absenceReasons = response.data;
                }, function(err) {
                    alert("Error Retrieving AbsenceReasons");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/absence-reason/absence-reason.selection.html',
        };
    }

})();

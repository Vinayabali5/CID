(function() {

    angular
        .module('SelectionBoxes')
        .directive('programmeTypeSelection', ProgrammeTypeSelectionDirective);

    ProgrammeTypeSelectionDirective.$inject = ['ProgrammeType'];

    function ProgrammeTypeSelectionDirective(ProgrammeType) {
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
            controller: ['ProgrammeType', function(ProgrammeType) {
                var vm = this;
                vm.programmeTypes = [];
                ProgrammeType.query().then(function(response) {
                    vm.programmeTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving ProgrammeTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/programmeType/programme-type.selection.html',
        };
    }

})();

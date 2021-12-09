(function() {

    angular
        .module('SelectionBoxes')
        .directive('schoolTypeSelection', SchoolTypeSelectionDirective);

    SchoolTypeSelectionDirective.$inject = ['SchoolType'];

    function SchoolTypeSelectionDirective(SchoolType) {
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
            controller: ['SchoolType', function(SchoolType) {
                var vm = this;
                vm.schoolTypes = [];
                SchoolType.query().then(function(response) {
                    vm.schoolTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving SchoolTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/schoolType/school-type.selection.html',
        };
    }

})();

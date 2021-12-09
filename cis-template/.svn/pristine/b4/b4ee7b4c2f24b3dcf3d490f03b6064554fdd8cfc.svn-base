(function() {

    angular
        .module('SelectionBoxes')
        .directive('schoolSelection', SchoolSelectionDirective);

    SchoolSelectionDirective.$inject = ['School'];

    function SchoolSelectionDirective(School) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '=',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['School', function(School) {
                var vm = this;
                vm.schools = [];
                School.query().then(function(response) {
                    vm.schools = response.data;
                }, function(err) {
                    alert("Error Retrieving Schools");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/school/school.selection.html',
        };
    }

})();

/**
 * This directive is used to create a selection box of the staff.
 *
 * @type Directive
 * @example <staff-selection ng-model="ctrl.staffId"></staff-selection>
 */
(function() {
    angular
        .module('SelectionBoxes')
        .directive('staffSelection', staffSelectionDirective);

    staffSelectionDirective.$inject = ['Staff'];

    function staffSelectionDirective(Staff) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngRequired: '=',
                ngmodelvar: '=ngModel',
                includeBlank: '=?'
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['$scope', 'Staff', function($scope, Staff) {
                var vm = this;
                this.staff = [];

                Staff.query().then(function(response) {
                    vm.staff = response.data;
                }, function(response) {
                    bootbox.alert("Failed to load staff list");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/staff/staff.selection.html'
        };
    }
})();

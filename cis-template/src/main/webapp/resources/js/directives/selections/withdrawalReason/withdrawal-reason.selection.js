(function() {

    angular
        .module('SelectionBoxes')
        .directive('withdrawalReasonSelection', WithdrawalReasonSelectionDirective);

    WithdrawalReasonSelectionDirective.$inject = ['WithdrawalReason'];

    function WithdrawalReasonSelectionDirective(WithdrawalReason) {
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
            controller: ['WithdrawalReason', function(WithdrawalReason) {
                var vm = this;
                vm.withdrawalReasons = [];
                WithdrawalReason.query().then(function(response) {
                    vm.withdrawalReasons = response.data;
                }, function(err) {
                    alert("Error Retrieving WithdrawalReasons");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/withdrawalReason/withdrawal-reason.selection.html',
        };
    }

})();

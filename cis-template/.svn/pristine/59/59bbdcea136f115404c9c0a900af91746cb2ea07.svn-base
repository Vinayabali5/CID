angular.module('Lookups').directive('withdrawalReasonLookup', function(WithdrawalReason) {
    return {
        restrict: 'E',
        scope: {
            withdrawalReasonId: '=',
        },
        link: function(scope, element) {
            if (scope.withdrawalReasonId !== undefined) {
                WithdrawalReason.get(scope.withdrawalReasonId).then(function(response) {
                    scope.withdrawalReason = response.data.description;
                }, function(response) {
                    scope.withdrawalReason = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/withdrawalReason/withdrawal-reason.lookup.html',
    };
});

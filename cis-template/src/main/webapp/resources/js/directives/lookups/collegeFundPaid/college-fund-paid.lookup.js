angular.module('Lookups').directive('collegeFundPaidLookup', function(CollegeFundPaid) {
    return {
        restrict: 'E',
        scope: {
            collegeFundPaidId: '=',
        },
        link: function(scope, element) {
            if (scope.collegeFundPaidId !== undefined) {
                CollegeFundPaid.get(scope.collegeFundPaidId).then(function(response) {
                    scope.collegeFundPaid = response.data.collegeFundPaid;
                }, function(response) {
                    scope.collegeFundPaid = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/collegeFundPaid/college-fund-paid.lookup.html',
    };
});

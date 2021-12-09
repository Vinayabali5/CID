angular.module('Lookups').directive('fundingModelLookup', function(FundingModel) {
    return {
        restrict: 'E',
        scope: {
            fundingModelId: '=',
        },
        link: function(scope, element) {
            if (scope.fundingModelId !== undefined) {
                FundingModel.get(scope.fundingModelId).then(function(response) {
                    scope.fundingModel = response.data.description;
                }, function(response) {
                    scope.fundingModel = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/fundingModel/funding-model.lookup.html',
    };
});

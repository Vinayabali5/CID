angular.module('Lookups').directive('offerTypeLookup', function(OfferType) {
    return {
        restrict: 'E',
        scope: {
            offerTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.offerTypeId !== undefined) {
                OfferType.get(scope.offerTypeId).then(function(response) {
                    scope.offerType = response.data.description;
                }, function(response) {
                    scope.offerType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/offerType/offer-type.lookup.html',
    };
});

angular.module('Lookups').directive('correspondenceTypeLookup', function(CorrespondenceType) {
    return {
        restrict: 'E',
        scope: {
            correspondenceTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.correspondenceTypeId !== undefined) {
                CorrespondenceType.get(scope.correspondenceTypeId).then(function(response) {
                    scope.correspondenceType = response.data.type;
                }, function(response) {
                    scope.correspondenceType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/correspondenceType/correspondence-type.lookup.html',
    };
});

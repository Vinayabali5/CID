angular.module('Lookups').directive('letterTypeLookup', function(LetterType) {
    return {
        restrict: 'E',
        scope: {
            letterTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.letterTypeId !== undefined) {
                LetterType.get(scope.letterTypeId).then(function(response) {
                    scope.letterType = response.data.type;
                }, function(response) {
                    scope.letterType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/letterType/letter-type.lookup.html',
    };
});

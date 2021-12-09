angular.module('Lookups').directive('completionStatusLookup', function(CompletionStatus) {
    return {
        restrict: 'E',
        scope: {
            completionStatusId: '=',
        },
        link: function(scope, element) {
            if (scope.completionStatusId !== undefined) {
                CompletionStatus.get(scope.completionStatusId).then(function(response) {
                    scope.completionStatus = response.data.description;
                }, function(response) {
                    scope.completionStatus = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/completionStatus/completion-status.lookup.html',
    };
});

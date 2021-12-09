angular.module('Lookups').directive('titleLookup', function(Title) {
    return {
        restrict: 'E',
        scope: {
            titleId: '=',
        },
        link: function(scope, element) {
            if (scope.titleId !== undefined) {
                Title.get(scope.titleId).then(function(response) {
                    scope.title = response.data.description;
                }, function(response) {
                    scope.title = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/title/title.lookup.html',
    };
});

angular.module('Lookups').directive('applicationStatusLookup', function(ApplicationStatus) {
    return {
        restrict: 'E',
        scope: {
            applicationStatusId: '=',
        },
        link: function(scope, element) {
            if (scope.applicationStatusId !== undefined) {
                ApplicationStatus.get(scope.applicationStatusId).then(function(response) {
                    scope.applicationStatus = response.data.description;
                }, function(response) {
                    scope.applicationStatus = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/applicationStatus/application-status.lookup.html',
    };
});

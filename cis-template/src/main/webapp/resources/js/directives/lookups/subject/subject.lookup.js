angular.module('Lookups').directive('subjectLookup', function(Subject) {
    return {
        restrict: 'E',
        scope: {
            subjectId: '=',
        },
        link: function(scope, element) {
            if (scope.subjectId !== undefined) {
                Subject.get(scope.subjectId).then(function(response) {
                    scope.subject = response.data.description;
                }, function(response) {
                    scope.subject = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/subject/subject.lookup.html',
    };
});

angular.module('Lookups').directive('examSessionLookup', function(ExamSession) {
    return {
        restrict: 'E',
        scope: {
            examSessionId: '=',
        },
        link: function(scope, element) {
            if (scope.examSessionId !== undefined) {
                ExamSession.get(scope.examSessionId).then(function(response) {
                    scope.examSession = response.data.description;
                }, function(response) {
                    scope.examSession = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/examSession/examSession.lookup.html',
    };
});

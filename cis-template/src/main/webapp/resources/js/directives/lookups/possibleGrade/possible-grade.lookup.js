angular.module('Lookups').directive('possibleGradeLookup', function(PossibleGrade) {
    return {
        restrict: 'E',
        scope: {
            possibleGradeId: '=',
        },
        link: function(scope, element) {
            if (scope.possibleGradeId !== undefined) {
                PossibleGrade.get(scope.possibleGradeId).then(function(response) {
                    scope.possibleGrade = response.data.description;
                }, function(response) {
                    scope.possibleGrade = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/possibleGrade/possible-grade.lookup.html',
    };
});

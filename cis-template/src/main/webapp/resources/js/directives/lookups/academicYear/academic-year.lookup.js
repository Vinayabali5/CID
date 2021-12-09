angular.module('Lookups').directive('academicYearLookup', function(AcademicYear) {
    return {
        restrict: 'E',
        scope: {
            academicYearId: '=',
        },
        link: function(scope, element) {
            if (scope.academicYearId !== undefined) {
                AcademicYear.get(scope.academicYearId).then(function(response) {
                    scope.academicYear = response.data.description;
                }, function(response) {
                    scope.academicYear = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/academicYear/academic-year.lookup.html',
    };
});

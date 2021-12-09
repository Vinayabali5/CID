(function() {
    angular
        .module('cid.lookup.course-spec-validity', [])
        .directive('courseSpecValidityLookup', CourseSpecValidityLookup);

    CourseSpecValidityLookup.$inject = ['CourseSpec'];

    function CourseSpecValidityLookup(CourseSpec) {
        return {
            restrict: 'E',
            scope: {
                class: '@',
                spec: '=',
            },
            link: function(scope, element) {
                var valid = function(spec) {
                    CourseSpec.valid(scope.spec).then(function(response) {
                        scope.valid = response.data.valid;
                    }, function(response) {
                        scope.valid = false;
                        element.addClass('error');
                    });
                };

                if (scope.spec !== undefined) {
                    valid(scope.spec);
                }
                scope.$watch('spec', function(newValue, oldValue) {
                    valid(scope.spec);
                });
            },
            templateUrl: 'js/directives/lookups/course-spec-validity/course-spec-validity.lookup.html',
        };
    }

})();

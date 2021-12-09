(function() {
    angular
        .module('cid.lookup.course-spec', ['CourseSpecService'])
        .directive('courseSpecLookup', CourseSpecLookup);

    CourseSpecLookup.$inject = ['CourseSpec'];

    function CourseSpecLookup(CourseSpec) {
        return {
            restrict: 'E',
            scope: {
                class: '@',
                spec: '=',
            },
            link: function(scope, element) {
                var lookup = function(spec) {
                    CourseSpec.lookup(scope.spec).then(function(response) {
                        scope.description = response.data.description;
                    }, function(response) {
                        scope.description = "**ERROR**";
                        element.addClass('error');
                    });
                };

                if (scope.spec !== undefined) {
                    lookup(scope.spec);
                }
                scope.$watch('spec', function(newValue, oldValue) {
                    lookup(scope.spec);
                });
            },
            template: '{{ description }}',
        };
    }

})();

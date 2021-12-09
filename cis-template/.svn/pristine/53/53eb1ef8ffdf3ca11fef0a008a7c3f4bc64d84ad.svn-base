angular.module('Lookups').directive('tutorGroupLookup', function(TutorGroup) {
    return {
        restrict: 'E',
        scope: {
            tutorGroupId: '=',
        },
        link: function(scope, element) {
            if (scope.tutorGroupId !== undefined) {
                TutorGroup.get(scope.tutorGroupId).then(function(response) {
                    scope.tutorGroup = response.data.description;
                }, function(response) {
                    scope.tutorGroup = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/tutorGroup/tutor-group.lookup.html',
    };
});

angular.module('Lookups').directive('entryQualificationLookup', function(EntryQualification) {
    return {
        restrict: 'E',
        scope: {
            entryQualificationId: '=',
        },
        link: function(scope, element) {
            if (scope.entryQualificationId !== undefined) {
                EntryQualification.get(scope.entryQualificationId).then(function(response) {
                    scope.entryQualification = response.data.title;
                }, function(response) {
                    scope.entryQualification = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/entryQualification/entry-qualification.lookup.html',
    };
});

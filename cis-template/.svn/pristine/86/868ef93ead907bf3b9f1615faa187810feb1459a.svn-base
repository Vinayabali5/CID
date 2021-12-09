angular.module('Lookups').directive('entryQualificationTypeLookup', function(EntryQualificationType) {
    return {
        restrict: 'E',
        scope: {
            entryQualificationTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.entryQualificationTypeId !== undefined) {
                EntryQualificationType.get(scope.entryQualificationTypeId).then(function(response) {
                    scope.entryQualificationType = response.data.description;
                }, function(response) {
                    scope.entryQualificationType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/entryQualificationType/entry-qualification-type.lookup.html',
    };
});

angular.module('Lookups').directive('programmeTypeLookup', function(ProgrammeType) {
    return {
        restrict: 'E',
        scope: {
            programmeTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.programmeTypeId !== undefined) {
                ProgrammeType.get(scope.programmeTypeId).then(function(response) {
                    scope.programmeType = response.data.description;
                }, function(response) {
                    scope.programmeType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/programmeType/programme-type.lookup.html',
    };
});

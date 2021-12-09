angular.module('Lookups').directive('noteTypeLookup', function(NoteType) {
    return {
        restrict: 'E',
        scope: {
            noteTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.noteTypeId !== undefined) {
                NoteType.get(scope.noteTypeId).then(function(response) {
                    scope.noteType = response.data.description;
                }, function(response) {
                    scope.noteType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/noteType/note-type.lookup.html',
    };
});

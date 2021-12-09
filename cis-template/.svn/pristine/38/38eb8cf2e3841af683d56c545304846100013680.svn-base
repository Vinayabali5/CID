angular.module('Lookups').directive('roomLookup', function(Room) {
    return {
        restrict: 'E',
        scope: {
            roomId: '=',
        },
        link: function(scope, element) {
            if (scope.roomId !== undefined) {
                Room.get(scope.roomId).then(function(response) {
                    scope.room = response.data.description;
                }, function(response) {
                    scope.room = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/room/room.lookup.html',
    };
});

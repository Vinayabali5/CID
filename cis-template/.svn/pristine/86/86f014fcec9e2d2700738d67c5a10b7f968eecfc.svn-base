(function() {

    angular
        .module('SelectionBoxes')
        .directive('roomSelection', RoomSelectionDirective);

    RoomSelectionDirective.$inject = ['Room'];

    function RoomSelectionDirective(Room) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['Room', function(Room) {
                var vm = this;
                vm.rooms = [];
                Room.query().then(function(response) {
                    vm.rooms = response.data;
                }, function(err) {
                    alert("Error Retrieving Rooms");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/room/room.selection.html',
        };
    }

})();

(function() {

    angular
        .module('SelectionBoxes')
        .directive('roomTypeSelection', RoomTypeSelectionDirective);

    RoomTypeSelectionDirective.$inject = ['RoomType'];

    function RoomTypeSelectionDirective(RoomType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '='
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['RoomType', function(RoomType) {
                var vm = this;
                vm.roomTypes = [];
                RoomType.query().then(function(response) {
                    vm.roomTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving RoomTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/roomType/roomType.selection.html',
        };
    }

})();

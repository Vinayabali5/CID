(function() {

    angular
        .module('SelectionBoxes')
        .directive('careersRecordTypeSelection', CareersRecordTypeSelectionDirective);

    CareersRecordTypeSelectionDirective.$inject = ['CareersRecordType'];

    function CareersRecordTypeSelectionDirective(CareersRecordType) {
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
            controller: ['CareersRecordType', function(CareersRecordType) {
                var vm = this;
                vm.careersRecordTypes = [];
                CareersRecordType.query().then(function(response) {
                    vm.careersRecordTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving CareersRecordTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/careers-record-type/careers-record-type.selection.html',
        };
    }

})();

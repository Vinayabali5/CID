angular.module('SelectionBoxes').directive('ilpInterviewTypeSelection', ['ILPInterviewType', function(ILPInterviewType) {
    return {
        restrict: 'E',
        scope: {
            id: '@',
            class: '@',
            readonly: '=?',
            ngmodelvar: '=ngModel',
            ngChange: '&',
            ngRequired: '=',
            altNullText: '=altNullText'
        },
        link: function(scope, element, attrs) {
            element[0].removeAttribute('id');
            element[0].removeAttribute('class');
            element[0].removeAttribute('readonly');
            element[0].disable = scope.readonly;
        },
        controller: ['ILPInterviewType', function(ILPInterviewType) {
            var vm = this;
            vm.iLPInterviewTypes = [];

            ILPInterviewType.query().then(function(response) {
                vm.iLPInterviewTypes = response.data;
            }, function(response) {
                alert("Error Retrieving ILPInterviewTypes");
            });
        }],
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/selections/ilp-interview-type/ilp-interview-type.selection.html',
    };
}]);

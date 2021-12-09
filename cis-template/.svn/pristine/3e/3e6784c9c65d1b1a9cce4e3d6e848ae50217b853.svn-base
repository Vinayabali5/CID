(function() {

    angular
        .module('SelectionBoxes')
        .directive('referralReasonSelection', ReferralReasonSelectionDirective);

    ReferralReasonSelectionDirective.$inject = ['ReferralReason'];

    function ReferralReasonSelectionDirective(ReferralReason) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
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
            controller: ['ReferralReason', function(ReferralReason) {
                var vm = this;
                this.referralReasons = [];
                this.init = function() {
                    ReferralReason.query().then(function(response) {
                        vm.referralReasons = response.data;
                    }, function(err) {
                        alert("Error Retrieving ReferralReasons");
                    });
                };

                this.init();
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/referral-reason/referral-reason.selection.html',
        };
    }

})();

/**
 * This is the Year Group Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ReferralReasonsEditorDirective')
        .controller('ReferralReasonsEditorDialogController', ReferralReasonsEditorDialogController);

    ReferralReasonsEditorDialogController.$inject = ['$log', '$scope', '$state',
        '$rootScope', '$uibModalInstance', 'ReferralReason', 'referralReasonsEntity'
    ];

    function ReferralReasonsEditorDialogController($log, $scope, $state, $rootScope,
        $uibModalInstance, ReferralReason, referralReasonsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.referralReasons = referralReasonsEntity !== undefined ? referralReasonsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('referralReasons-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.referralReasons.id !== null) {
                ReferralReason.create(vm.referralReasons, onSaveFinished);
            }
        }

        function save() {
            if (vm.referralReasons.id) {
                ReferralReason.save(vm.referralReasons, onSaveFinished);
            }
        }

    }

})();

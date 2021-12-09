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
        .module('ConcessionTypesEditorDirective')
        .controller('ConcessionTypesEditorDialogController', ConcessionTypesEditorDialogController);

    ConcessionTypesEditorDialogController.$inject = ['$log', '$scope', '$state',
        '$rootScope', '$uibModalInstance', 'ConcessionType', 'concessionTypesEntity'
    ];

    function ConcessionTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, ConcessionType, concessionTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.concessionTypes = concessionTypesEntity !== undefined ? concessionTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('concessionTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.concessionTypes.id !== null) {
                ConcessionType.create(vm.concessionTypes, onSaveFinished);
            }
        }

        function save() {
            if (vm.concessionTypes.id) {
                ConcessionType.save(vm.concessionTypes, onSaveFinished);
            }
        }

    }

})();

/**
 * This is the Year Group Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular.module('YearGroupsEditorDirective')
        .controller('YearGroupsEditorDialogController', YearGroupsEditorDialogController);

    YearGroupsEditorDialogController.$inject = ['$log', '$scope', '$state',
        '$rootScope', '$uibModalInstance', 'YearGroup', 'yearGroupsEntity'
    ];

    function YearGroupsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, YearGroup, yearGroupsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.yearGroups = yearGroupsEntity !== undefined ? yearGroupsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('yearGroups-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.yearGroups.id) {
                YearGroup.save(vm.yearGroups, onSaveFinished);
            } else {
                if (vm.yearGroups.id !== null) {
                    YearGroup.create(vm.yearGroups, onSaveFinished);
                }
            }
        }

    }

})();

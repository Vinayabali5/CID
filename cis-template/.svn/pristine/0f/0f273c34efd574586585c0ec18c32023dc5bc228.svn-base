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
        .module('ReportingPeriodsEditorDirective')
        .controller('ReportingPeriodsEditorDialogController', ReportingPeriodsEditorDialogController);

    ReportingPeriodsEditorDialogController.$inject = ['$log', '$scope', '$state',
        '$rootScope', '$uibModalInstance', 'ReportingPeriod', 'reportingPeriodsEntity'
    ];

    function ReportingPeriodsEditorDialogController($log, $scope, $state, $rootScope,
        $uibModalInstance, ReportingPeriod, reportingPeriodsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.reportingPeriods = reportingPeriodsEntity !== undefined ? reportingPeriodsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('reportingPeriods-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.reportingPeriods.id) {
                ReportingPeriod.save(vm.reportingPeriods, onSaveFinished);
            } else {
                if (vm.reportingPeriods.id !== null) {
                    ReportingPeriod.create(vm.reportingPeriods, onSaveFinished);
                }
            }
        }

    }

})();

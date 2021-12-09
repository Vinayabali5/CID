(function() {
    'use strict';

    angular
        .module('bulk-careers-record')
        .controller('BulkCareersRecordDirectiveController', BulkCareersRecordDirectiveController);

    BulkCareersRecordDirectiveController.$inject = ['Logger', '$scope', '$uibModalInstance', '$cidConfig', 'Enrolments', 'BulkCareersRecords', 'BulkCareersRecord'];

    function BulkCareersRecordDirectiveController(Logger, $scope, $uibModalInstance, $cidConfig, Enrolments, BulkCareersRecords, BulkCareersRecord) {
        /* jshint validthis:true */
        var vm = this;

        $scope.tinymceOptions = $cidConfig.tinymceOptions;

        $scope.studentCareersRecord = BulkCareersRecords.data !== undefined ? BulkCareersRecords.data : null;
        $scope.studentList = Enrolments.data !== undefined ? Enrolments.data : null;

        vm.create = create;
        vm.cancel = cancel;

        /**
         * This creates the bulk careers records and closes that dialog box
         */
        function create() {
            Logger.log('bulk careers record DirectiveController::save called');
            if ($scope.studentCareersRecord) {
                BulkCareersRecord.create($scope.studentCareersRecord, closeDialog);
            }
        }

        /**
         * This closes the bulk careers record dialog box without saving
         */
        function cancel() {
            Logger.log('BulkCareersRecordDirectiveController::cancel called');
            $uibModalInstance.dismiss('cancel');
        }
        /**
         * This is used to close the dialog box once the save is clicked.
         */
        function closeDialog() {
            $uibModalInstance.close();
        }

    }

}());

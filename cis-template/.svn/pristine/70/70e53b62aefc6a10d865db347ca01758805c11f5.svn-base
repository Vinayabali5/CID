/**
 * This is the Student files uploader Dialog Controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('StudentFilesUploaderDirective')
        .controller('StudentFilesUploaderDialogController', StudentFilesUploaderDialogController);

    StudentFilesUploaderDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', 'Upload', 'GLOBAL', '$uibModal', '$rootScope', 'studentFilesEntity', 'Notification'];

    function StudentFilesUploaderDialogController($log, $scope, $state, $uibModalInstance, Upload, GLOBAL, $uibModal, $rootScope, studentFilesEntity, Notification) {
        /* jshint validthis:true */
        var vm = this;

        $scope.studentFiles = studentFilesEntity !== undefined ? studentFilesEntity : {};
        $scope.save = save;
        $scope.cancel = cancel;

        /**
         * This method is used to upload the student files by posting the required data to the API
         */
        function getUploadUrl() {
            return GLOBAL.API + '/student-files/upload';
        }

        /**
         * This method is used to save and upload the student files
         */
        function save() {
            $log.log('StudentFilesDialogController::save called');
            $log.info($scope.studentFiles);
            if ($scope.studentFiles) {
                Upload.upload({
                    url: getUploadUrl(),
                    data: {
                        file: $scope.studentFiles.file,
                        studentId: $scope.studentFiles.studentId,
                        fileCategoryId: $scope.studentFiles.fileCategoryId
                    }
                }).then(function(resp) {
                    console.log('Success: ' + resp.config.data.file.name + ' : uploaded.');
                    Notification.success("Message: Student Files Uploaded Successfully.");
                    $uibModalInstance.dismiss('cancel');
                    $rootScope.$emit("student-file.saved");
                }, function(resp) {
                    console.log('Error status: ' + resp.status);
                }, function(evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
                });
            }
        }


        /**
         * This closes the studentFiles editor dialog box without saving 
         */
        function cancel() {
            $log.log('StudentFilesDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();

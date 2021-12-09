/**
 * This is the Student Files Uploader Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('StudentFilesUploaderDirective')
        .controller('StudentFilesUploaderController', StudentFilesUploaderController);

    StudentFilesUploaderController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'StudentFile'];

    function StudentFilesUploaderController($log, $scope, $rootScope, $uibModal, StudentFile) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.uploadStudentFilesUploader = uploadStudentFilesUploader;

        /*
         * This method is used to open the dialog box with a drop down list of categories and place to select file from the computer.
         */
        function uploadStudentFilesUploader(studentId) {
            $log.log('StudentFilesDirectiveController::editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-files-uploader/views/student-files-uploaderDialog.html',
                controller: 'StudentFilesUploaderDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentFilesEntity: function() {
                        var studentFiles = {};
                        studentFiles.studentId = studentId;
                        return studentFiles;
                    }
                }
            });
        }

    }

})();

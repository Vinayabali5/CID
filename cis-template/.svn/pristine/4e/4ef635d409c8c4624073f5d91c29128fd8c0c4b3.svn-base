/**
 *
 */
(function() {
    angular
        .module('cid.exams.import-base-data')
        .controller('ExamImportBaseDataController', ExamImportBaseDataController);

    ExamImportBaseDataController.$inject = ['$scope', 'Upload', 'GLOBAL'];

    function ExamImportBaseDataController($scope, Upload, GLOBAL) {
        console.log('ExamImportBaseDataController loaded');

        // Public Interface
        $scope.uploadFiles = uploadFiles;

        // Private Interface

        function getUploadUrl() {
            return GLOBAL.API + '/upload/basedata';
        }

        function uploadFiles(files) {
            if (files && files.length) {
                Upload.upload({
                    url: getUploadUrl(),
                    data: {
                        file: files
                    }
                }).then(function(resp) {
                    console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
                }, function(resp) {
                    console.log('Error status: ' + resp.status);
                }, function(evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
                });
            }
        }

    }
})();

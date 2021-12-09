angular
    .module('cid.tests')
    .controller('TestStudentFileController', function($log, $scope, Upload, GLOBAL, StudentFile) {
        var vm = this;

        // Public Interface
        $scope.uploadStudentFiles = uploadStudentFiles;

        this.studentFiles = [];

        this.studentId = 210001;

        function getUploadUrl() {
            return GLOBAL.API + '/student-files/upload';
        }

        function uploadStudentFiles(files) {
            if (files) {
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

        this.init = function() {
            $log.log('StudentFileController::loadStudent called');
            this.getStudent();
        };

        this.getStudent = function(id) {
            var lookupStudentId;
            if (id) {
                lookupStudentId = id;
            } else {
                lookupStudentId = this.studentId;
            }
            $log.log('Getting Student: ' + lookupStudentId);
            StudentFile.getByStudentId(this.studentId).then(function(response) {
                vm.studentFiles = response.data;

                $log.info(vm.studentFiles);
            });
        };

        this.init();
    });

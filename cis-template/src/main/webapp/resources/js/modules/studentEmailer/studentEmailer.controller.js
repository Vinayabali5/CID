/**
 * This is the main site navigation controller.
 *
 * Styles Applied: [Y001, Y002, Y010, Y021, Y023, Y024, Y031, Y032, Y033, Y034, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module("StudentEmailer")
        .controller("StudentEmailerController", StudentEmailerController);


    StudentEmailerController.$inject = ['$log', '$http', 'Student', 'StudentCourseSearch', 'currentStudentList'];

    function StudentEmailerController($log, $http, Student, StudentCourseSearch, currentStudentList) {
        var vm = this;

        this.filters = {
            courseGroupMask: '%',
            studentTypeMask: '%',
            tutorGroupMask: '%',
            includeWithdrawn: false
        };

        this.editorOptions = {

        };

        this.studentList = currentStudentList.data;

        this.selected = [];

        this.includeStudents = true;
        this.includeParents = true;

        this.emailSubject = "Default Subject";
        this.emailMessage = null;

        this.init = function() {
            $log.info("II Initialising the Student Emailer");
        };

        this.init();

        this.sendEmail = function() {
            if (this.selected.length !== 0 && this.emailMessage !== null) {
                bootbox.confirm("You are about to send an email to " + this.selected.length + " students and their parents. Are you sure?", function(result) {
                    $log.info(result);
                    if (result) {
                        var email = {
                            studentIds: vm.selected,
                            includeStudents: vm.includeStudents,
                            includeParents: vm.includeParents,
                            emailSubject: vm.emailSubject,
                            emailMessage: vm.emailMessage
                        };
                        $log.info(email);
                        $http.post('http://localhost:9999/email/bulk', email).then(function(response) {
                            $log.info(response);
                        });
                    } else {

                    }
                });
            } else {
                var errorMessage = "";
                if (this.selected.length === 0) errorMessage += 'No students selected! <br/>';
                if (this.emailSubject === null) errorMessage += 'No subject entered! <br/>';
                if (this.emailMessage === null) errorMessage += 'No message entered! <br/>';
                bootbox.alert(errorMessage);
            }
        };

        this.applyFilter = function() {
            StudentCourseSearch.search(vm.filters).then(function(response) {
                $log.info(response);
                vm.studentList = response.data;
            });
        };

    }

})();

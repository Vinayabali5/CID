(function() {
    angular
        .module('ExamCourseTableDirective')
        .controller('ExamCourseTableDirectiveController', examCourseTableDirectiveController);

    examCourseTableDirectiveController.$inject = ["$uibModal", "$uibModalInstance", "$state", "$scope", "entity", "Course", "StudentOptionEntry"];

    function examCourseTableDirectiveController($uibModal, $uibModalInstance, $state, $scope, entity, Course, StudentOptionEntry) {
        var vm = this;

        $scope.cancel = cancel;
        $scope.groups = {
            groupList: [],
        };
        $scope.save = save;

        ////////////////////////////

        console.log('SeatingPlanCustomExamStudentsComponentController Loaded');
        init();

        function cancel() {
            $uibModalinstance.dismiss();
        }

        /**
         * This function initialises the settings for the window
         * 
         * course group and students list require a numbered array, called $scope.groups.groupList
         * For fast processing, and quick tracking of previously encountered course groups, we will use an
         * associative array, groupIndex, which links course group reference to the appropriate 
         * $scope.groups.groupList element number
         */
        function init() {
            Course.enrolments(entity.customExam.courseId).then(function(response) {
                groupIndex = [];

                for (var index in response.data) {
                    student = response.data[index];
                    if (student._completionStatus.id === 1) { // Only want to include current students.
                        // Check if course group array element has been created
                        if (groupIndex[student._courseGroupReference] === undefined) {
                            // Course group array element hasn't been created yet, so create it 
                            groupIndex[student._courseGroupReference] = $scope.groups.groupList.length;
                            // Populate details for course group array element
                            $scope.groups.groupList[groupIndex[student._courseGroupReference]] = {
                                courseGroupId: student.courseGroupId,
                                _courseGroupReference: student._courseGroupReference,
                                _levelDescription: student._levelDescription,
                                _subjectDescription: student._subjectDescription,
                                studentList: [{ // Create student array for course group, and add student.
                                    id: student.studentId,
                                }],
                            };
                        } else { // Course group array element already exists, so use it, and add student to student array 
                            $scope.groups.groupList[groupIndex[student._courseGroupReference]].studentList.push({
                                id: student.studentId,
                            });
                        }
                    }
                }
            }, function(response) {
                console.log("Error occurred loading course enrolments");
            });
        }

        /**
         * This function creates student option entry records for all the selected students
         */
        function save() {
            for (var groupIndex in $scope.groups.groupList) {
                for (var studentIndex in $scope.groups.groupList[groupIndex].studentList) {
                    // Student has been selected if any of Select All, Course group, or student itself has been selected. 
                    if ($scope.groups.groupList[groupIndex]._selected || $scope.groups.groupList[groupIndex].studentList[studentIndex]._selected) {
                        StudentOptionEntry.create({
                            studentId: $scope.groups.groupList[groupIndex].studentList[studentIndex].id,
                            examOptionId: entity.customExam.examOptionId,
                            statusId: 1,
                            ediStatusId: 8,
                            resit: 0,
                            private: 0
                        }).then(function(response) {}, function(response) {});
                    }
                }
            }

            $uibModalInstance.close();
        }
    }

})();

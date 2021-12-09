/**
 *
 */
angular
    .module('CourseEnrolmentTableDirective')
    .controller('CourseEnrolmentTableDirectiveController', ["$scope", "$http", "$uibModal", "Student",
        function($scope, $http, $uibModal, Student) {
            var vm = this;


            // //////////////////////////////////////////////////////////////

            console.log('CourseEnrolmentTableDirectiveController loaded');
            init();

            /**
             * This function is called when the directive is loaded
             */
            function init() {
                if ($scope.group.studentList[0].person === undefined) {
                    for (var i = 0; i < $scope.group.studentList.length; i++) {
                        populateStudent(i);
                    }
                }
            }

            /**
             * This function loads the details for the student, given the student number, and populates the
             * array element specified.
             */
            function populateStudent(i) {
                Student.get($scope.group.studentList[i].id).then(function(response) {
                    $scope.group.studentList[i] = response.data;
                });
            }
        }
    ]);

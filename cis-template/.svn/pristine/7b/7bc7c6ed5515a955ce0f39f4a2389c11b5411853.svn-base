/**
 * This is the Course Exam Details List Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('cid.exams.course-exam-details')
        .controller('CourseExamDetailsListController', CourseExamDetailsListController);

    CourseExamDetailsListController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Course', 'courseList'];

    function CourseExamDetailsListController($log, $scope, $state, $rootScope, $uibModal, Course, courseList) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.courses = courseList != null ? courseList.data : [];
        vm.applyFilter = applyFilter;
        vm.editExamDetails = editExamDetails;

        // Private Interface
        //Event handlers to loadCourses if current-year-changes
        $rootScope.$on("current-year-changed", function(data) {
            loadCourses();
        });

        //event handler to loadCourses list after course edit.
        $rootScope.$on("course-saved", function(data) {
            loadCourses();
        });

        /**
         * This method is used to load the Course List
         */
        function loadCourses() {
            Course.query().then(function(response) {
                vm.courses = response.data;
                applyFilter();
            }, function(response) {
                $log.error('EE Failed to retrieve courses from API');
            });
        }
        /**
         * This function is used to filter the course list
         */
        function applyFilter() {
            $scope.filterParams = {
                spec: $scope.filter.courseSpec,
                _levelDescription: $scope.filter.level,
                _subjectDescription: $scope.filter.subject,
                _examBoardDescription: $scope.filter.examBoard,
                syllabusCode: '!' + $scope.filter.exclude.syllabusCode,
                learningAimReference: '!' + $scope.filter.exclude.learningAimReference
            };
        }
        $scope.filter = {
            courseSpec: '',
            level: '',
            subject: '',
            examBoard: '',
            exclude: {
                syllabusCode: 'NA',
                learningAimReference: 'CMISC001'
            }
        };

        /**
         * This method is used to edit the course details
         */
        function editExamDetails(courseId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/course-exam-details/views/course-exam-detail-edit.html',
                controller: 'CourseExamDetailsEditorController',
                controllerAs: 'ctrl',
                size: 'xl',
                resolve: {
                    courseExamDetailsEntity: function(Course) {
                        return Course.get(courseId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }
                }
            });
        }

    }
}());

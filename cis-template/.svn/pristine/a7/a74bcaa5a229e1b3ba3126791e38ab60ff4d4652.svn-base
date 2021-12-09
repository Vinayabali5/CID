/**
 * This is the Course Record Viewer Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {

    'use strict';

    angular
        .module('cid.course-record-viewer')
        .controller('CourseRecordViewerController', courseRecordViewerController);

    courseRecordViewerController.$inject = ['$log', '$scope', '$rootScope', '$state', '$stateParams', 'courseEntity', 'courseGroupList', 'enrolmentList', 'Course', 'GLOBAL'];

    function courseRecordViewerController($log, $scope, $rootScope, $state, $stateParams, courseEntity, courseGroupList, enrolmentList, Course, GLOBAL) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        $scope.course = courseEntity ? courseEntity.data : undefined;
        $scope.courseGroups = courseGroupList ? courseGroupList.data : [];
        $scope.enrolments = enrolmentList ? enrolmentList.data : [];

        // Event Handlers

        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            loadCourseGroups($scope.course.id);
            loadEnrolments($scope.course.id);
        }));

        // Private Interface

        function loadCourse(id) {
            $log.log('CourseRecordViewerController :: loadCourse called');
            Course.get(id).then(function(response) {
                $log.log('II - Course with ID: ' + id + ' retireved.');
                $scope.course = response.data;
                loadCourseGroups(id);
                loadEnrolments(id);
            }, function(response) {
                $log.log('EE - An error occurred trying to retireve the course with ID: ' + id);
                alert("Failed to retrieve course with ID: " + id);
            });

        }

        function loadCourseGroups(id) {
            Course.courseGroups(id).then(function(response) {
                $scope.courseGroups = response.data;
            });
        }

        function loadEnrolments(id) {
            Course.enrolments(id).then(function(response) {
                $scope.enrolments = response.data;
            });
        }

    }

})();

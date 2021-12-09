/**
 * This is the Course Record Viewer Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {

    'use strict';

    angular.module('cid.course-record-viewer')
        .controller('CourseGroupViewerController', CourseGroupViewerController);


    CourseGroupViewerController.$inject = ['$log', '$scope', '$rootScope', '$state', '$stateParams', 'courseGroupEntity', 'enrolmentList', 'ilpInterviewList', 'CourseGroup', 'GLOBAL', 'APP'];


    function CourseGroupViewerController($log, $scope, $rootScope, $state, $stateParams, courseGroupEntity, enrolmentList, ilpInterviewList, CourseGroup, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        $scope.courseGroup = courseGroupEntity ? courseGroupEntity.data : undefined;
        $scope.enrolments = enrolmentList ? enrolmentList.data : [];
        $scope.ilpInterviews = ilpInterviewList ? ilpInterviewList.data : [];
        $scope.filter = {};

        $scope.loadEnrolmentsByYear = loadEnrolmentsByYear;
        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('mass-letter-saved', function(data) {
            CourseGroup.ilpInterviews($scope.courseGroup.id).then(function(response) {
                $scope.ilpInterviews = response.data;
            });
        }));
        $scope.$on('$destroy', $rootScope.$on('mass-ilp-interviews-saved', function(data) {
            CourseGroup.ilpInterviews($scope.courseGroup.id).then(function(response) {
                $scope.ilpInterviews = response.data;
            });
        }));
        $scope.$on('$destroy', $rootScope.$on('ilpInterview-saved', function(data) {
            CourseGroup.ilpInterviews($scope.courseGroup.id).then(function(response) {
                $scope.ilpInterviews = response.data;
            });
        }));

        // loads enrolments lists based on year change
        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            $scope.loadEnrolmentsByYear($scope.courseGroup.id, APP.getYear());
        }));

        function loadEnrolmentsByYear(id, year) {
            $log.log('CourseGroupViewerListController::loadCourseGroupEnrolmentsByYear called');
            CourseGroup.enrolments(id, year).then(function(response) {
                $log.info('II Successfully retrieved CourseGroupsByYear');
                $scope.enrolments = response.data;
            }, function(response) {
                $log.error('EE Error retrieving CourseGroups');
            });
        }
        $scope.toggleStudentTargets = function() {
            if ($scope.showStudentTargets == true) {
                $scope.filter = {};
                $scope.showStudentTargets = false;
            } else {
                $scope.filter.interviewType = {
                    type: "!Student Target"
                };
                $scope.showStudentTargets = true;
            }
        };
    }

})();

/**
 * This file defines the route configuration for the course exam details section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.exams.course-exam-details')
        .config(ExamsCourseDetailsRouteConfiguration);

    ExamsCourseDetailsRouteConfiguration.$inject = ["$stateProvider"];

    function ExamsCourseDetailsRouteConfiguration($stateProvider) {
        $stateProvider
            .state('exams.course-details', {
                url: '/courses',
                data: {
                    roles: ['ROLE_Admin', 'ROLE_Exams Officer'],
                },
                resolve: {
                    courseList: ['Course', function(Course) {
                        return Course.query();
                    }]
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/exams/course-exam-details/views/course-list.html',
                        controller: 'CourseExamDetailsListController',
                        controllerAs: 'ctrl'
                    },
                },
            });

    }

})();

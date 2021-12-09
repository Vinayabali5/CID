(function() {
    'use strict';

    angular
        .module('cid.course-record-viewer')
        .config(courseRecordCourseRoutes);

    courseRecordCourseRoutes.$inject = ['$stateProvider'];

    function courseRecordCourseRoutes($stateProvider) {

        $stateProvider
            .state('course-record.course', {
                abstract: true,
                url: '/course'
            })
            .state('course-record.course.list', {
                url: '/list',
                views: {
                    "content.viewer@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/course-list.html',
                        controller: 'CourseListController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    courseList: ['Course', function(Course) {
                        return Course.query();
                    }]
                }
            })
            .state('course-record.course.view', {
                url: '/{courseId}',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content.viewer@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/course-viewer.html',
                        controller: 'CourseRecordViewerController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    courseEntity: ['$stateParams', 'Course', function($stateParams, Course) {
                        return Course.get($stateParams.courseId);
                    }],
                    courseGroupList: ['$stateParams', 'Course', function($stateParams, Course) {
                        return Course.courseGroups($stateParams.courseId);
                    }],
                    enrolmentList: ['$stateParams', 'Course', function($stateParams, Course) {
                        return Course.enrolments($stateParams.courseId);
                    }],
                },
            })


        ;
    }

})();

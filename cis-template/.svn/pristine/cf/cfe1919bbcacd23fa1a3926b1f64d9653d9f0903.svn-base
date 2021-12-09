(function() {
    'use strict';

    angular
        .module('cid.course-record-viewer')
        .config(courseRecordCourseGroupRoutes);

    courseRecordCourseGroupRoutes.$inject = ['$stateProvider'];

    function courseRecordCourseGroupRoutes($stateProvider) {

        $stateProvider
            .state('course-record.course-group', {
                //abstract: true,
                url: '/course-group',
            })
            .state('course-record.course-group.list', {
                url: '/list',
                views: {
                    "content.viewer@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/course-group-list.html',
                        controller: 'CourseGroupListController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    courseGroupList: ['CourseGroup', function(CourseGroup) {
                        return CourseGroup.query();
                    }]
                }
            })
            .state('course-record.course-group.view', {
                url: '/{courseGroupId}',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content.viewer@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/course-group-viewer.html',
                        controller: 'CourseGroupViewerController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    courseGroupEntity: ['$stateParams', 'CourseGroup', function($stateParams, CourseGroup) {
                        return CourseGroup.get($stateParams.courseGroupId);
                    }],
                    enrolmentList: ['$stateParams', 'CourseGroup', function($stateParams, CourseGroup) {
                        return CourseGroup.enrolments($stateParams.courseGroupId);
                    }],
                    ilpInterviewList: ['$stateParams', 'CourseGroup', function($stateParams, CourseGroup) {
                        return CourseGroup.ilpInterviews($stateParams.courseGroupId);
                    }],
                },
            })


        ;
    }

})();

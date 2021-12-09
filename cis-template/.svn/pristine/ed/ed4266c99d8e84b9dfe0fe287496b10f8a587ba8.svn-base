(function() {
    'use strict';

    angular
        .module('cid.course-record-viewer')
        .config(courseViewerRouteConfiguration);

    courseViewerRouteConfiguration.$inject = ['$stateProvider'];

    function courseViewerRouteConfiguration($stateProvider) {

        $stateProvider
            .state('course-record', {
                parent: 'site',
                url: '/course-record',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "side-bar@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/side-bar.html'
                    },
                    "content@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/layout.html',
                    },
                    "content.search@": {
                        templateUrl: 'js/modules/courseRecordViewer/views/search.html',
                        controller: 'CourseViewerSearchController',
                        controllerAs: 'ctrl'
                    },
                },
            })



        ;
    }

})();

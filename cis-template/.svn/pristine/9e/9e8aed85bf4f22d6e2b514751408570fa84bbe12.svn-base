(function() {
    'use strict';

    angular
        .module('StudentEmailer')
        .config(studentEmailerRouteConfiguration);

    studentEmailerRouteConfiguration.$inject = ['$stateProvider'];

    function studentEmailerRouteConfiguration($stateProvider) {

        $stateProvider
            .state('emailer', {
                parent: 'site',
                url: '/emailer',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/studentEmailer/views/emailer.html',
                        controller: 'StudentEmailerController',
                        controllerAs: 'ctrl',
                    },
                },
                resolve: {
                    currentStudentList: ['StudentCourseSearch', function(StudentCourseSearch) {
                        return StudentCourseSearch.query();
                    }]
                }
            });
    }
})();

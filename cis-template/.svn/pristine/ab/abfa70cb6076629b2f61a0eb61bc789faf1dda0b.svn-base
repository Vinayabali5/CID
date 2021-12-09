(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(coreDataRouteConfiguration);

    coreDataRouteConfiguration.$inject = ['$stateProvider'];

    function coreDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.core', {
                abstract: true,
                url: '/core',
                data: {
                    roles: ['ROLE_Core Data']
                },
            })
            .state({
                name: 'data.core.academic-years',
                url: '/academic-years',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/academic-years.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['AcademicYear', function(AcademicYear) {
                        return AcademicYear.query();
                    }]
                }

            })
            .state({
                name: 'data.core.holidays',
                url: '/holidays',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/holidays.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Holiday', function(Holiday) {
                        return Holiday.query();
                    }]
                }

            })
            .state({
                name: 'data.core.year-groups',
                url: '/year-groups',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/year-groups.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['YearGroup', function(YearGroup) {
                        return YearGroup.query();
                    }]
                }

            })
            .state({
                name: 'data.core.levels',
                url: '/levels',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/levels.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Level', function(Level) {
                        return Level.query();
                    }]
                }

            })
            .state({
                name: 'data.core.subjects',
                url: '/subjects',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/subjects.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Subject', function(Subject) {
                        return Subject.query();
                    }]
                }

            })
            .state({
                name: 'data.core.departments',
                url: '/departments',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/departments.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Department', function(Department) {
                        return Department.query();
                    }]
                }

            })
            .state({
                name: 'data.core.faculties',
                url: '/faculties',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/faculties.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Faculty', function(Faculty) {
                        return Faculty.query();
                    }]
                }

            })
            .state({
                name: 'data.core.risk-levels',
                url: '/risk-levels',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/risk-levels.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['RiskLevel', function(RiskLevel) {
                        return RiskLevel.query();
                    }]
                }

            })
            .state({
                name: 'data.core.tutor-groups',
                url: '/tutor-groups',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/tutor-groups.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['TutorGroup', function(TutorGroup) {
                        return TutorGroup.query();
                    }]
                }

            });
    }
})();

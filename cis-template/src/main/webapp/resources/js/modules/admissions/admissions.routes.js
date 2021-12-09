/**
 * This file defines the route configuration for the admissions section of the CID system.
 *
 */
(function() {
    'use strict';

    angular.module('cid.admissions').config(admissionsRoutesConfiguration);

    admissionsRoutesConfiguration.$inject = ['$stateProvider'];

    function admissionsRoutesConfiguration($stateProvider) {
        $stateProvider
            .state('admissions', {
                parent: 'site',
                url: '/admissions',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry', 'ROLE_Admissions - Interviewer']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/admissions/views/layout.html',
                    },
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/welcome.html',
                    },
                },
            })
            .state('admissions.search', {
                url: '/search',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/search.html',
                        controller: 'ApplicationSearchController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('admissions.new', {
                url: '/new',
                data: {
                    roles: ['ROLE_Admissions']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/new.html',
                        controller: 'AdmissionsNewApplicationController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    application: [function() {
                        return {
                            data: {
                                countryOfResidence: 'UK',
                                resident: true
                            },
                        };
                    }]
                }
            })
            .state('admissions.edit', {
                url: '/edit/{studentId}',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/edit.html',
                        controller: 'AdmissionsApplicationController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    applicationEntity: ['$stateParams', 'ApplicationForm', function($stateParams, ApplicationForm) {
                        return ApplicationForm.get($stateParams.studentId);
                    }]
                }
            })
            .state('admissions.list', {
                url: '/list',
                data: {
                    roles: ['ROLE_Admissions']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/list.html',
                        controller: 'ApplicationListController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    applicationListEntity: ['$stateParams', 'ApplicationForm', function($stateParams, ApplicationForm) {
                        return ApplicationForm.query();
                    }]
                }
            })
            .state('admissions.interview', {
                url: '/interview',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry', 'ROLE_Admissions - Interviewer']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/interview.html',
                        controller: 'ApplicationInterviewController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('admissions.interview.edit', {
                url: '/interview',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry', 'ROLE_Admissions - Interviewer']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/interview.html',
                        controller: 'ApplicationInterviewController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('admissions.acceptance-registration', {
                url: '/acceptance-registration',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/acceptance-registration.html',
                        controller: 'ApplicationAcceptanceRegistrationController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('admissions.acceptance-registration.edit', {
                url: '/acceptance-registration/{studentId}',
                data: {
                    roles: ['ROLE_Admissions', 'ROLE_Admissions - Data Entry']
                },
                views: {
                    "admissions": {
                        templateUrl: 'js/modules/admissions/views/acceptance-registration.html',
                        controller: 'ApplicationAcceptanceRegistrationController',
                        controllerAs: 'ctrl'
                    },
                },
            });
    }

})();

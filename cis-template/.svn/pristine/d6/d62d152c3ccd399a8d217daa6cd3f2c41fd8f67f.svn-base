(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(coreDataRouteConfiguration);

    coreDataRouteConfiguration.$inject = ['$stateProvider'];

    function coreDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.admissions', {
                abstract: true,
                url: '/admissions',
                data: {
                    roles: ['ROLE_Core Data', 'ROLE_Admissions']
                },
            })
            .state('data.admissions.application-statuses', {
                url: '/application-statuses',
                data: {
                    roles: ['ROLE_Core Data', 'ROLE_Admissions']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/application-statuses.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['ApplicationStatus', function(ApplicationStatus) {
                        return ApplicationStatus.query();
                    }]
                }
            })
            .state('data.admissions.schools', {
                url: '/schools',
                data: {
                    roles: ['ROLE_Core Data', 'ROLE_Admissions']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/schools.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['School', function(School) {
                        return School.query();
                    }]
                }

            })
            .state('data.admissions.offer-types', {
                url: '/offer-types',
                data: {
                    roles: ['ROLE_Core Data', 'ROLE_Admissions']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/offer-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['OfferType', function(OfferType) {
                        return OfferType.query();
                    }]
                }

            })
            .state('data.admissions.entry-qualification-types', {
                url: '/entry-qualification-types',
                data: {
                    roles: ['ROLE_Core Data', 'ROLE_Admissions']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/entry-qualification-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['EntryQualificationType', function(EntryQualificationType) {
                        return EntryQualificationType.query();
                    }]
                }

            })
            .state('data.admissions.entry-qualifications', {
                url: '/entry-qualifications',
                data: {
                    roles: ['ROLE_Core Data', 'ROLE_Admissions']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/entry-qualifications.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['EntryQualification', function(EntryQualification) {
                        return EntryQualification.query();
                    }]
                }

            });
    }
})();

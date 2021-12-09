(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(learningSupportDataRouteConfiguration);

    learningSupportDataRouteConfiguration.$inject = ['$stateProvider'];

    function learningSupportDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.learning-support', {
                abstract: true,
                url: '/learning-support',
            })
            .state('data.learning-support.special-categories', {
                url: '/special-categories',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/special-categories.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['SpecialCategory', function(SpecialCategory) {
                        return SpecialCategory.query();
                    }]
                }

            })
            .state('data.learning-support.concession-types', {
                url: '/concession-types',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/concession-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['ConcessionType', function(ConcessionType) {
                        return ConcessionType.query();
                    }]
                }

            })
            .state('data.learning-support.support-types', {
                url: '/support-types',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/support-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['SupportType', function(SupportType) {
                        return SupportType.query();
                    }]
                }

            })
            .state('data.learning-support.referral-reasons', {
                url: '/referral-reasons',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/referral-reasons.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['ReferralReason', function(ReferralReason) {
                        return ReferralReason.query();
                    }]
                }

            });
    }
})();

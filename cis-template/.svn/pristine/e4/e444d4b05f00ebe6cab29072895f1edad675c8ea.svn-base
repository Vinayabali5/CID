(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(ilpDataRouteConfiguration);

    ilpDataRouteConfiguration.$inject = ['$stateProvider'];

    function ilpDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.ilp', {
                abstract: true,
                url: '/ilp',
                data: {
                    roles: ['ROLE_Core Data']
                },
            })
            .state('data.ilp.interview-types', {
                url: '/interview-types',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/interview-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['ILPInterviewType', function(ILPInterviewType) {
                        return ILPInterviewType.query();
                    }]
                }
            })
            .state('data.ilp.letter-types', {
                url: '/letter-types',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/letter-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['LetterType', function(LetterType) {
                        return LetterType.query();
                    }]
                }
            })
            .state('data.ilp.statement-bank-types', {
                url: '/statement-bank-types',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/statement-bank-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['StatementBankType', function(StatementBankType) {
                        return StatementBankType.query();
                    }]
                }
            })
            .state('data.ilp.statement-banks', {
                url: '/statement-banks',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/statement-banks.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['StatementBank', function(StatementBank) {
                        return StatementBank.query();
                    }]
                }
            })
            .state('data.ilp.correspondence-types', {
                url: '/correspondence-types',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/correspondence-types.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['CorrespondenceType', function(CorrespondenceType) {
                        return CorrespondenceType.query();
                    }]
                }
            });

    }
})();

(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(examsDataRouteConfiguration);

    examsDataRouteConfiguration.$inject = ['$stateProvider'];

    function examsDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.exams', {
                abstract: true,
                url: '/exams',
                data: {
                    roles: ['ROLE_Core Data']
                },
            })
            .state('data.exams.exam-series', {
                url: '/exam-series',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/exam-series.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['ExamSeries', function(ExamSeries) {
                        return ExamSeries.query();
                    }]
                }

            })
            .state('data.exams.exam-boards', {
                url: '/exam-boards',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/exam-boards.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['ExamBoard', function(ExamBoard) {
                        return ExamBoard.query();
                    }]
                }

            });
    }
})();

(function() {
    angular.module('cid.exams.seating-plan').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('exams.seating-plan', {
                url: '/seating-plan',
                data: {
                    roles: ['ROLE_Exams Officer']
                },
                views: {
                    'content@': {
                        controller: 'SeatingPlanController',
                        controllerAs: 'ctrl',
                        templateUrl: 'js/modules/exams/seating-plan/views/seating-plan.html',
                    },
                },
                resolve: {
                    initExamDate: [function() {
                        return null;
                    }],
                    initExamSession: [function() {
                        return null;
                    }]
                }
            })
            .state('exams.seating-plan.load', {
                url: '/{year}/{month}/{day}/{session}',
                data: {
                    roles: ['ROLE_Exams Officer']
                },
                views: {
                    'content@': {
                        controller: 'SeatingPlanController',
                        controllerAs: 'ctrl',
                        templateUrl: 'js/modules/exams/seating-plan/views/seating-plan.html',
                    },
                },
                resolve: {
                    initExamDate: ['$stateParams', function($stateParams) {
                        var dateStringToParse = $stateParams.year + '-' + $stateParams.month + '-' + $stateParams.day + 'T00:00:00';
                        var examDate = Date.parse(dateStringToParse);
                        return examDate;
                    }],
                    initExamSession: ['$stateParams', function($stateParams) {
                        return $stateParams.session;
                    }]
                }
            })
            .state('exams.seating-plan.generator', {
                url: '/generator/{examRoomId}',
                data: {
                    roles: ['ROLE_Exams Officer']
                },
                views: {
                    'content@': {
                        controller: 'SeatingPlanGeneratorController',
                        controllerAs: 'ctrl',
                        templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-generator.html',

                    },
                },
                resolve: {
                    entity: ['$stateParams', 'ExamRoom', function($stateParams, ExamRoom) {
                        return {
                            examRoom: ExamRoom.get($stateParams.examRoomId)
                        };
                    }]
                },
            });
    }]);
})();

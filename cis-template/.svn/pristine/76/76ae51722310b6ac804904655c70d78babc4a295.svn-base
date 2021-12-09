(function() {
    angular
        .module('cid.exams.base-data-viewer')
        .config(examBaseDataViewer);

    examBaseDataViewer.$inject = ['$stateProvider', '$urlRouterProvider'];

    function examBaseDataViewer($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('exams.exam-base-data-viewer', {
                url: '/basedata',
                data: {
                    roles: ['ROLE_Exams Officer']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-viewer-form.html',
                        controller: 'BaseDataViewerController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    entity: function() {
                        return {};
                        //return ExamBoard.query();
                    }
                }
            })

            .state('view-by-id', {
                parent: 'exams.exam-base-data-viewer',
                url: '/{id}',
                views: {
                    "content@": {
                        templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-viewer-form.html',
                        controller: 'BaseDataViewerController',
                        controllerAs: 'ctrl'
                    },
                },
                params: {
                    uri: {
                        value: ''
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'ExamBoard', function($stateParams, ExamBoard) {
                        return ExamBoard.get($stateParams.id);
                    }]
                },
            });

        // more states here.
    }
})();

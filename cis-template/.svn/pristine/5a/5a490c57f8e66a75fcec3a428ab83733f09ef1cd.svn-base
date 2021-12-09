/**
 * This file defines the route configuration for the exams Generate Edi entries section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.exams.generate-edi')
        .config(generateEdiRouteConfiguration);

    generateEdiRouteConfiguration.$inject = ['$stateProvider', '$urlRouterProvider'];

    function generateEdiRouteConfiguration($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('exams.generate-edi', {
                url: '/generate-edi',
                views: {
                    "content@": {
                        templateUrl: 'js/modules/exams/generate-edi/views/generate-edi-form.html',
                        controller: 'GenerateEdiFileViewerController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    examSeriesList: ['ExamSeries', function(ExamSeries) {
                        return ExamSeries.query().then(function(response) {
                            var output = [];
                            angular.forEach(response.data, function(value, key) {
                                value.selected = false;
                                this.push(value);
                            }, output);
                            response.data = output;
                            return response;
                        });
                    }]
                }
            });
    }

})();

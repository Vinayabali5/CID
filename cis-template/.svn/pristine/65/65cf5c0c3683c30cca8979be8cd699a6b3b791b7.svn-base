/**
 * This is the ExamSeries Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ExamSeriesEditorDirective')
        .controller('ExamSeriesEditorController', ExamSeriesEditorController);

    ExamSeriesEditorController.$inject = ['$log', '$uibModal', '$scope', '$rootScope', 'ExamSeries', 'GLOBAL', 'APP'];

    function ExamSeriesEditorController($log, $uibModal, $rootScope, $scope, ExamSeries, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;

        vm.editExamSeries = editExamSeries;
        vm.addExamSeries = addExamSeries;

        function loadExamSeries() {
            ExamSeries.query().then(function(response) {
                $scope.examSeries = response.data;
                $log.info("Loading ExamSeries ");
            }, function(response) {
                $log.error("Failed to load ExamSeries");
            });
        }

        function editExamSeries(examSeriesId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/exam-series-editor/views/exam-series-editor-dialog.html',
                controller: 'ExamSeriesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    examSeriesEntity: function(ExamSeries) {
                        return ExamSeries.get(examSeriesId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                loadExamSeries();
            });
        }

        function addExamSeries() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/exam-series-editor/views/exam-series-editor-dialog.html',
                controller: 'ExamSeriesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    examSeriesEntity: function() {
                        var examSeries = {};
                        return examSeries;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                loadExamSeries();
            });
        }

    }

})();

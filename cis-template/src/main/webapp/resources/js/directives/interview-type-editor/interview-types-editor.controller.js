/**
 * This is the InterviewTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('InterviewTypesEditorDirective')
        .controller('InterviewTypesEditorController', InterviewTypesEditorController);

    InterviewTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'ILPInterviewType'];

    function InterviewTypesEditorController($log, $uibModal, $scope, ILPInterviewType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editInterviewTypes = editInterviewTypes;
        vm.addInterviewTypes = addInterviewTypes;

        function loadInterviewTypes() {
            ILPInterviewType.query().then(function(response) {
                $scope.interviewTypes = response.data;
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editInterviewTypes(interviewTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/interview-type-editor/views/interview-types-editorDialog.html',
                controller: 'InterviewTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    interviewTypesEntity: function(ILPInterviewType) {
                        return ILPInterviewType.get(interviewTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadInterviewTypes();
            });
        }

        function addInterviewTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/interview-type-editor/views/interview-types-editorDialog.html',
                controller: 'InterviewTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    interviewTypesEntity: function() {
                        var interviewTypes = {};
                        return interviewTypes;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadInterviewTypes();
            });
        }

    }

})();

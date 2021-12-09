/**
 * This is the ApplicationStatuss Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ApplicationStatusesEditorDirective')
        .controller('ApplicationStatusesEditorController', ApplicationStatusesEditorController);

    ApplicationStatusesEditorController.$inject = ['$log', '$uibModal', '$scope', 'ApplicationStatus'];

    function ApplicationStatusesEditorController($log, $uibModal, $scope, ApplicationStatus) {
        /* jshint validthis:true */
        var vm = this;

        vm.editApplicationStatuses = editApplicationStatuses;
        vm.addApplicationStatuses = addApplicationStatuses;

        function loadApplicationStatuses() {
            ApplicationStatus.query().then(function(response) {
                $scope.applicationStatuses = response.data;
                $log.info("Loading ApplicationStatuses ");
            }, function(response) {
                $log.error("Failed to load ApplicationStatuses");
            });
        }

        function editApplicationStatuses(applicationStatusId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/application-statuses-editor/views/application-statuses-editorDialog.html',
                controller: 'ApplicationStatusesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    applicationStatusesEntity: function(ApplicationStatus) {
                        return ApplicationStatus.get(applicationStatusId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadApplicationStatuses();
            });

        }

        function addApplicationStatuses() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/application-statuses-editor/views/application-statuses-editorDialog.html',
                controller: 'ApplicationStatusesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    applicationStatusesEntity: function() {
                        var applicationStatuses = {};
                        return applicationStatuses;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadApplicationStatuses();
            });

        }
    }

})();

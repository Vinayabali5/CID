/**
 * This is the AdmissionsNewApplicationController.
 * 
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034].
 * 
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('cid.admissions')
        .controller('AdmissionsNewApplicationController', AdmissionsNewApplicationController);

    AdmissionsNewApplicationController.$inject = ['Logger', '$window', '$uibModal', '$state', '$scope', '$rootScope', 'application', 'ApplicationForm', 'Person'];

    function AdmissionsNewApplicationController(Logger, $window, $uibModal, $state, $scope, $rootScope, application, ApplicationForm, Person) {
        /* jshint validthis:true */
        var vm = this;
        // Public Interface
        $scope.loaded = false;
        $scope.application = application.data != undefined ? application.data : {};
        $scope.required = '@';
        $scope.application.contacts = [];
        $scope.application.requests = [];
        $scope.save = saveApplication;
        $scope.cancel = cancel;
        $scope.validate = duplicateDetection;

        /**
         * This function is used to create the new application and redirect the page to edit application form.
         */
        function saveApplication() {
            if ($scope.application) {
                Logger.log($scope.application);
                ApplicationForm.create($scope.application).then(function(response) {
                    if (response.data.id) {
                        $state.go('admissions.edit', {
                            studentId: response.data.id
                        });
                    } else {
                        Logger.info("EE A problem occurred trying to create an application form.", true);
                    }
                });
            }
        }

        /**
         * This function is used to detect the duplicate Application Form.
         */
        function duplicateDetection() {
            var surname = application.data.surname;
            var dob = application.data.dob;
            if (surname, dob) {
                ApplicationForm.duplicateDetection(application.data).then(function(response) {
                    vm.duplicates = response.data;
                    if (vm.duplicates) {
                        var modalInstance = $uibModal.open({
                            templateUrl: 'js/modules/admissions/views/duplicate-detection.html',
                            size: 'xl',
                            controller: ['$scope', '$uibModalInstance', function($scope, $uibModalInstance) {
                                $scope.duplicates = vm.duplicates;
                                /**
                                 * This function is used to close the dialog box and continue.
                                 */
                                $scope.continueApplication = function() {
                                    $uibModalInstance.close();
                                };
                                /**
                                 * This function is used to clear the page.
                                 */
                                $scope.clearApplication = function() {
                                    bootbox.confirm("<p>This will clear the current application form.</p><p>Are you sure?</p>", function(result) {
                                        if (result == true) {
                                            $window.location.reload();
                                            $uibModalInstance.close();
                                        }
                                    });
                                };
                                /**
                                 * This function is used to load parent contact details.
                                 */
                                $scope.selectTwin = function(person) {
                                    twinContactDetails(person);
                                    $uibModalInstance.close();
                                };
                            }]
                        });
                    }
                });
            } else {
                return null;
            }
        }

        /**
         * This function is used to load the parent contact details.
         */
        function twinContactDetails(person) {
            if (person != null) {
                $scope.application.address = person.address;
                $scope.application.contacts = person.contacts;
            }
        }

        /**
         * This function is used to cancel the application.
         */
        function cancel() {
            $scope.loaded = false;
            $scope.application = {};
        }

    }

})();

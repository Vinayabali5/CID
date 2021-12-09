/**
 * This file defines the student records module for the CID system.
 */
(function() {
    'use strict';

    angular
        .module('cid.admissions')
        .controller('AdmissionsApplicationController', AdmissionsApplicationController);

    AdmissionsApplicationController.$inject = ['$q', '$log', '$scope', '$rootScope', '$state', '$stateParams', 'applicationEntity',
        'Address', 'Person', 'ApplicationForm', 'Student', 'Request', 'StudentLLDDHealthProblemCategory', 'StudentFile'
    ];

    function AdmissionsApplicationController($q, $log, $scope, $rootScope, $state, $stateParams, applicationEntity, Address,
        Person, ApplicationForm, Student, Request, StudentLLDDHealthProblemCategory, StudentFile) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.loaded = false;
        $scope.application = applicationEntity.data != undefined ? applicationEntity.data : {};
        $scope.studentAddress = {};
        $scope.studentPerson = {};
        $scope.contacts = [];
        $scope.requests = [];
        $scope.studentNotes = [];
        $scope.collegeFundPayments = [];
        $scope.llddHealthProblemCategory = [];
        $scope.studentFiles = [];
        $scope.ilpInterviews = [];

        // Public Interface - Methods
        $scope.save = saveApplication;
        $scope.cancel = cancel;

        init();

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('ilpInterview-saved', function(data) {
            Student.ilpInterviews($scope.application.id).then(function(response) {
                $scope.ilpInterviews = response.data;
            });
        }));

        $scope.$on('$destroy', $rootScope.$on('contact-saved', function(data) {
            loadContacts($scope.application.personId);
        }));
        /**
         * This method is used to initialise the data for the application form.
         */
        function init() {
            var personId = $scope.application.personId;
            var addressId = $scope.application.addressId;
            var id = $scope.application.id;

            if (id != undefined && id != null) {
                Request.getByStudentId(id).then(function(response) {
                    $scope.requests = response.data;
                    $rootScope.$emit('requests.loaded');
                });
                Student.collegeFundPayments(id).then(function(response) {
                    $scope.collegeFundPayments = response.data;
                    $rootScope.$emit('college-fund-payments.loaded');
                });
                StudentLLDDHealthProblemCategory.getByStudentId(id).then(function(response) {
                    $scope.llddHealthProblemCategory = response.data;
                    $rootScope.$emit('lldd-health-problem-categories.loaded');
                });
                StudentFile.getByStudentId(id).then(function(response) {
                    $scope.studentFiles = response.data;
                    $rootScope.$emit('student-files.loaded');
                });
                Student.ilpInterviews(id).then(function(response) {
                    $scope.ilpInterviews = response.data;
                    $rootScope.$emit('student.ilp-interviews.loaded');
                });
            }

            if (addressId != undefined && addressId != null) {
                Address.get(addressId).then(function(response) {
                    $scope.studentAddress = response.data;
                    $rootScope.$emit('student.address.loaded');
                });
            }

            if (personId != undefined && personId != null) {
                Person.get(personId).then(function(response) {
                    $scope.studentPerson = response.data;
                    $rootScope.$emit('student.person.loaded');
                });
                Person.contacts(personId).then(function(response) {
                    $scope.contacts = response.data;
                    $rootScope.$emit('student.contacts.loaded');
                });
                Person.notes(personId).then(function(response) {
                    $scope.studentNotes = response.data;
                    $rootScope.$emit('student.notes.loaded');
                });
            }

        }

        /**
         * This method is used to load the contact list after add, edit and delete operation.
         */
        function loadContacts(personId) {
            vm.contacts = [];
            Person.contacts(personId).then(function(response) {
                vm.contacts = response.data;
                $rootScope.$emit('student.contacts.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load perons' contacts for person: " + personId);
            });
        }
        // Private Interface

        /**
         * This method is used to save the application form via the ApplicationFrom service. 
         */
        function saveApplication() {
            if ($scope.application !== undefined && $scope.application != null && $scope.application.id != undefined && $scope.application.id != null) {
                ApplicationForm.save($scope.application);
            }
        }

        /** 
         * This method is used to cancel the editing of the currently selected application form.
         */
        function cancel() {
            $scope.loaded = false;
            $scope.application = {};
        }


    }

})();

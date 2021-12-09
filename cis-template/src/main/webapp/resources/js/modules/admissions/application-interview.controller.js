/**
 * The Search Module for finding applicants
 */
(function() {
    'use strict';

    angular
        .module('cid.admissions')
        .controller('ApplicationInterviewController', ApplicationInterviewController);

    ApplicationInterviewController.$inject = [
        '$log', '$window', 'Logger', '$state', '$stateParams', '$scope', '$http', '$rootScope',
        'ApplicationForm', 'Student', 'StudentRiskLevel', 'Request', 'SchoolReference', 'Person', 'Note', 'StudentPredictedGrade', 'StudentFile'
    ];

    function ApplicationInterviewController($log, $window, Logger, $state, $stateParams, $scope, $http, $rootScope,
        ApplicationForm, Student, StudentRiskLevel, Request, SchoolReference, Person, Note, StudentPredictedGrade, StudentFile
    ) {
        /* jshint validthis:true */
        var vm = this;

        var DEBUG = false; // Set this to true for extra debug information for this controller

        // Public Interface - Variables
        $scope.applicationList = [];
        $scope.visible = false;
        $scope.message = null;

        $scope.interview = null;
        $scope.requests = null;
        $scope.interviewNote = null;
        $scope.reference = null;
        $scope.studentPredictedGrades = null;
        $scope.ilpInterviews = null;
        $scope.studentRiskLevels = null;

        // Public Interface - Methods
        $scope.search = search;
        $scope.loadInterview = loadInterview;
        $scope.save = save;

        $scope.hasResults = hasResults;
        $scope.resultsVisible = resultsVisible;
        $scope.toggleResults = toggleResults;

        // Initialise 
        clearSearchResults();
        clearRecord();
        focusInput();

        // Private Interface

        /**
         * This method is used to perform a search for an application based on the name or student ID. 
         * 
         * @param {*} search The is the search value to use for the search
         */
        function search(search) {
            Logger.debug('II StudentSearchController :: search called');
            clearSearchResults();
            clearRecord();
            $scope.message = "Loading please wait!";
            ApplicationForm.search(search).then(function(response) {
                $scope.applicationList = response.data;
                if ($scope.hasResults()) {
                    $scope.visible = true;
                }
                $scope.message = null;
            }, function(response) {
                $scope.visible = false;
                $scope.message = response.data.message;
            });
        }

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('ilpInterview-saved', function(data) {
            Student.ilpInterviews($scope.interview.studentId).then(function(response) {
                $scope.ilpInterviews = response.data;
            });
        }));

        /**
         * This method is used to load an Interview reocrd and all associated data.
         * 
         * @param {Integer} id The ID for the record to load.
         */
        function loadInterview(id) {
            clearRecord();
            if (id !== null && id !== undefined) {
                // Retrieve the core interview details
                ApplicationForm.getByStudentId(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.interview = response.data;
                    if ($scope.interview !== null && $scope.interview.personId !== null) {
                        Person.notes($scope.interview.personId).then(function(response) {
                            if (DEBUG) console.log(response);
                            var notes = response.data;
                            $rootScope.$emit('person-notes-loaded');
                            if (notes.length > 1) {
                                console.log('Multiple person notes found - searching for Admission Interview notes');
                                angular.forEach(notes, function(note) {
                                    if (note !== null && note.type !== null && note.type.id === 8) {
                                        $scope.interviewNote = note;
                                    }
                                });
                            } else {
                                $scope.interviewNote = notes[0];
                            }
                        }, function(response) {
                            $log.warn("This student does not have any interview notes");
                        });
                    } else {
                        return null;
                    }
                }, function(response) {
                    if (DEBUG) console.log(response);
                    console.log("Could not retrieve the Interview details");
                });

                // Retrieve the course requests for the applicant
                Request.getByStudentId(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.requests = response.data;
                    $rootScope.$emit('requests.loaded');
                }, function(response) {
                    if (DEBUG) console.log(response);
                    $log.error("Failed to load requests");
                    $scope.requests = null;
                });

                // Retrieve the admissions ILP Interviews for the applicant
                Student.ilpInterviews(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.ilpInterviews = response.data;
                    $rootScope.$emit('student.ilp-interviews.loaded');
                }, function(response) {
                    if (DEBUG) console.log(response);
                    $log.error("Failed to load ilpInterviews");
                    $scope.ilpInterviews = null;
                });

                // Retrieve the school reference for the applicant
                SchoolReference.get(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.reference = response.data;
                    $rootScope.$emit('school-references.loaded');
                }, function(response) {
                    if (DEBUG) console.log(response);
                    $log.error("Failed to load school-refernces");
                    $scope.reference = null;
                });

                // Retrieve the student risk level for the applicant
                StudentRiskLevel.getByStudentId(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.studentRiskLevels = response.data;
                    $rootScope.$emit('student-risk-levels-loaded');
                }, function(response) {
                    if (DEBUG) console.log(response);
                    $log.error("EE Failed to load the student's risk levels for student: " + id);
                    $scope.studentRiskLevels = null;
                });

                // Retrieve the predicted grades for the applicant
                StudentPredictedGrade.get(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.studentPredictedGrades = response.data;
                    $rootScope.$emit('student-predicted-grades-loaded');
                }, function(response) {
                    if (DEBUG) console.log(response);
                    $log.error("Failed to load student-predicted-grades");
                    $scope.studentPredictedGrades = null;
                });

                // Retrieve the student files for the applicant
                StudentFile.getByStudentId(id).then(function(response) {
                    if (DEBUG) console.log(response);
                    $scope.studentFiles = response.data;
                    $rootScope.$emit('student-files.loaded');
                }, function(response) {
                    if (DEBUG) console.log(response);
                    $log.error("Failed to load students files data");
                    $scope.studentFiles = null;
                });
            }
            $('#collapseInterviewDetails').show();
            $scope.searchTerm = "";
            if (resultsVisible()) toggleResults();
        }

        /**
         * This method is used to save the interview data to the API. 
         */
        function save() {
            if ($scope.interview.studentId) {
                if ($scope.interviewNote != null) {
                    if ($scope.interviewNote.id !== undefined && $scope.interviewNote.id !== null) {
                        Note.save($scope.interviewNote);
                    } else if ($scope.interviewNote !== null && $scope.interviewNote.note !== undefined && $scope.interviewNote.note !== null) {
                        var interviewNote = {};
                        interviewNote.note = $scope.interviewNote.note;
                        interviewNote.typeId = 8;
                        interviewNote.personId = $scope.interview.personId;
                        Note.create(interviewNote);
                    } else {
                        $scope.interviewNote = null;
                    }
                }
                ApplicationForm.saveInterview($scope.interview);
                $('#collapseInterviewDetails').hide();
                $scope.searchTerm = "";
                $('input[autofocus]:visible:first').focus();
            }
        }

        /**
         * This method is used to clear the search results.
         */
        function clearSearchResults() {
            $scope.visible = false;
            $scope.applicationList = [];
        }

        /**
         * This method is used to clear the currently loaded record from memory.
         */
        function clearRecord() {
            $('#collapseInterviewDetails').hide();
            $scope.interview = {};
            $scope.requests = [];
            $scope.interviewNote = {
                note: null
            };
            $scope.reference = {};
            $scope.studentPredictedGrades = [];
            $scope.ilpInterviews = [];
        }

        /**
         * This method is used to focus the input search field
         * 
         */
        function focusInput() {
            $('input[autofocus]:visible:first').focus();
        }

        /**
         * This method is used to determine if the controll has any search results in memory.
         */
        function hasResults() {
            if ($scope.applicationList !== null && $scope.applicationList.size !== 0) {
                return true;
            }
            return false;
        }

        /**
         * This method is used to determine if the search results should be visible or not. 
         */
        function resultsVisible() {
            if ($scope.hasResults()) {
                return $scope.visible;
            }
            return false;
        }

        /**
         * This method is used to toggle the visibility of the search results. 
         */
        function toggleResults() {
            $scope.visible = !$scope.visible;
        }


    }
})();

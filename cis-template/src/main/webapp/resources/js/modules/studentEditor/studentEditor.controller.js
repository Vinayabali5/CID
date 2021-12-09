/**
 * This file defines the student records module for the CID system.
 */
(function() {
    'use strict';

    angular
        .module('cid.student-record')
        .controller('StudentEditorController', StudentEditorController);

    StudentEditorController.$inject = ['$log', '$scope', '$rootScope', '$state', '$stateParams', 'studentEntity', 'Student', 'Person',
        'Address', 'Contact', 'StudentWarning', 'PastoralMonitor', 'StudentEntryQualification', 'StudentBursary', 'MasterRegister',
        'StudentCollegeFundPaid', 'LearningSupportCost', 'LearningSupportVisit', 'StudentReferralReason', 'StudentLLDDHealthProblemCategory',
        'StudentRiskLevel', 'StudentRiskAssessment', 'StudentSafetyPlan', 'StudentWorkPlacement', 'StudentCareersRecord', 'StudentCourseConcession',
        'StudentCourseSupportType', 'StudentVolunteeringLog', 'StudentDukeOfEdinburgh', 'StudentFile', 'SchoolReference', 'GLOBAL', 'APP'
    ];

    function StudentEditorController($log, $scope, $rootScope, $state, $stateParams, studentEntity, Student, Person,
        Address, Contact, StudentWarning, PastoralMonitor, StudentEntryQualification, StudentBursary, MasterRegister,
        StudentCollegeFundPaid, LearningSupportCost, LearningSupportVisit, StudentReferralReason, StudentLLDDHealthProblemCategory,
        StudentRiskLevel, StudentRiskAssessment, StudentSafetyPlan, StudentWorkPlacement, StudentCareersRecord, StudentCourseConcession,
        StudentCourseSupportType, StudentVolunteeringLog, StudentDukeOfEdinburgh, StudentFile, SchoolReference, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;

        // Controller Properties and Variables
        vm.loaded = false;
        vm.student = studentEntity ? studentEntity.data : {};
        vm.studentAddress = {};
        vm.studentPerson = {};
        vm.studentYear = {};
        vm.studentAdmissions = {};
        vm.contacts = [];
        vm.contact = {};
        vm.enrolments = [];
        vm.studentBursary = {};
        vm.specialCategories = [];
        vm.studentEntryQualifications = [];
        vm.externalResultsArchive = [];
        vm.registers = [];
        vm.studentOverallAttendance = {};
        vm.ilpInterviews = [];
        vm.learningSupport = {};
        vm.collegeFundPayments = [];
        vm.interimReports = [];
        vm.examResults = [];
        vm.studentAlternativeUcis = [];
        vm.studentOptionEntries = [];
        vm.studentCollegeFundPaid = [];
        vm.identificationViolations = [];
        vm.studentLearningSupportCosts = [];
        vm.studentLearningSupportVisits = [];
        vm.warningCodeChanges = [];
        vm.studentNotes = [];
        vm.correspondence = [];
        vm.studentReferralReason = [];
        vm.studentLLDDHealthProblemCategory = [];
        vm.studentRiskLevels = [];
        vm.studentRiskAssessment = {};
        vm.studentSafetyPlan = {};
        vm.studentWorkPlacements = [];
        vm.studentCareersRecords = [];
        vm.studentCourseConcessions = [];
        vm.studentCourseSupportTypes = [];
        vm.studentVolunteeringLogs = [];
        vm.studentDukeOfEdinburghs = [];
        vm.studentFiles = [];
        vm.reference = {};

        vm.ilpFilter = {};

        vm.currentYear = APP.getYear();

        // Controller Methods
        vm.loadStudent = loadStudent;

        vm.loadStudentYear = loadStudentYear;
        vm.loadContacts = loadContacts;
        vm.loadEnrolments = loadEnrolments;
        vm.loadSpecialCategories = loadSpecialCategories;
        vm.loadRegister = loadRegister;
        vm.loadStudentEntryQualifications = loadStudentEntryQualifications;
        vm.loadBursary = loadBursary;
        vm.loadPastoralMonitor = loadPastoralMonitor;
        vm.loadAdmissions = loadAdmissions;
        vm.loadWarnings = loadWarnings;
        vm.loadOverallAttendance = loadOverallAttendance;
        vm.loadIlpInterviews = loadIlpInterviews;
        vm.loadExternalResultsArchive = loadExternalResultsArchive;
        vm.loadLearningSupport = loadLearningSupport;
        vm.loadCollegeFundPayments = loadCollegeFundPayments;
        vm.loadInterimReports = loadInterimReports;
        vm.loadExamResults = loadExamResults;
        vm.loadAlternativeUcis = loadAlternativeUcis;
        vm.loadOptionEntries = loadOptionEntries;
        vm.loadStudentCollegeFundPaid = loadStudentCollegeFundPaid;
        vm.loadIdentificationViolations = loadIdentificationViolations;
        vm.loadStudentLearningSupportCosts = loadStudentLearningSupportCosts;
        vm.loadStudentLearningSupportVisits = loadStudentLearningSupportVisits;
        vm.loadWarningCodeChanges = loadWarningCodeChanges;
        vm.loadStudentNotes = loadStudentNotes;
        vm.loadStudentReferralReason = loadStudentReferralReason;
        vm.loadStudentLLDDHealthProblemCategory = loadStudentLLDDHealthProblemCategory;
        vm.loadStudentRiskLevels = loadStudentRiskLevels;
        vm.loadStudentRiskAssessment = loadStudentRiskAssessment;
        vm.loadStudentSafetyPlan = loadStudentSafetyPlan;
        vm.studentWorkPlacements = loadStudentWorkPlacements;
        vm.studentCareersRecords = loadStudentCareersRecords;
        vm.studentCourseConcessions = loadStudentCourseConcessions;
        vm.studentCourseSupportTypes = loadStudentCourseSupportTypes;
        vm.studentVolunteeringLogs = loadStudentVolunteeringLogs;
        vm.studentDukeOfEdinburghs = loadStudentDukeOfEdinburghs;
        vm.loadStudentReference = loadStudentReference;

        vm.clear = clear;
        vm.init = init;

        init();

        // Private Interface

        function getAppYear() {
            return APP.getYear();
        }

        $rootScope.$watch(getAppYear, function() {
            vm.currentYear = APP.getYear();
        });

        // Controller Methods
        function init() {
            $log.log('StudentRecordsController::init called');
            if ($stateParams.studentId) {
                loadStudent($stateParams.studentId);
            }
            // Register Event Listners
            $scope.$on('$destroy', $rootScope.$on('student-withdrawn', function(data) {
                loadStudent(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on('enrolments-saved', function(data) {
                loadEnrolments(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on('enrolments-updated', function(data) {
                loadEnrolments(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on('entry-qualification-changed', function(data) {
                loadStudent(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on('register-saved', function(data) {
                loadRegister(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("exam-results-saved", function(data) {
                loadExamResults(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
                loadStudentYear(vm.student.id, APP.getYear().id);
                loadEnrolments(vm.student.id);
                loadInterimReports(vm.student.id);
                loadRegister(vm.student.id);
                loadOptionEntries(vm.student.id);
                loadOverallAttendance(vm.student.id);
                loadBursary(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("option-entires-updated", function(data) {
                loadOptionEntries(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("fund-paid-updated", function(data) {
                loadStudentCollegeFundPaid(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-admission-updated", function(data) {
                loadAdmissions(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("identification-violation-saved", function(data) {
                loadIdentificationViolations(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("notes-saved", function(data) {
                loadStudentNotes(vm.student.person.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-learning-support-saved", function(data) {
                loadLearningSupport(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-course-concession-saved", function(data) {
                loadLearningSupport(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-referral-reason-saved", function(data) {
                loadStudentReferralReason(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-lldd-health-problem-category-saved", function(data) {
                loadStudentLLDDHealthProblemCategory(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-interim-reports-saved", function(data) {
                loadInterimReports(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("course-concession-saved", function(data) {
                loadStudentCourseConcessions(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-risk-assessment-saved", function(data) {
                loadStudentRiskAssessment(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("course-support-types-saved", function(data) {
                loadStudentCourseSupportTypes(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("pastoralMonitor-saved", function(data) {
                loadPastoralMonitor(vm.student.id);
            }));
            $scope.$on('$destroy', $rootScope.$on("student-file.saved", function(data) {
                loadStudentFiles(vm.student.id);
            }));

            if ($stateParams.tab !== undefined && $stateParams.tab !== null) {
                $scope.activeTab = $stateParams.tab;
            }
        }

        function clear() {
            vm.loaded = false;
            vm.student = [];
            vm.studentAddress = {};
            vm.studentPerson = {};
            vm.studentYear = {};
            vm.contacts = [];
            vm.contact = {};
            vm.enrolments = [];
            vm.studentBursary = {};
            vm.pastoralMonitor = {};
            vm.specialCategories = [];
            vm.studentAdmissions = {};
            vm.studentEntryQualifications = [];
            vm.externalResultsArchive = [];
            vm.registers = [];
            vm.studentOverallAttendance = {};
            vm.ilpInterviews = [];
            vm.learningSupport = {};
            vm.collegeFundPayments = [];
            vm.interimReports = [];
            vm.examResults = [];
            vm.studentAlternativeUcis = [];
            vm.studentOptionEntries = [];
            vm.identificationViolations = [];
            vm.studentLearningSupportCosts = [];
            vm.studentLearningSupportVisits = [];
            vm.warningCodeChnages = [];
            vm.studentNotes = [];
            vm.correspondence = [];
            vm.studentReferralReason = [];
            vm.studentLLDDHealthProblemCategory = [];
            vm.studentRiskLevels = [];
            vm.studentRiskAssessment = {};
            vm.studentSafetyPlan = {};
            vm.studentWorkPlacements = [];
            vm.studentCareersRecords = [];
            vm.studentCourseConcessions = [];
            vm.studentCourseSupportTypes = [];
            vm.studentVolunteeringLogs = [];
            vm.studentDukeOfEdinburghs = [];
            vm.studentFiles = [];
            vm.reference = {};
        }

        function loadStudent(id) {
            $log.log('StudentRecordsController::loadStudent called');
            Student.get(id).then(function(response) {
                $log.log('II Student with ID: ' + id + ' retireved.');
                vm.student = response.data;
                if (response.data) {
                    vm.loaded = true;
                    $rootScope.$emit('student.loaded');
                }
                var personId = vm.student.person.id;
                var addressId = vm.student.person.addressId;

                if (addressId) {
                    Address.get(addressId).then(function(response) {
                        vm.studentAddress = response.data;
                        $rootScope.$emit('student.address.loaded');
                    });
                }
                if (personId) {
                    Person.get(personId).then(function(response) {
                        vm.studentPerson = response.data;
                        $rootScope.$emit('student.person.loaded');
                    });
                }
                if (personId) {
                    loadContacts(personId);
                    loadStudentNotes(personId);
                }

            }, function(response) {
                $log.log('EE An error occurred trying to retireve the student with ID: ' + id);
                alert("Failed to retrieve student with ID: " + id);
            });

            loadStudentYear(id, APP.getYear().id);
            loadBursary(id);
            loadPastoralMonitor(id);
            loadAdmissions(id);
            loadEnrolments(id);
            loadStudentEntryQualifications(id);
            loadExternalResultsArchive(id);
            loadWarnings(id);
            loadSpecialCategories(id);
            loadRegister(id);
            loadOverallAttendance(id);
            loadIlpInterviews(id);
            loadLearningSupport(id);
            loadCollegeFundPayments(id);
            loadInterimReports(id);
            loadExamResults(id);
            loadAlternativeUcis(id);
            loadOptionEntries(id);
            loadStudentCollegeFundPaid(id);
            loadIdentificationViolations(id);
            loadStudentLearningSupportCosts(id);
            loadStudentLearningSupportVisits(id);
            loadWarningCodeChanges(id);
            loadStudentCorrespondence(id);
            loadStudentReferralReason(id);
            loadStudentLLDDHealthProblemCategory(id);
            loadStudentRiskLevels(id);
            loadStudentRiskAssessment(id);
            loadStudentSafetyPlan(id);
            loadStudentWorkPlacements(id);
            loadStudentCareersRecords(id);
            loadStudentCourseConcessions(id);
            loadStudentCourseSupportTypes(id);
            loadStudentVolunteeringLogs(id);
            loadStudentDukeOfEdinburghs(id);
            loadStudentFiles(id);
            loadStudentReference(id);
        }

        function loadContacts(personId) {
            vm.contacts = [];
            Person.contacts(personId).then(function(response) {
                vm.contacts = response.data;
                $rootScope.$emit('student.contacts.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load perons' contacts for person: " + personId);
            });
        }

        function loadStudentYear(id, yearId) {
            vm.studentYear = {};
            Student.studentYears(id, yearId).then(function(response) {
                vm.studentYear = response.data;
                $rootScope.$emit('student.year.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's year information for student: " + id);
            });
        }

        function loadAdmissions(id) {
            vm.studentAdmissions = {};
            Student.admissions(id).then(function(response) {
                vm.studentAdmissions = response.data;
                $rootScope.$emit('student.admissions.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's admissions information for studnet: " + id);
            });
        }

        function loadStudentReference(id) {
            vm.reference = {};
            SchoolReference.get(id).then(function(response) {
                vm.reference = response.data;
                $rootScope.$emit('student.reference.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's studentReference information for studnet: " + id);
            });
        }


        function loadBursary(id) {
            vm.studentBursary = {};
            Student.bursary(id).then(function(response) {
                vm.studentBursary = response.data;
                $rootScope.$emit('student.bursary.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's bursary information for studnet: " + id);
            });
        }

        function loadPastoralMonitor(id) {
            vm.pastoralMonitor = {};
            PastoralMonitor.get(id).then(function(response) {
                vm.pastoralMonitor = response.data;
                $rootScope.$emit('pastoral-monitor.loaded');
            }, function(response) {
                $log.error("EE Failed to load the pastoral monitor information for studnet: " + id);
            });
        }

        function loadEnrolments(id, year) {
            vm.enrolments = [];
            Student.enrolments(id, year).then(function(response) {
                vm.enrolments = response.data;
                $rootScope.$emit('student.enrolments.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's enrolments for student: " + id);
            });
        }

        function loadStudentEntryQualifications(id) {
            vm.studentEntryQualifications = [];
            StudentEntryQualification.get(id).then(function(response) {
                vm.studentEntryQualifications = response.data;
                $rootScope.$emit('student-entry-qualifications-loaded');
            }, function(response, status) {
                $log.error("EE Failed to load entryQualifications' entryQualifications: " + id);
            });
        }

        function loadWarnings(id) {
            vm.warnings = {};
            Student.warnings(id).then(function(response) {
                vm.warnings = response.data;
                $rootScope.$emit('student-warnings-loaded');
            }, function(response) {
                $rootScope.$emit('student-warnings-load-failed');
                $log.error("EE Failed to load the student's warnings for student: " + id);
            });
        }

        function loadSpecialCategories(id) {
            vm.specialCategories = [];
            Student.specialCategories(id).then(function(response) {
                vm.specialCategories = response.data;
                $rootScope.$emit('student-special-categories-loaded');
            }, function(response) {
                $rootScope.$emit('student-special-categories-load-failed');
                $log.error("EE Failed to load the student's warnings for student: " + id);
            });
        }

        function loadRegister(id) {
            vm.registers = [];
            MasterRegister.get(id).then(function(response) {
                vm.registers = response.data;
                $rootScope.$emit('student.registers.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load registers' registers: " + id);
                vm.registers = [];
            });
        }

        function loadOverallAttendance(id) {
            vm.studentOverallAttendance = {};
            Student.attendance(id).then(function(response) {
                Student.idViolations(id).then(function(response) {
                    vm.identificationViolations = response.data;
                }, function(response) {
                    $log.error("Failed to load student id violations " + id);
                });

                vm.studentOverallAttendance = response.data;
                $rootScope.$emit('student.overall-attendance.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load registers' registers: " + id);
            });
        }

        function loadIlpInterviews(id) {
            vm.ilpInterviews = [];
            Student.ilpInterviews(id).then(function(response) {
                vm.ilpInterviews = response.data;
                $rootScope.$emit('student.ilp-interviews.loaded');
                $scope.$on('$destroy', $rootScope.$on('ilpInterview-saved', function(data) {
                    loadIlpInterviews(id);
                }));
            }, function(response) {
                $log.error("EE Failed to load the student's ILP interviews for student: " + id);
                // vm.ilpInterviews = [];
            });
        }

        function loadExternalResultsArchive(id) {
            vm.externalResultsArchive = [];
            Student.externalResultsArchive(id).then(function(response) {
                vm.externalResultsArchive = response.data;
                $rootScope.$emit('student.external-results-archive.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's external results archive for student: " + id);
            });
        }

        function loadLearningSupport(id) {
            vm.learningSupport = {};
            Student.learningSupport(id).then(function(response) {
                vm.learningSupport = response.data;
                $rootScope.$emit('student.learning-support.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's learning support data for student: " + id);
            });
        }

        function loadCollegeFundPayments(id) {
            vm.collegeFundPayments = [];
            Student.collegeFundPayments(id).then(function(response) {
                vm.collegeFundPayments = response.data;
                $rootScope.$emit('student.college-fund-payments.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's college fund payments for student: " + id);
            });
        }

        function loadInterimReports(id) {
            vm.interimReports = [];
            Student.interimReports(id).then(function(response) {
                vm.interimReports = response.data;
                $rootScope.$emit('student.interim-reports.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student interim reports for student: " + id);
            });
        }

        function loadExamResults(id) {
            vm.examResults = [];
            Student.results(id).then(function(response) {
                vm.examResults = response.data;
                $rootScope.$emit('student.exam-results.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's exam results for student: " + id);
            });
        }

        function loadAlternativeUcis(id) {
            Student.studentAlternativeUci(id).then(function(response) {
                vm.studentAlternativeUcis = response.data;
                $rootScope.$emit('student.alternative-ucis.loaded');
            }, function(response) {
                $log.error("Failed to load the student's alternative Ucis for student: " + id);
            });
        }

        function loadOptionEntries(id) {
            Student.optionEntries(id).then(function(response) {
                vm.studentOptionEntries = response.data;
            }, function(response) {
                $log.error("Failed to load student option entries" + id);
            });
        }

        function loadStudentCollegeFundPaid(id) {
            StudentCollegeFundPaid.get(id).then(function(response) {
                vm.studentCollegeFundPaid = response.data;
            }, function(response) {
                $log.error("Failed to load student college fund paid" + id);
            });
        }

        function loadIdentificationViolations(id) {
            vm.identificationViolations = [];
            Student.idViolations(id).then(function(response) {
                vm.identificationViolations = response.data;
            }, function(response) {
                $log.error("Failed to load student id violations " + id);
            });
        }

        function loadStudentLearningSupportCosts(id) {
            vm.studentLearningSupportCosts = [];
            LearningSupportCost.getByStudent(id).then(function(response) {
                vm.studentLearningSupportCosts = response.data;
                $rootScope.$emit('student.learningSupportCosts.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load learningSupportCosts' learningSupportCosts: " + id);
            });
        }

        function loadStudentLearningSupportVisits(id) {
            vm.studentLearningSupportVisits = [];
            LearningSupportVisit.getByStudent(id).then(function(response) {
                vm.studentLearningSupportVisits = response.data;
                $rootScope.$emit('student.learningSupportVisits.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load learningSupportVisits' learningSupportVisits: " + id);
            });
        }

        function loadWarningCodeChanges(id) {
            vm.warningCodeChanges = [];
            StudentWarning.getStudentWarning(id).then(function(response) {
                vm.warningCodeChanges = response.data;
                $rootScope.$emit('student.warningCodeChanges.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load warningCodeChanges' warningCodeChanges: " + id);
            });
        }

        function loadStudentNotes(id) {
            Person.notes(id).then(function(response) {
                vm.studentNotes = response.data;
                $rootScope.$emit('student.notes.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load student notes: " + id);
            });
        }

        function loadStudentReferralReason(id) {
            StudentReferralReason.getByStudentId(id).then(function(response) {
                vm.studentReferralReason = response.data;
                $rootScope.$emit('student.referral-reason.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's referral reason for student: " + id);
                vm.studentReferralReason = [];
            });
        }

        function loadStudentCorrespondence(id) {
            Student.correspondence(id).then(function(response) {
                vm.correspondence = response.data;
                $rootScope.$emit('student.correspondence.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load student correspondence: " + id);
            });
        }

        function loadStudentRiskLevels(id) {
            vm.studentRiskLevels = [];
            StudentRiskLevel.getByStudentId(id).then(function(response) {
                vm.studentRiskLevels = response.data;
                $rootScope.$emit('student-risk-levels-loaded');
            }, function(response) {
                $rootScope.$emit('student-risk-levels-load-failed');
                $log.error("EE Failed to load the student's risk levels for student: " + id);
            });
        }

        function loadStudentRiskAssessment(id) {
            vm.studentRiskAssessment = undefined;
            StudentRiskAssessment.get(id).then(function(response) {
                vm.studentRiskAssessment = response.data;
                $rootScope.$emit('student-risk-assessments-loaded');
            }, function(response) {
                $rootScope.$emit('student-risk-assessments-load-failed');
                $log.error("EE Failed to load the student's risk assessments for student: " + id);
            });
        }

        function loadStudentSafetyPlan(id) {
            vm.studentSafetyPlan = undefined;
            StudentSafetyPlan.get(id).then(function(response) {
                vm.studentSafetyPlan = response.data;
                $rootScope.$emit('student-safety-plan-loaded');
            }, function(response) {
                $rootScope.$emit('student-safety-plans-load-failed');
                $log.error("EE Failed to load the student's safety plans for student: " + id);
            });
        }

        function loadStudentLLDDHealthProblemCategory(id) {
            StudentLLDDHealthProblemCategory.getByStudentId(id).then(function(response) {
                vm.studentLLDDHealthProblemCategory = response.data;
                $rootScope.$emit('student.lldd-health-problem-category.loaded');
            }, function(response) {
                $log.error("EE Failed to load the student's lldd health problem for student: " + id);
                vm.studentLLDDHealthProblemCategory = [];
            });
        }

        function loadStudentWorkPlacements(id) {
            vm.studentWorkPlacements = [];
            StudentWorkPlacement.getByStudentId(id).then(function(response) {
                vm.studentWorkPlacements = response.data;
                $rootScope.$emit('student-work-placements.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load WorkPlacements' WorkPlacements: " + id);
            });
        }

        function loadStudentCareersRecords(id) {
            vm.studentCareersRecords = [];
            StudentCareersRecord.getByStudentId(id).then(function(response) {
                vm.studentCareersRecords = response.data;
                $rootScope.$emit('student-careers-records.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load CareersRecords CareersRecords: " + id);
            });
        }

        function loadStudentCourseConcessions(id) {
            vm.studentCourseConcessions = [];
            StudentCourseConcession.getByStudentId(id).then(function(response) {
                vm.studentCourseConcessions = response.data;
                $rootScope.$emit('student-course-concessions-loaded');
            }, function(response, status) {
                $log.error("EE Failed to load course concessions CourseConcessions: " + id);
            });
        }

        function loadStudentCourseSupportTypes(id) {
            vm.studentCourseSupportTypes = [];
            StudentCourseSupportType.getByStudentId(id).then(function(response) {
                vm.studentCourseSupportTypes = response.data;
                $rootScope.$emit('student-course-support-types-loaded');
            }, function(response, status) {
                $log.error("EE Failed to load course SupportTypes CourseSupportTypes: " + id);
            });
        }

        function loadStudentVolunteeringLogs(id) {
            vm.studentVolunteeringLogs = [];
            StudentVolunteeringLog.getByStudentId(id).then(function(response) {
                vm.studentVolunteeringLogs = response.data;
                $rootScope.$emit('student-volunteering-logs.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load student-volunteering-logs VolunteeringLogs: " + id);
            });
        }

        function loadStudentDukeOfEdinburghs(id) {
            vm.studentDukeOfEdinburghs = [];
            StudentDukeOfEdinburgh.getByStudentId(id).then(function(response) {
                vm.studentDukeOfEdinburghs = response.data;
                $rootScope.$emit('student-duke-of-edinburghs.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load student-duke-of-edinburghs StudentDukeOfEdinburghs: " + id);
            });
        }

        function loadStudentFiles(id) {
            vm.studentFiles = [];
            StudentFile.getByStudentId(id).then(function(response) {
                vm.studentFiles = response.data;
                $rootScope.$emit('student-files.loaded');
            }, function(response, status) {
                $log.error("EE Failed to load student files StudentFiles: " + id);
            });
        }

    }

})();

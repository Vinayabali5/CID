/**
 * This is the main module definition for the site.
 *
 *  Applied Styles: [Y001, Y002, Y010, Y021]
 *
 * @type Module
 */
(function() {
    'use strict';

    angular
        .module('cid.data')
        .controller('DataController', DataController);

    DataController.$inject = ['$scope', '$rootScope', 'Logger', 'dataCollection', 'Block', 'Room', 'Period', 'TutorGroup', 'Faculty', 'Department', 'Subject', 'Level', 'YearGroup', 'School', 'Settings', 'LetterTemplate', 'PossibleGrade', 'PossibleGradeSet', 'TextLookup', 'AcademicYear', 'SpecialCategory', 'Holiday', 'AttendanceMonitoring', 'CentralMonitoring', 'PunctualityMonitoring', 'ReferralReason', 'ConcessionType', 'SupportType', 'OfferType', 'EntryQualificationType', 'ReportingPeriod', 'EntryQualification', 'ApplicationStatus', 'Staff', 'Role', 'RiskLevel', 'LetterType', 'CorrespondenceType', 'StatementBankType', 'StatementBank', 'ExamSeries', 'ExamBoard', 'GLOBAL', 'APP'];

    function DataController($scope, $rootScope, Logger, dataCollection, Block, Room, Period, TutorGroup, Faculty, Department, Subject, Level, YearGroup, School, Settings, LetterTemplate, PossibleGrade, PossibleGradeSet, TextLookup, AcademicYear, SpecialCategory, Holiday, AttendanceMonitoring, CentralMonitoring, PunctualityMonitoring, ReferralReason, ConcessionType, SupportType, OfferType, EntryQualificationType, ReportingPeriod, EntryQualification, ApplicationStatus, Staff, Role, RiskLevel, LetterType, CorrespondenceType, StatementBankType, StatementBank, ExamSeries, ExamBoard, GLOBAL, APP) {

        var vm = this;
        $scope.data = dataCollection.data;

        /** 
         * All the event listeners are destroyed once the functions are called
         * Event listeners for core data section.
         */
        $scope.$on('$destroy', $rootScope.$on('academic-year-saved', function(data) {
            loadAcademicYear();
        }));

        $scope.$on('$destroy', $rootScope.$on('holidays-saved', function(data) {
            loadHolidays();
        }));

        $scope.$on('$destroy', $rootScope.$on('yearGroups-saved', function(data) {
            loadYearGroups();
        }));

        $scope.$on('$destroy', $rootScope.$on('levels-saved', function(data) {
            loadLevels();
        }));

        $scope.$on('$destroy', $rootScope.$on('subjects-saved', function(data) {
            loadSubjects();
        }));

        $scope.$on('$destroy', $rootScope.$on('departments-saved', function(data) {
            loadDepartments();
        }));

        $scope.$on('$destroy', $rootScope.$on('faculties-saved', function(data) {
            loadFaculity();
        }));

        $scope.$on('$destroy', $rootScope.$on('tutor-groups-saved', function(data) {
            loadTutorGroups();
        }));

        /** 
         * Event listeners for Monitoring data section.
         */
        $scope.$on('$destroy', $rootScope.$on('attendance-monitorings-saved', function(data) {
            loadAttendanceMonitorings();
        }));

        $scope.$on('$destroy', $rootScope.$on('central-monitorings-saved', function(data) {
            loadCentralMonitorings();
        }));

        $scope.$on('$destroy', $rootScope.$on('punctuality-monitorings-saved', function(data) {
            loadPunctualityMonitorings();
        }));

        /** 
         * Event listeners for Timetabling data section.
         */
        $scope.$on('$destroy', $rootScope.$on('blocks-saved', function(data) {
            loadBlock();
        }));

        $scope.$on('$destroy', $rootScope.$on('periods-saved', function(data) {
            loadPeriods();
        }));

        $scope.$on('$destroy', $rootScope.$on('room-saved', function(data) {
            loadRooms();
        }));

        /** 
         * Event listeners for ILP data section.
         */
        $scope.$on('$destroy', $rootScope.$on('letter-types-saved', function(data) {
            loadLetterTypes();
        }));

        $scope.$on('$destroy', $rootScope.$on('correspondence-types-saved', function(data) {
            loadCorrespondenceTypes();
        }));

        $scope.$on('$destroy', $rootScope.$on('statement-bank-types-saved', function(data) {
            loadStatementBankTypes();
        }));

        $scope.$on('$destroy', $rootScope.$on('statement-banks-saved', function(data) {
            loadStatementBanks();
        }));

        /** 
         * Event listeners for Learning support data section.
         */
        $scope.$on('$destroy', $rootScope.$on('concessionTypes-saved', function(data) {
            loadConcessionTypes();
        }));

        $scope.$on('$destroy', $rootScope.$on('referralReasons-saved', function(data) {
            loadReferralReasons();
        }));

        $scope.$on('$destroy', $rootScope.$on('special-category-saved', function(data) {
            loadSpecialCatogories();
        }));

        $scope.$on('$destroy', $rootScope.$on('support-types-saved', function(data) {
            loadSupportTypes();
        }));

        /** 
         * Event listeners for Safeguarding data section.
         */
        $scope.$on('$destroy', $rootScope.$on('risk-levels-saved', function(data) {
            loadRiskLevels();
        }));

        /** 
         * Event listeners for admissions data section.
         */
        $scope.$on('$destroy', $rootScope.$on('schools-saved', function(data) {
            loadSchools();
        }));

        $scope.$on('$destroy', $rootScope.$on('application-statuses-saved', function(data) {
            loadApplicationStatuses();
        }));

        $scope.$on('$destroy', $rootScope.$on('offerTypes-saved', function(data) {
            loadOfferTypes();
        }));

        $scope.$on('$destroy', $rootScope.$on('entryQualifications-saved', function(data) {
            loadEntryQualifications();
        }));

        $scope.$on('$destroy', $rootScope.$on('entryQualificationTypes-saved', function(data) {
            loadEntryQualificationTypes();
        }));

        /** 
         * Event listeners for System data section.
         */

        $scope.$on("destory", $rootScope.$on('settings-saved', function(data) {
            loadSettings();
        }));

        $scope.$on('$destroy', $rootScope.$on('text-lookup-saved', function(data) {
            loadTextLookup();
        }));

        $scope.$on('$destroy', $rootScope.$on('letter-template-updated', function(data) {
            loadLetterTemplates();
        }));

        $scope.$on('$destroy', $rootScope.$on('reportingPeriods-saved', function(data) {
            loadReportingPeriods();
        }));

        $scope.$on('$destroy', $rootScope.$on('possible-grade-sets-saved', function(data) {
            loadPossibleGradeSets();
        }));

        /** 
         * Event listeners for Security data section.
         */
        $scope.$on('$destroy', $rootScope.$on('staff-saved', function(data) {
            loadStaffs();
        }));

        $scope.$on('$destroy', $rootScope.$on('role-saved', function(data) {
            loadRoles();
        }));

        /** 
         * Event listeners for Exams data section.
         */
        $scope.$on('$destroy', $rootScope.$on("exam-series-saved", function(data) {
            loadExamSeries();
        }));

        $scope.$on('$destroy', $rootScope.$on('exam-boards-saved', function(data) {
            loadExamBoards();
        }));

        /** 
         * This below function is to load the core data section.
         */
        function loadAcademicYear() {
            AcademicYear.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load AcademicYears");
            });
        }

        function loadHolidays() {
            Holiday.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadYearGroups() {
            YearGroup.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadLevels() {
            Level.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadSubjects() {
            Subject.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadDepartments() {
            Department.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadFaculity() {
            Faculty.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadTutorGroups() {
            TutorGroup.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the Monitoring data section.
         */
        function loadAttendanceMonitorings() {
            AttendanceMonitoring.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadCentralMonitorings() {
            CentralMonitoring.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadPunctualityMonitorings() {
            PunctualityMonitoring.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the Timetabling data section.
         */

        function loadBlock() {
            Block.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load Blocks");
            });
        }

        function loadPeriods() {
            Period.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadRooms() {
            Room.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the ILP data section.
         */
        function loadLetterTypes() {
            LetterType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadCorrespondenceTypes() {
            CorrespondenceType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadStatementBankTypes() {
            StatementBankType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadStatementBanks() {
            StatementBank.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the Learning support data section.
         */
        function loadConcessionTypes() {
            ConcessionType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadReferralReasons() {
            ReferralReason.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadSpecialCatogories() {
            SpecialCategory.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadSupportTypes() {
            SupportType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the safeguarding data section.
         */
        function loadRiskLevels() {
            RiskLevel.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the Admissions data section.
         */
        function loadSchools() {
            School.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadApplicationStatuses() {
            ApplicationStatus.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ApplicationStatuses");
            });
        }

        function loadOfferTypes() {
            OfferType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadEntryQualifications() {
            EntryQualification.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadEntryQualificationTypes() {
            EntryQualificationType.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the System data section.
         */
        function loadSettings() {
            Settings.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load");
            });
        }

        function loadTextLookup() {
            TextLookup.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadLetterTemplates() {
            LetterTemplate.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load");
            });
        }

        function loadReportingPeriods() {
            ReportingPeriod.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadPossibleGradeSets() {
            PossibleGradeSet.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }
        /** 
         * This below function is to load the Security data section.
         */
        function loadRoles() {
            Role.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadStaffs() {
            Staff.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        /** 
         * This below function is to load the Exams data section.
         */
        function loadExamSeries() {
            ExamSeries.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

        function loadExamBoards() {
            ExamBoard.query().then(function(response) {
                $scope.data = response.data;
            }, function(response) {
                Logger.error("Failed to load ");
            });
        }

    }
}());

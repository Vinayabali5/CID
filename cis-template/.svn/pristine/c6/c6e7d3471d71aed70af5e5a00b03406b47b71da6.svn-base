/**
 * This is the main site navigation controller.
 *
 * Styles Applied: [Y001, Y002, Y010, Y021, Y023, Y024, Y031, Y032, Y033, Y034, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('cid.site')
        .controller('MainSiteHomeController', MainSiteHomeController);

    MainSiteHomeController.$inject = ['$rootScope', '$scope', 'Logger', 'Staff', 'Auth', 'GLOBAL', 'APP', 'USER', 'InterimReportsDue'];

    function MainSiteHomeController($rootScope, $scope, Logger, Staff, Auth, GLOBAL, APP, USER, InterimReportsDue) {

        // Public Interface

        init();


        // Event Listners

        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            if ($scope.user !== undefined && $scope.user !== null) {
                loadStaffData($scope.user.staffId);
            }
        }));

        //Event listener to refresh the list
        $scope.$on('$destroy', $rootScope.$on('my-interim-reports-due-list', function(data) {
            InterimReportsDue.myInterimReports($scope.user.staffId).then(function(response) {
                $scope.studentInterimReports = response.data;
            });
        }));

        // Private Interface`

        function init() {
            $scope.user = Auth.getUser();
            if ($scope.user !== undefined && $scope.user !== null) {
                loadUserData();
            }
        }

        function loadUserData() {
            if ($scope.user !== undefined && $scope.user !== null) {
                if ($scope.user.staffId !== undefined && $scope.user.staffId !== null) {
                    loadStaffData($scope.user.staffId);
                }
                if ($scope.user.studentId !== undefined && $scope.user.studentId !== null) {
                    loadStudentData($scope.user.studentId);
                }

            }
        }

        function loadStaffData(staffId) {
            if (staffId !== undefined && staffId !== null) {
                Logger.info('Loading Staff Data');
                Staff.getTimetable(staffId).then(function(response) {
                    $scope.timetable = response.data.length !== 0 ? response.data : undefined;
                });
                Staff.getCourseGroups(staffId).then(function(response) {
                    $scope.courseGroups = response.data.length !== 0 ? response.data : undefined;
                });
                Staff.getTeachingGroups(staffId).then(function(response) {
                    $scope.teachingGroups = response.data.length !== 0 ? response.data : undefined;
                });
                Staff.getCourseLeaderGroups(staffId).then(function(response) {
                    $scope.courseLeaderGroups = response.data.length !== 0 ? response.data : undefined;
                });
                Staff.getHodGroups(staffId).then(function(response) {
                    $scope.hodGroups = response.data.length !== 0 ? response.data : undefined;
                });
                InterimReportsDue.myInterimReports(staffId).then(function(response) {
                    $scope.studentInterimReports = response.data.length !== 0 ? response.data : undefined;
                });
            } else {
                Logger.warn('No staffId supplied');
            }
        }

        function loadStudentData(studentId) {
            if (studentId !== undefined && studentId !== null) {
                // TODO: implement a student data loading routine
            } else {
                Logger.warn('No studerntId supplied');
            }

        }

    }
})();

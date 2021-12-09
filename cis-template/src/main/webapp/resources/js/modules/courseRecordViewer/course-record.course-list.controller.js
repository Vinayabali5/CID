(function() {
    'use strict';

    angular
        .module('cid.course-record-viewer')
        .controller('CourseListController', CourseListController);

    CourseListController.$inject = ['$log', '$scope', '$rootScope', '$state', 'courseList', 'Course', 'Auth', 'GLOBAL', 'APP'];

    function CourseListController($log, $scope, $rootScope, $state, courseList, Course, Auth, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        $scope.loaded = false;
        $scope.courses = courseList ? courseList.data : [];
        $scope.course = {};
        $scope.searchText = '';
        $scope.visible = false;

        $scope.loadCourse = loadCourse;
        $scope.loadCourseListByYear = loadCourseListByYear;
        $scope.applyFilter = applyFilter;
        $scope.toggleVisibility = toggleVisibility;
        $scope.resetFilters = resetFilters;

        $scope.userAllowActions = function(roles) {
            if (roles !== undefined) {
                return Auth.hasAnyRole(roles);
            }
            return Auth.hasAnyRole('ROLE_Core Data');
        };

        init();

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('course-saved', function(data) {
            Course.query().then(function(response) {
                $scope.courses = response.data;
            });
        }));

        // Private Interface

        function toggleVisibility() {
            $scope.visible = !$scope.visible;
        }

        // Apply filters
        $scope.filter = {
            spec: '',
            _levelDescription: '',
            _subjectDescription: '',
            _examBoardDescription: '',
            learningAimReference: ''
        };

        function applyFilter() {
            $scope.filterParams = {
                spec: $scope.filter.spec,
                _levelDescription: $scope.filter._levelDescription,
                _subjectDescription: $scope.filter._subjectDescription,
                _examBoardDescription: $scope.filter._examBoardDescription,
                learningAimReference: $scope.filter.learningAimReference
            };
        }

        function getCurrentYear() {
            return APP.getYear();
        }

        // loads course lists based on year change
        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            $scope.loadCourseListByYear(APP.getYear());
        }));

        function init() {
            $log.log('CourseRecordViewerController::init called');
            $scope.loadCourseListByYear(APP.getYear());
        }

        function loadCourse(id) {
            $log.log('CourseRecordViewerController::loadCourse called');
            Course.get(id).then(function(response) {
                    $log.log('II - Course with ID: ' + id + ' retireved.');
                    $scope.course = response.data;
                    if (response.data) {
                        $scope.loaded = true;
                    }
                    $rootScope.$emit('courses-loaded');
                },
                function(response) {
                    $log.log('EE - An error occurred trying to retireve the course with ID: ' + id);
                    alert("Failed to retrieve course with ID: " + id);
                });
        }

        function loadCourseListByYear(year) {
            Course.getByYear(year).then(function(response) {
                $log.info('II Successfully retrieve courses');
                $scope.courses = response.data;
            }, function(response) {
                $log.error('EE Failed to retrieve courses from API');
            });
        }

        // Resets the filter
        function resetFilters() {

            $scope.filterParams = {
                spec: '',
                _levelDescription: '',
                _subjectDescription: '',
                _examBoardDescription: '',
                learningAimReference: ''
            };

            $scope.filter = {
                spec: '',
                _levelDescription: '',
                _subjectDescription: '',
                _examBoardDescription: '',
                learningAimReference: ''
            };
        }

    }

})();

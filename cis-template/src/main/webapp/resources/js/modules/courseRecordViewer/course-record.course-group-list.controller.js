(function() {
    'use strict';

    angular
        .module('cid.course-record-viewer')
        .controller('CourseGroupListController', courseGroupListController);

    courseGroupListController.$inject = ['$log', '$scope', '$rootScope', '$state', 'courseGroupList', 'CourseGroup', 'Auth', 'GLOBAL', 'APP'];

    function courseGroupListController($log, $scope, $rootScope, $state, courseGroupList, CourseGroup, Auth, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        $scope.loaded = false;
        $scope.courseGroups = courseGroupList ? courseGroupList.data : [];
        $scope.courseGroup = {};
        $scope.searchText = '';

        $scope.loadCourse = loadCourseGroup;
        $scope.loadCourseGroupByYear = loadCourseGroupByYear;
        $scope.applyFilter = applyFilter;
        $scope.toggleVisibility = toggleVisibility;
        $scope.visible = false;
        $scope.resetFilters = resetFilters;

        $scope.userAllowActions = function() {
            return Auth.hasRole('ROLE_Core Data');
        };

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('course-group-saved', function(data) {
            CourseGroup.query().then(function(response) {
                $scope.courseGroups = response.data;
            });
        }));

        // Event Handlers

        // loads course lists based on year change
        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            $scope.loadCourseGroupByYear(APP.getYear());
        }));

        // Apply filters
        $scope.filter = {
            spec: '',
            _yearGroupDescription: '',
            _departmentDescription: ''

        };

        // Private Interface

        function init() {
            $log.log('CourseGroupListController::init called');
            CourseGroup.getByYear(APP.getYear()).then(function(response) {
                $log.info('II Successfully retrieved CourseGroups');
                $scope.courseGroups = response.data;
            }, function(response) {
                $log.error('EE Error retrieving CourseGroups');
            });
        }

        function applyFilter() {
            $scope.filterParams = {
                spec: $scope.filter.spec,
                _yearGroupDescription: $scope.filter._yearGroupDescription,
                _departmentDescription: $scope.filter._departmentDescription
            };
        }

        function toggleVisibility() {
            $scope.visible = !$scope.visible;
        }

        function loadCourseGroup(id) {
            $log.log('CourseGroupListController::loadCourseGroup called');
            CourseGroup.get(id).then(function(response) {
                $log.log('II - Course with ID: ' + id + ' retireved.');
                $scope.course = response.data;
                if (response.data) {
                    $scope.loaded = true;
                }
                $rootScope.$emit('course.loaded');
            }, function(response) {
                $log.log('EE - An error occurred trying to retireve the course with ID: ' + id);
                alert("Failed to retrieve course with ID: " + id);
            });
        }

        function loadCourseGroupByYear(year) {
            $log.log('CourseGroupListController::loadCourseGroupByYear called');
            CourseGroup.getByYear(year).then(function(response) {
                $log.info('II Successfully retrieved CourseGroupsByYear');
                $scope.courseGroups = response.data;
            }, function(response) {
                $log.error('EE Error retrieving CourseGroups');
            });
        }


        // Resets the filter
        function resetFilters() {

            $scope.filterParams = {
                spec: '',
                _yearGroupDescription: '',
                _departmentDescription: ''
            };

            $scope.filter = {
                spec: '',
                _yearGroupDescription: '',
                _departmentDescription: ''
            };
        }

    }

})();

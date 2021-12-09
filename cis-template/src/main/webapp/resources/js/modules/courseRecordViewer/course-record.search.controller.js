/**
 * This is the Course Record Viewer Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {

    'use strict';

    angular
        .module('cid.course-record-viewer')
        .controller('CourseViewerSearchController', courseViewerSearchController);


    courseViewerSearchController.$inject = ['$state'];

    function courseViewerSearchController($state) {
        /* jshint validthis:true */
        var vm = this;
        vm.loadCourse = loadCourse;

        function loadCourse(id) {
            $state.go('course-record.course.view', {
                courseId: id
            });
        }

    }

})();

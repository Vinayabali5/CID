/**
 * This file defines the student records module for the CID system.
 */
(function() {
    'use strict';

    angular
        .module('cid.student-record')
        .controller('StudentRecordSearchController', StudentRecordSearchController);

    StudentRecordSearchController.$inject = ['$scope', '$state'];

    function StudentRecordSearchController($scope, $state) {
        $scope.loadStudent = function(id) {
            $state.go('student-editor.edit', {
                studentId: id
            });
        };
    }

})();

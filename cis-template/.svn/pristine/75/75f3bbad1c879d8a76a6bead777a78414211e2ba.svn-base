/**
 * This is the StudentFile Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('StudentFilesDirective')
        .controller('StudentFilesController', StudentFilesController);


    StudentFilesController.$inject = ['$log', '$scope', '$state', '$http', 'GLOBAL', '$rootScope', '$uibModal', 'StudentFile'];

    function StudentFilesController($log, $scope, $state, $http, GLOBAL, $rootScope, $uibModal, StudentFile) {
        /* jshint validthis:true */
        var vm = this;

        vm.openStudentFiles = openStudentFiles;

        function openStudentFiles(filename) {
            StudentFile.create(filename);
        }

    }

})();

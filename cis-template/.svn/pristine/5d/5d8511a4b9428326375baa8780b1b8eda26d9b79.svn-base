/**
 * The ExamOptionViewer module for viewing Option basedata for either a specified syllabus, or for an individual examBoard
 */
(function() {
    'use strict';

    angular
        .module('OptionTableDirective')
        .controller('OptionTableDirectiveController', optionTableDirectiveController);


    optionTableDirectiveController.$inject = ['$rootScope', '$scope', '$http', '$uibModal', 'Option'];

    function optionTableDirectiveController($rootScope, $scope, $http, $uibModal, Option) {
        /*jshint validthis: true */
        var vm = this;
        vm.getOptions = getOptions;
        vm.getOptionsForSyllabus = getOptionsForSyllabus;
        vm.init = init;
        vm.optionList = [];
        vm.viewDetails = viewDetails;

        vm.init();

        $scope.$on('destroy', $rootScope.$on('exam-option-saved', getOptionsForSyllabus));
        $scope.$on('destroy', $rootScope.$on('exam-component-saved', getOptionsForSyllabus));

        /////////////////////////////////////////////////////////////////////////////////////

        //$scope.paginationInfo defaults populated within ExamSyllabusviewer

        function getOptions() {
            //			Option.query({
            //				page
            //			});
        }

        function getOptionsForSyllabus() {
            console.log("getOptionsForSyllabus" + $scope.syllabusId);
            Option.getBySyllabus($scope.syllabusId).then(function(data, header) {
                vm.optionList = data.data;
            });
        }

        function init() {
            if ($scope.expandable === null) {
                $scope.expandable = true;
            }
        }

        function viewDetails(headerCode, headerTitle, details) {
            console.log('$scope.viewDetails');
            var detailsViewer = $uibModal.open({
                templateUrl: 'js/modules/entities/genericViewer/genericViewer.html',
                controller: 'GenericViewerController',
                resolve: {
                    headerVal: function() {
                        return headerCode + " - " + headerTitle;
                    },
                    dataSet: function() {
                        return details;
                    }
                }
            });
        }
    }
})();

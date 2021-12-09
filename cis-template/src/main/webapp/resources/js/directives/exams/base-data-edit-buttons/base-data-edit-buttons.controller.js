/**
 * 
 */
(function() {
    angular
        .module('BaseDataEditButtonsDirective')
        .controller('BaseDataEditButtonsDirectiveController', baseDataEditButtonsDirectiveController);

    baseDataEditButtonsDirectiveController.$inject = ['$scope', '$uibModal'];

    function baseDataEditButtonsDirectiveController($scope, $uibModal) {
        var vm = this;

        vm.addCallback = addCallback;
        vm.editCallback = editCallback;
        vm.viewStudentsCallback = viewStudentsCallback;
        vm.init = init;

        function addCallback() {
            $scope.addCallback({
                syllabusData: vm.syllabusData,
                optionData: vm.optionData,
                componentData: vm.componentData
            });
        }

        function componentCallback(data) {
            return data.component;
        }

        function editCallback() {
            $scope.editCallback({
                syllabusData: vm.syllabusData,
                optionData: vm.optionData,
                componentData: vm.componentData
            });
        }

        function init() {
            vm.syllabusData = locateData(syllabusCallback);
            vm.optionData = locateData(optionCallback);
            vm.componentData = locateData(componentCallback);
            if (vm.syllabusData) {
                if (vm.optionData) {
                    if (vm.componentData) {
                        // component level
                        vm.visible = false;
                        vm.editTooltip = "Edit component";
                    } else {
                        // option level
                        vm.visible = true;
                        vm.addTooltip = "Add new component";
                        vm.editTooltip = "Edit option";
                    }
                } else {
                    // syllabus level
                    vm.visible = true;
                    vm.addTooltip = "Add new option";
                    vm.editTooltip = "Edit syllabus";
                }
            } else {
                // error - something should be defined here, but nothing is.
            }
        }

        function locateData(callback) {
            $scope.curParent = $scope.$parent;
            while ($scope.curParent.$parent !== null) {
                if (callback($scope.curParent) !== undefined) {
                    return callback($scope.curParent);
                } else {
                    $scope.curParent = $scope.curParent.$parent;
                }
            }
        }

        function optionCallback(data) {
            return data.option;
        }

        function syllabusCallback(data) {
            return data.syllabus;
        }

        function viewStudentsCallback() {
            $scope.viewStudentsCallback({
                syllabusData: vm.syllabusData,
                optionData: vm.optionData,
                componentData: vm.componentData
            });
        }
    }
})();

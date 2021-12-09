/**
 * This is the LetterTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('LetterTypesEditorDirective')
        .controller('LetterTypesEditorController', LetterTypesEditorController);

    LetterTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'LetterType'];

    function LetterTypesEditorController($log, $uibModal, $scope, LetterType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editLetterTypes = editLetterTypes;
        vm.addLetterTypes = addLetterTypes;

        function loadLetterTypes() {
            LetterType.query().then(function(response) {
                $scope.letterTypes = response.data;
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editLetterTypes(letterTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/letter-types-editor/views/letter-types-editorDialog.html',
                controller: 'LetterTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    letterTypesEntity: function(LetterType) {
                        return LetterType.get(letterTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadLetterTypes();
            });
        }

        function addLetterTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/letter-types-editor/views/letter-types-editorDialog.html',
                controller: 'LetterTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    letterTypesEntity: function() {
                        var letterTypes = {};
                        return letterTypes;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadLetterTypes();
            });
        }

    }

})();

/**
 * This is the TextLookup Editor Controller, it is used to handle the TextLookup editor controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('TextLookupEditorDirective')
        .controller('TextLookupEditorController', TextLookupEditorController);

    TextLookupEditorController.$inject = ['$log', '$scope', '$uibModal', 'TextLookup'];

    function TextLookupEditorController($log, $scope, $uibModal, TextLookup) {
        /* jshint validthis:true */
        var vm = this;

        vm.editTextLookup = editTextLookup;

        //Private Interface

        function loadTextLookup() {
            TextLookup.query().then(function(response) {
                $log.info('II TextLookup Loaded');
                $scope.textLookups = response.data;
            }, function(response) {
                $log.error("Failed to load textLookups");
            });
        }

        function editTextLookup(id) {
            $log.log('TextLookupDetailsDirectiveController::editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/text-lookup-editor/views/text-lookup-editor-dialog.html',
                controller: 'TextLookupEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    textLookupEntity: function(TextLookup) {
                        return TextLookup.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadTextLookup(vm.textLookup.id);
            });
        }

    }

})();

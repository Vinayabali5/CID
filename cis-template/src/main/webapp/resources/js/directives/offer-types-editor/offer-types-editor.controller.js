/**
 * This is the OfferTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('OfferTypesEditorDirective')
        .controller('OfferTypesEditorController', OfferTypesEditorController);

    OfferTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'OfferType'];

    function OfferTypesEditorController($log, $uibModal, $scope, OfferType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editOfferTypes = editOfferTypes;
        vm.addOfferTypes = addOfferTypes;

        function loadOfferTypes() {
            OfferType.query().then(function(response) {
                $scope.offerTypes = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editOfferTypes(offerTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/offer-types-editor/views/offer-types-editorDialog.html',
                controller: 'OfferTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    offerTypesEntity: function(OfferType) {
                        return OfferType.get(offerTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadOfferTypes();
            });
        }

        function addOfferTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/offer-types-editor/views/offer-types-editorDialog.html',
                controller: 'OfferTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    offerTypesEntity: function() {
                        var offerTypes = {};
                        return offerTypes;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadOfferTypes();
            });
        }

    }

})();

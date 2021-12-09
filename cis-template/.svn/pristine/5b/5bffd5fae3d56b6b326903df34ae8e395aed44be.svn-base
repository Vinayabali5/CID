/**
 * This is the SpecialCategory Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('SpecialCategoriesEditorDirective')
        .controller('SpecialCategoriesEditorDialogController', SpecialCategoriesEditorDialogController);

    SpecialCategoriesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'SpecialCategory', 'specialCategoriesEntity'];

    function SpecialCategoriesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, SpecialCategory, specialCategoriesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.specialCategories = specialCategoriesEntity !== undefined ? specialCategoriesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('special-category-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.specialCategories.id) {
                SpecialCategory.save(vm.specialCategories, onSaveFinished);
            } else {
                if (vm.specialCategories.id !== null) {
                    SpecialCategory.create(vm.specialCategories, onSaveFinished);
                }
            }
        }

    }


})();

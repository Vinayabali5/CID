/**
 * This is the Letter Template Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('LetterTemplateEditorDirective')
        .controller('LetterTemplateEditorController', LetterTemplateEditorController);

    LetterTemplateEditorController.$inject = ['$uibModal', 'LetterTemplate'];

    function LetterTemplateEditorController($uibModal, LetterTemplate) {
        /* jshint validthis:true */
        var vm = this;

        vm.editLetterTemplate = editLetterTemplate;
        vm.addLetterTemplate = addLetterTemplate;

        function editLetterTemplate(id) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/letter-template-editor/views/letter-template-editorDialog.html',
                size: 'lg',
                controller: 'LetterTemplateEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    letterTemplateEntity: function(LetterTemplate) {
                        return LetterTemplate.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }
                }
            });

        }

        function addLetterTemplate() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/letter-template-editor/views/letter-template-editorDialog.html',
                size: 'lg',
                controller: 'LetterTemplateEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    letterTemplateEntity: function() {
                        var letterTemplate = {};
                        return letterTemplate;
                    }
                }
            });
        }

    }

})();

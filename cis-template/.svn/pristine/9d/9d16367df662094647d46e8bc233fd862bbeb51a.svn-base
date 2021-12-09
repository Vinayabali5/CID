/**
 * This is the OfferType Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 *  
 *   */
(function() {
    'use strict';

    angular
        .module('OfferTypesEditorDirective', ['EntityServices'])
        .directive('offerTypesEditor', offerTypesEditor);

    function offerTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                offerTypes: '=?',
                showActions: '=?'
            },
            controller: 'OfferTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/offer-types-editor/views/offer-types-editor.html',
        };

        return directive;

    }
})();

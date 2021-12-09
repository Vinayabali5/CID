/**
 * This is the ReferralReason Editor Directive definition.
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
        .module('ReferralReasonsEditorDirective', ['EntityServices'])
        .directive('referralReasonsEditor', referralReasonsEditor);

    function referralReasonsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                referralReasons: '=?',
                showActions: '=?'
            },
            controller: 'ReferralReasonsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/referral-reasons-editor/views/referral-reasons-editor.html',
        };

        return directive;

    }
})();

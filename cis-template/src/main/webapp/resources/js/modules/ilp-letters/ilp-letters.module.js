/**
 * This file defines the student records module for the CID system.
 */
(function() {
    'use strict';

    angular.module('cid.ilp-letters', [
        // External Dependencies
        'ui.router',
        'ui.bootstrap',
        'ui.bootstrap.tabs',

        // Internal Dependencies
        'cid.service.logger',
        'cid.app.variables',

        'LetterService',
        'ILPLetterEditorDirective',

    ]);

})();

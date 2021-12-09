/**
 * This is the main module definition for the site.
 *
 *  Applied Styles: [Y001, Y002, Y010, Y021]
 *
 * @type Module
 */
(function() {
    'use strict';

    angular
        .module('cid.exams.generate-edi', [
            'ui.router',
            'ui.bootstrap',
            'ngResource',
            'ExamSeriesService',
            'cid.exams.EDIGeneratorTableDirective'
        ]);
})();

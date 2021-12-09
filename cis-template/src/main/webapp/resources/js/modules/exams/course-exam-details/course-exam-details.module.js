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
        .module('cid.exams.course-exam-details', [
            'ui.router',
            'ui.bootstrap',
            'ui.bootstrap.tabs',
            'ngResource',
            'SyllabusDetailsDirective'
        ]);
})();

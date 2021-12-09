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
        .module('cid.site', [
            'ui.router',
            'ui.bootstrap',
            'ngResource',
            'cid.service.logger'
        ]);

})();

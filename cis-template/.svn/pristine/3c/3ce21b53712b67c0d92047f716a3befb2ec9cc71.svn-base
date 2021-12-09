(function() {
    'use strict';

    angular
        .module('cid.service.logger', [
            'ui-notification',
            'cid.app.constants',
        ])
        .factory('Logger', LoggerService);

    LoggerService.$inject = ['$log', 'Notification', 'GLOBAL'];

    function LoggerService($log, Notification, GLOBAL) {
        var service = {};

        service.log = log;
        service.info = log;
        service.warn = warn;
        service.error = error;
        service.debug = debug;

        return service;

        // Private Interface

        /**
         * This method is for logging normal messages
         *
         * @param  {String} message The message to be displayed
         * @param  {bool} display This determines if the message is displayed in the UI
         */
        function log(message, display) {
            if (display === true) {
                Notification(message);
            }
            $log.info(message);
        }

        /**
         * This method is for logging normal messages
         *
         * @param  {String} message The message to be displayed
         * @param  {bool} display This determines if the message is displayed in the UI
         */
        function warn(message, display) {
            if (display === true) {
                Notification(message, 'warning');
            }
            $log.warn(message);
        }

        /**
         * This method is for logging error messages
         *
         * @param  {String} message The message to be displayed
         * @param  {bool} display This determines if the message is displayed in the UI
         */
        function error(message, display) {
            if (display === true) {
                Notification(message, 'error');
            }
            $log.error(message);
        }

        /**
         * This method is for logging debug messages
         *
         * @param  {String} message The message to be displayed
         */
        function debug(message) {
            if (GLOBAL.debug === true) {
                $log.debug(message);
            }
        }

    }

})();

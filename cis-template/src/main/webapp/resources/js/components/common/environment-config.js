/**
 * This module is used to set up the applications environment. This will load a configuration file to initiate the
 * applications default settings.
 *
 * Applied Style: [Y001, Y002, Y010, Y020, Y024]
 *
 * @author Michael Horgan
 */

(function() {
    angular
        .module('cid.app.environment', [])
        .provider("EnvConfig", environmentConfigurationProvider);

    function environmentConfigurationProvider() {
        var envConfig = {};

        this.$get = loadConfiguration;

        function loadConfiguration() {
            var q = jQuery.ajax({
                type: 'GET',
                url: '/config.json',
                cache: false,
                async: false,
                contentType: 'application/json',
                dataType: 'json'
            });
            if (q.status === 200) {
                angular.extend(envConfig, angular.fromJson(q.responseText));
            }
            return envConfig;
        }
    }
})();

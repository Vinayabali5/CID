(function() {

    angular
        .module('cid.app.constants', ['cid.app.environment'])
        .factory('GLOBAL', GlobalVariablesFactory);

    GlobalVariablesFactory.$inject = ['EnvConfig'];

    function GlobalVariablesFactory(EnvConfig) {
        return {
            DEBUG: (EnvConfig.debugMode === "true"),
            API: (EnvConfig.apiUrl !== undefined ? EnvConfig.apiUrl : '') + "/api",
            LOGIN: (EnvConfig.apiUrl !== undefined ? EnvConfig.apiUrl : '') + "/api/login",
            USER: (EnvConfig.apiUrl !== undefined ? EnvConfig.apiUrl : '') + "/api/user",
            REPORT_URL: EnvConfig.reportUrl,
            STUDENT_IMAGES_URL: EnvConfig.studentImagesUrl,
            PROFILE: EnvConfig.profile,
            DEFAULTS: {
                REPORT_FORMAT: 'PDF',
                REPORT_TOOLBAR: true
            },
            ENV: EnvConfig,
        };
    }
})();

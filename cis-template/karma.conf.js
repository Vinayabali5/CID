// karma.conf.js
module.exports = function(config) {
    config.set({
        preprocessors: {
            '**/*.html': ['ng-html2js']
        },
        basePath: 'src/main/webapp/resources/',
        frameworks: ['bower', 'jasmine'],
        autoWatch: true,
        browsers: ['Chrome'], //,'Firefox'],
        files: [
            'js/components/**/*.js',
            'js/app.dependencies.js',
            'js/app.config.js',
            'js/app.js',
            'js/**/*.directive.js',
            'js/**/*.module.js',
            'js/**/*.js',
            'tests/test.helpers.js',
            'tests/**/*.spec.js',
            '**/*.html',
        ],
        bowerPackages: [
            'jquery',
            'bootstrap',
            'ngstorage',
            'angular',
            'angular-mocks',
            'angular-resource',
            'angular-cookies',
            'angular-ui-router',
            'angular-bootstrap',
            'angular-tablesort',
            'angular-ui-notification',
            'bootbox',
        ],
        logLevel: config.LOG_INFO,
        ngHtml2JsPreprocessor: {
            stripPrefix: '',
            prependPrefix: 'served/',
            cacheIdFromPath: function(filepath) {
                return filepath;
            },
            moduleName: 'html'
        },
        debug: true,
    });
};

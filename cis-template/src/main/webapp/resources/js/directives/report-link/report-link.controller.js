/**
 * This is the Report Link Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('ReportLinkDirective')
        .controller('ReportLinkDirectiveController', ReportLinkDirectiveController);

    ReportLinkDirectiveController.$inject = ['$log', '$window', 'GLOBAL', 'APP'];

    function ReportLinkDirectiveController($log, $window, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;
        var DEBUG = GLOBAL.DEBUG;
        var baseUrl = GLOBAL.REPORT_URL;
        var year = APP.getYear();

        vm.reportToolbar = GLOBAL.DEFAULTS.REPORT_TOOLBAR;
        vm.reportUrl = genrerateReportUrl;

        vm.loadReport = loadReport;


        // Private Interface
        function loadReport() {
            var url = genrerateReportUrl();
            if (DEBUG === true) $log.info("II Loading report: " + vm.reportPath + " :: URL " + url);
            $window.open(url);
        }

        function genrerateReportUrl() {
            var defaultProperties = "&rc:toolbar=" + vm.reportToolbar;
            if (vm.reportFormat !== undefined) {
                defaultProperties += "&rs:Format=" + vm.reportFormat;
            }
            if (vm.showParams !== undefined) {
                defaultProperties += "&rc:Parameters=" + vm.showParams;
            }
            var params = '';
            if (vm.reportParams) {
                switch (typeof vm.reportParams) {
                    case "string":
                        var paramArr = vm.reportParams.split('&');
                        angular.forEach(paramArr, function(it) {
                            var arr = it.split('=');
                            params += arr[0] + '=' + encodeURIComponent(arr[1]) + '&';
                        });
                        params = params.length !== 0 ? params.slice(0, -1) : params;
                        break;
                    case "object":
                        params = Object.keys(vm.reportParams).map(function(key) {
                            return key[0].toUpperCase() + key.substring(1) + '=' + encodeURIComponent(vm.reportParams[key]);
                        }).join('&');
                        if (DEBUG === true) $log.info(params);
                        break;
                    default:
                        params = '';
                        break;
                }
            }
            if (params.length !== 0) {
                params = '&' + params;
            }
            var url = baseUrl + '?' + encodeURIComponent(vm.reportPath) + defaultProperties + params;
            if (vm.includeYear) {
                if (vm.includeYear === true) {
                    year = APP.getYear();
                    url = url + '&AcademicYear=' + year.id;
                }
            }
            if (vm.previousYear) {
                if (vm.previousYear === true) {
                    url = url + '&AcademicYear=' + (year.id - 1);
                }
            }
            return url;
        }

    }


})();

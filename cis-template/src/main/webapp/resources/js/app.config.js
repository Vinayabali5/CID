(function() {
    angular
        .module('cid')
        .config(configCors)
        .config(configNoCache)
        .config(configureTableSortModule)

    ;

    configCors.$inject = ['$httpProvider'];
    configNoCache.$inject = ['$httpProvider'];
    configureTableSortModule.$inject = ['tableSortConfigProvider'];

    /**
     * Setting up the CORS (Cross-Origin Resource Sharing) setting for use with the API
     */
    function configCors($httpProvider) {
        //	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        $httpProvider.defaults.headers.post["Content-Type"] = "application/json";
        //    $httpProvider.defaults.withCredentials = true;
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }

    // Disable XHR request chaching (IE Fix)
    function configNoCache($httpProvider) {
        $httpProvider.defaults.headers.common['Cache-Control'] = 'no-cache';
    }

    /**
     * This function is used to configure the table sort module with default filtering and pagination templates.
     */
    function configureTableSortModule(tableSortConfigProvider) {
        var filterString = '<div class="row">';
        filterString += '<div class="col-sm-4 col-md-3 col-sm-offset-8 col-md-offset-9">';
        filterString += '<div class="form-group has-feedback">';
        filterString += '<input type="search" class="form-control input-sm" placeholder="Filter {{ITEM_NAME_PLURAL}}" ng-model="FILTER_STRING"/>';
        filterString += '<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>';
        filterString += '</div>';
        filterString += '</div>';
        filterString += '</div>';
        tableSortConfigProvider.filterTemplate = filterString;
        /*
        // This pagination string is not working correctly as there are no pagination buttons
        var pagerString = '<div class="text-right">';
        pagerString += '<small class="text-muted">Showing {{CURRENT_PAGE_RANGE}} {{FILTERED_COUNT === 0 ? "" : "of"}} ';
        pagerString += '<span ng-if="FILTERED_COUNT === TOTAL_COUNT">{{TOTAL_COUNT | number}} {{TOTAL_COUNT === 1 ? ITEM_NAME_SINGULAR : ITEM_NAME_PLURAL}}</span>';
        pagerString += '<span ng-if="FILTERED_COUNT !== TOTAL_COUNT">{{FILTERED_COUNT | number}} {{FILTERED_COUNT === 1 ? ITEM_NAME_SINGULAR : ITEM_NAME_PLURAL}} (filtered from {{TOTAL_COUNT | number}})</span>';
        pagerString += '</small>&nbsp;';
        pagerString += '<uib-pagination style="vertical-align:middle;" ng-if="ITEMS_PER_PAGE < TOTAL_COUNT" ng-model="CURRENT_PAGE_NUMBER" ';
        pagerString += 'total-items="FILTERED_COUNT" items-per-page="ITEMS_PER_PAGE" max-size="5" force-ellipses="true"></uib-pagination>&nbsp;';
        pagerString += '<div class="form-group" style="display:inline-block;">';
        pagerString += '<select class="form-control input-sm" ng-model="ITEMS_PER_PAGE" ng-options="opt as (opt + \' per page\') for opt in PER_PAGE_OPTIONS"></select>';
        pagerString += '</div>';
        pagerString += '</div>';
        tableSortConfigProvider.paginationTemplate = pagerString;
        */
    }


})();

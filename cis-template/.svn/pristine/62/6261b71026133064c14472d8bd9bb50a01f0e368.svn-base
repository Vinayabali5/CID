(function() {
    'use strict';

    describe('SchoolReportStatusService', function() {

        var httpBackend;
        var schoolReportStatus;

        beforeEach(module('SchoolReportStatusService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/schoolReportStatuses/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme school'
            }]);
            httpBackend.whenGET('/api/schoolReportStatuses/1').respond(200, {});
            schoolReportStatus = $injector.get('SchoolReportStatus');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the schoolReportStatuss', function() {
            httpBackend.expectGET('/api/schoolReportStatuses/');
            schoolReportStatus.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific schoolReportStatus', function() {
            httpBackend.expectGET('/api/schoolReportStatuses/1');
            schoolReportStatus.get(1);
            httpBackend.flush();
        });
    });

})();

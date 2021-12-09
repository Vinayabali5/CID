(function() {
    'use strict';

    describe('ReportingPeriodService', function() {

        var httpBackend;
        var reportingPeriod;

        beforeEach(module('ReportingPeriodService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/reportingPeriods/').respond(200, [{
                id: 1,
                name: '1'
            }]);
            httpBackend.whenGET('/api/reportingPeriods/1').respond(200, {});
            httpBackend.whenPOST('/api/reportingPeriods/').respond(201, {});
            httpBackend.whenPUT('/api/reportingPeriods/1').respond(200, {});
            reportingPeriod = $injector.get('ReportingPeriod');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the reportingPeriods', function() {
            httpBackend.expectGET('/api/reportingPeriods/');
            reportingPeriod.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific reportingPeriod', function() {
            httpBackend.expectGET('/api/reportingPeriods/1');
            reportingPeriod.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new reportingPeriod', inject(function($http) {
            httpBackend.expectPOST('/api/reportingPeriods/', {
                name: '1'
            });
            reportingPeriod.create({
                name: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/reportingPeriods/1', {
                id: 1,
                name: '1'
            });
            reportingPeriod.save({
                id: 1,
                name: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

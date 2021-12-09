(function() {
    'use strict';

    describe('PeriodService', function() {

        var httpBackend;
        var period;

        beforeEach(module('PeriodService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/periods/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme note'
            }]);
            httpBackend.whenGET('/api/periods/1').respond(200, {});
            httpBackend.whenPOST('/api/periods/').respond(201, {});
            httpBackend.whenPUT('/api/periods/1').respond(200, {});
            period = $injector.get('Period');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the periods', function() {
            httpBackend.expectGET('/api/periods/');
            period.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific period', function() {
            httpBackend.expectGET('/api/periods/1');
            period.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new period', inject(function($http) {
            httpBackend.expectPOST('/api/periods/', {
                code: '1'
            });
            period.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/periods/1', {
                id: 1,
                code: '1',
                description: 'Programme note'
            });
            period.save({
                id: 1,
                code: '1',
                description: 'Programme note'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

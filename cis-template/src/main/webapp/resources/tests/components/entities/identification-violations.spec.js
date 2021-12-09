(function() {
    'use strict';

    describe('IdentificationViolationService', function() {

        var httpBackend;
        var identificationViolation;

        beforeEach(module('IdentificationViolationService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/id-violations/').respond(200, [{
                id: 1,
                lost: true,
                printed: true
            }]);
            httpBackend.whenGET('/api/id-violations/1').respond(200, {});
            httpBackend.whenPOST('/api/id-violations/').respond(201, {});
            httpBackend.whenPUT('/api/id-violations/1').respond(200, {});
            identificationViolation = $injector.get('IdentificationViolation');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the identificationViolations', function() {
            httpBackend.expectGET('/api/id-violations/');
            identificationViolation.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific identificationViolation', function() {
            httpBackend.expectGET('/api/id-violations/1');
            identificationViolation.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new identificationViolation', inject(function($http) {
            httpBackend.expectPOST('/api/id-violations/', {
                lost: true
            });
            identificationViolation.create({
                lost: true
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing schooltype', function() {
            httpBackend.expectPUT('/api/id-violations/1');
            identificationViolation.save({
                id: 1,
                lost: true,
                printed: true
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

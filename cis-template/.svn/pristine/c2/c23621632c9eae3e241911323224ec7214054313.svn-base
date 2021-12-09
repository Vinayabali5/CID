(function() {
    'use strict';

    describe('DestinationService', function() {

        var httpBackend;
        var destination;

        beforeEach(module('DestinationService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/destinations/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Destination A',
                shortDescription: 'Dest'
            }]);
            httpBackend.whenGET('/api/destinations/1').respond(200, {});
            httpBackend.whenPOST('/api/destinations/').respond(201, {});
            httpBackend.whenPUT('/api/destinations/2').respond(200, {});
            destination = $injector.get('Destination');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the destinations', function() {
            httpBackend.expectGET('/api/destinations/');
            destination.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific destination', function() {
            httpBackend.expectGET('/api/destinations/1');
            destination.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new destination', inject(function($http) {
            httpBackend.expectPOST('/api/destinations/', {
                code: '1',
                description: 'Destination A',
                shortDescription: 'Dest'
            });
            destination.create({
                code: '1',
                description: 'Destination A',
                shortDescription: 'Dest'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing destination', function() {
            httpBackend.expectPUT('/api/destinations/2', {
                id: 2,
                code: '1',
                description: 'Destination A',
                shortDescription: 'Dest'
            });
            destination.save({
                id: 2,
                code: '1',
                description: 'Destination A',
                shortDescription: 'Dest'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

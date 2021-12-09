(function() {
    'use strict';

    describe('OfferTypeService', function() {

        var httpBackend;
        var offerType;

        beforeEach(module('OfferTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/offerTypes/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme offer'
            }]);
            httpBackend.whenGET('/api/offerTypes/1').respond(200, {});
            httpBackend.whenPOST('/api/offerTypes/').respond(201, {
                id: 1,
                code: '1',
                description: 'Programme offer'
            });
            httpBackend.whenPUT('/api/offerTypes/1').respond(200, {
                id: 1,
                code: '1',
                description: 'Programme offer'
            });
            offerType = $injector.get('OfferType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the offerTypes', function() {
            httpBackend.expectGET('/api/offerTypes/');
            offerType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific offerType', function() {
            httpBackend.expectGET('/api/offerTypes/1');
            offerType.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new offerType', inject(function($http) {
            httpBackend.expectPOST('/api/offerTypes/', {
                code: '1'
            });
            offerType.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing offertype', function() {
            httpBackend.expectPUT('/api/offerTypes/1', {
                id: 1,
                code: '1',
                description: 'Programme offer'
            });
            offerType.save({
                id: 1,
                code: '1',
                description: 'Programme offer'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

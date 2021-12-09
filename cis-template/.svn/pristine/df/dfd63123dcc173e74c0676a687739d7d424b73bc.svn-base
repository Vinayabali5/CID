(function() {
    'use strict';

    describe('AddressService', function() {

        var httpBackend;
        var address;

        beforeEach(module('AddressService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/addresses/').respond(200, [{
                id: 1,
                line1: 'Flat D'
            }]);
            httpBackend.whenGET('/api/addresses/1').respond(200, {});
            httpBackend.whenPOST('/api/addresses/').respond(201, {});
            httpBackend.whenPUT('/api/addresses/1').respond(200, {});
            address = $injector.get('Address');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the addresses', function() {
            httpBackend.expectGET('/api/addresses/');
            address.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific address', function() {
            httpBackend.expectGET('/api/addresses/1');
            address.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new address', inject(function($http) {
            httpBackend.expectPOST('/api/addresses/', {
                line1: 'Flat E',
                line2: 'Cane Hill'
            });
            address.create({
                line1: 'Flat E',
                line2: 'Cane Hill'
            }).then(function(response) {
                expect(response).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing address', function() {
            httpBackend.expectPUT('/api/addresses/1', {
                id: 1,
                line1: 'Flat E',
                line2: 'Cane Hill'
            });
            address.save({
                id: 1,
                line1: 'Flat E',
                line2: 'Cane Hill'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });

    });

})();

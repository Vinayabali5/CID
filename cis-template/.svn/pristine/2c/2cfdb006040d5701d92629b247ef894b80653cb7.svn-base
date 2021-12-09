(function() {
    'use strict';

    describe('ContactService', function() {

        var httpBackend;
        var contact;

        beforeEach(module('ContactService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/contacts/').respond(200, [{
                id: 1,
                firstName: 'vinaya',
                surname: 'bali'
            }]);
            httpBackend.whenGET('/api/contacts/10').respond(200, {});
            httpBackend.whenGET('/api/contacts/1').respond(200, {});
            httpBackend.whenGET('/api/contacts/10/contacts').respond(200, {});
            httpBackend.whenPOST('/api/contacts/').respond(201, {});
            httpBackend.whenDELETE('/api/contacts/1').respond(200, {});
            httpBackend.whenPUT('/api/contacts/2').respond(200, {});
            contact = $injector.get('Contact');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the contacts', function() {
            httpBackend.expectGET('/api/contacts/');
            contact.query();
            httpBackend.flush();
        });

        it('should GET from api to retrieve a specific contact', function() {
            httpBackend.expectGET('/api/contacts/10');
            contact.search(10);
            httpBackend.flush();
        });

        it('should GET from api to retrieve a specific contact', function() {
            httpBackend.expectGET('/api/contacts/1');
            contact.get(1);
            httpBackend.flush();
        });

        it('should GET from api to retrieve a specific contact', function() {
            httpBackend.expectGET('/api/contacts/10/contacts');
            contact.contacts(10);
            httpBackend.flush();
        });

        it('should POST to api to create a new contact', inject(function($http) {
            httpBackend.expectPOST('/api/contacts/', {
                firstName: 'vinaya'
            });
            contact.create({
                firstName: 'vinaya'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing contact', function() {
            httpBackend.expectPUT('/api/contacts/2', {
                id: 2,
                firstName: 'vinaya',
                surname: 'bali'
            });
            contact.save({
                id: 2,
                firstName: 'vinaya',
                surname: 'bali'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });

        it('should DELETE from api to delete specific contact', function() {
            httpBackend.expectDELETE('/api/contacts/1');
            contact.delete(1);
            httpBackend.flush();
        });

    });

})();

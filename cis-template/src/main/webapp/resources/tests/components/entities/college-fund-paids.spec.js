(function() {
    'use strict';

    describe('CollegeFundPaidService', function() {

        var httpBackend;
        var collegeFundPaid;

        beforeEach(module('CollegeFundPaidService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/collegeFundPaids/').respond(200, [{
                id: 1,
                collegeFundPaid: 'Dont Know'
            }]);
            httpBackend.whenGET('/api/collegeFundPaids/1').respond(200, {});
            httpBackend.whenPOST('/api/collegeFundPaids/').respond(201, {});
            httpBackend.whenPUT('/api/collegeFundPaids/2').respond(200, {});
            collegeFundPaid = $injector.get('CollegeFundPaid');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the collegeFundPaids', function() {
            httpBackend.expectGET('/api/collegeFundPaids/');
            collegeFundPaid.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific collegeFundPaid', function() {
            httpBackend.expectGET('/api/collegeFundPaids/1');
            collegeFundPaid.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new collegeFundPaid', inject(function($http) {
            httpBackend.expectPOST('/api/collegeFundPaids/', {
                collegeFundPaid: 'Yes'
            });
            collegeFundPaid.create({
                collegeFundPaid: 'Yes'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing collegeFundPaid', function() {
            httpBackend.expectPUT('/api/collegeFundPaids/2', {
                id: 2,
                collegeFundPaid: 'Yes'
            });
            collegeFundPaid.save({
                id: 2,
                collegeFundPaid: 'Yes'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

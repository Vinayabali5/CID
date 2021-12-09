(function() {
    'use strict';

    describe('StaffService', function() {

        var httpBackend;
        var staff;

        beforeEach(module('StaffService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/staff/1').respond(200, {});
            httpBackend.whenPOST('/api/staff/').respond(201, {
                id: 2,
                initials: '1',
                knownAs: 'vinaya',
                networkLogin: '/'
            });
            httpBackend.whenPUT('/api/staff/2').respond(200, {});
            staff = $injector.get('Staff');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });


        it('should GET from api to retrieve a specific staff', function() {
            httpBackend.expectGET('/api/staff/1');
            staff.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new staff', inject(function($http) {
            httpBackend.expectPOST('/api/staff/', {
                initials: '1'
            });
            staff.create({
                initials: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing staff', function() {
            httpBackend.expectPUT('/api/staff/2', {
                id: 2,
                initials: '1',
                knownAs: 'vinaya',
                networkLogin: '/'
            });
            staff.save({
                id: 2,
                initials: '1',
                knownAs: 'vinaya',
                networkLogin: '/'
            }, function() {}).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

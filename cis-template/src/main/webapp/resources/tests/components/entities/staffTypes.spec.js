(function() {
    'use strict';

    describe('StaffTypeService', function() {

        var httpBackend;
        var staffType;

        beforeEach(module('StaffTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/staffTypes/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Temporary',
                needInitials: '/'
            }]);
            httpBackend.whenGET('/api/staffTypes/1').respond(200, {});
            httpBackend.whenPOST('/api/staffTypes/').respond(201, {});
            httpBackend.whenPUT('/api/staffTypes/2').respond(200, {});
            staffType = $injector.get('StaffType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the staffTypes', function() {
            httpBackend.expectGET('/api/staffTypes/');
            staffType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific staffType', function() {
            httpBackend.expectGET('/api/staffTypes/1');
            staffType.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new staffType', inject(function($http) {
            httpBackend.expectPOST('/api/staffTypes/', {
                code: '1'
            });
            staffType.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing staffType', function() {
            httpBackend.expectPUT('/api/staffTypes/2', {
                id: 2,
                code: '1',
                description: 'Permanent',
                needInitials: '/'
            });
            staffType.save({
                id: 2,
                code: '1',
                description: 'Permanent',
                needInitials: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

(function() {
    'use strict';

    describe('YearGroupService', function() {

        var httpBackend;
        var yearGroup;

        beforeEach(module('YearGroupService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/yearGroups/').respond(200, [{
                id: 1,
                code: '1',
                description: 'maths'
            }]);
            httpBackend.whenGET('/api/yearGroups/1').respond(200, {});
            httpBackend.whenPOST('/api/yearGroups/').respond(201, {});
            httpBackend.whenPUT('/api/yearGroups/1').respond(200, {});
            yearGroup = $injector.get('YearGroup');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the yearGroups', function() {
            httpBackend.expectGET('/api/yearGroups/');
            yearGroup.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific yearGroup', function() {
            httpBackend.expectGET('/api/yearGroups/1');
            yearGroup.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new yearGroup', inject(function($http) {
            httpBackend.expectPOST('/api/yearGroups/', {
                code: '1'
            });
            yearGroup.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/yearGroups/1', {
                id: 1,
                code: '1',
                description: 'maths'
            });
            yearGroup.save({
                id: 1,
                code: '1',
                description: 'maths'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

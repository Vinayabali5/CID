(function() {
    'use strict';

    describe('EthnicityService', function() {

        var httpBackend;
        var ethnicity;

        beforeEach(module('EthnicityService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/ethnicities/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Indian',
                shortDescription: 'IN'
            }]);
            httpBackend.whenGET('/api/ethnicities/1').respond(200, {});
            httpBackend.whenPOST('/api/ethnicities/').respond(201, {});
            httpBackend.whenPUT('/api/ethnicities/1').respond(200, {});
            ethnicity = $injector.get('Ethnicity');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the ethnicitys', function() {
            httpBackend.expectGET('/api/ethnicities/');
            ethnicity.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific ethnicity', function() {
            httpBackend.expectGET('/api/ethnicities/1');
            ethnicity.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new ethnicity', inject(function($http) {
            httpBackend.expectPOST('/api/ethnicities/', {
                code: '1',
                description: 'Indian',
                shortDescription: 'IN'
            });
            ethnicity.create({
                code: '1',
                description: 'Indian',
                shortDescription: 'IN'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/ethnicities/1', {
                id: 1,
                code: '1',
                description: 'Indian',
                shortDescription: 'IN'
            });
            ethnicity.save({
                id: 1,
                code: '1',
                description: 'Indian',
                shortDescription: 'IN'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

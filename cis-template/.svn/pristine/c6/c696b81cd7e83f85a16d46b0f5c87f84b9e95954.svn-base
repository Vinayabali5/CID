(function() {
    'use strict';

    describe('NationalityService', function() {

        var httpBackend;
        var nationality;

        beforeEach(module('NationalityService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/nationalities/').respond(200, [{
                id: 1,
                name: '2',
                description: 'Indian',
                htmlColour: '/'
            }]);
            httpBackend.whenGET('/api/nationalities/1').respond(200, {});
            httpBackend.whenPOST('/api/nationalities/').respond(201, {
                id: 2,
                name: '1',
                description: 'British',
                htmlColour: '/'
            });
            httpBackend.whenPUT('/api/nationalities/2').respond(200, {
                id: 2,
                name: '1',
                description: 'British',
                htmlColour: '/'
            });
            nationality = $injector.get('Nationality');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the nationalitys', function() {
            httpBackend.expectGET('/api/nationalities/');
            nationality.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific nationality', function() {
            httpBackend.expectGET('/api/nationalities/1');
            nationality.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new nationality', inject(function($http) {
            httpBackend.expectPOST('/api/nationalities/', {
                name: '1'
            });
            nationality.create({
                name: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing nationality', function() {
            httpBackend.expectPUT('/api/nationalities/2', {
                id: 2,
                name: '1',
                description: 'British',
                htmlColour: '/'
            });
            nationality.save({
                id: 2,
                name: '1',
                description: 'British',
                htmlColour: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

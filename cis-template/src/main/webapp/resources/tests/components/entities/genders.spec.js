(function() {
    'use strict';

    describe('GenderService', function() {

        var httpBackend;
        var gender;

        beforeEach(module('GenderService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/genders/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Male',
                htmlColour: '/'
            }]);
            httpBackend.whenGET('/api/genders/1').respond(200, {});
            httpBackend.whenPOST('/api/genders/').respond(201, {});
            httpBackend.whenPUT('/api/genders/2').respond(200, {});
            gender = $injector.get('Gender');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the genders', function() {
            httpBackend.expectGET('/api/genders/');
            gender.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific gender', function() {
            httpBackend.expectGET('/api/genders/1');
            gender.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new gender', inject(function($http) {
            httpBackend.expectPOST('/api/genders/', {
                code: '1'
            });
            gender.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing gender', function() {
            httpBackend.expectPUT('/api/genders/2', {
                id: 2,
                code: '1',
                description: 'Female',
                htmlColour: '/'
            });
            gender.save({
                id: 2,
                code: '1',
                description: 'Female',
                htmlColour: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

(function() {
    'use strict';

    describe('FacultyService', function() {

        var httpBackend;
        var faculty;

        beforeEach(module('FacultyService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/faculties/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Faculty B',
                htmlColour: '/'
            }]);
            httpBackend.whenGET('/api/faculties/1').respond(200, {});
            httpBackend.whenPOST('/api/faculties/').respond(201, {});
            httpBackend.whenPUT('/api/faculties/2').respond(200, {});
            faculty = $injector.get('Faculty');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the facultys', function() {
            httpBackend.expectGET('/api/faculties/');
            faculty.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific faculty', function() {
            httpBackend.expectGET('/api/faculties/1');
            faculty.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new faculty', inject(function($http) {
            httpBackend.expectPOST('/api/faculties/', {
                code: '1'
            });
            faculty.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing faculty', function() {
            httpBackend.expectPUT('/api/faculties/2', {
                id: 2,
                code: '1',
                description: 'Faculty A',
                htmlColour: '/'
            });
            faculty.save({
                id: 2,
                code: '1',
                description: 'Faculty A',
                htmlColour: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

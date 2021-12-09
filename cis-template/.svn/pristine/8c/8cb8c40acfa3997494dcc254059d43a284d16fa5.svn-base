(function() {
    'use strict';

    describe('TutorGroupService', function() {

        var httpBackend;
        var tutorGroup;

        beforeEach(module('TutorGroupService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/tutorGroups/').respond(200, [{
                id: 1,
                code: '1',
                description: 'maths'
            }]);
            httpBackend.whenGET('/api/tutorGroups/1').respond(200, {});
            httpBackend.whenPOST('/api/tutorGroups/').respond(201, {});
            httpBackend.whenPUT('/api/tutorGroups/1').respond(200, {});
            tutorGroup = $injector.get('TutorGroup');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the tutorGroups', function() {
            httpBackend.expectGET('/api/tutorGroups/');
            tutorGroup.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific tutorGroup', function() {
            httpBackend.expectGET('/api/tutorGroups/1');
            tutorGroup.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new tutorGroup', inject(function($http) {
            httpBackend.expectPOST('/api/tutorGroups/', {
                code: '1'
            });
            tutorGroup.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/tutorGroups/1', {
                id: 1,
                code: '1',
                description: 'maths'
            });
            tutorGroup.save({
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

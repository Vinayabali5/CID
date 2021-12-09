(function() {
    'use strict';

    describe('EnrolmentService', function() {

        var httpBackend;
        var enrolment;

        beforeEach(module('EnrolmentService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/enrolments/').respond(200, [{
                id: 1,
                enrolmentId: 2,
                aimTypeId: 4,
                courseGroupId: 4,
                courseId: 5,
                grade: 'A',
                ilr: true,
                notes: "Entered"
            }]);
            httpBackend.whenGET('/api/enrolments/1').respond(200, {});
            httpBackend.whenPOST('/api/enrolments/').respond(201, {});
            httpBackend.whenPUT('/api/enrolments/2').respond(200, {});
            enrolment = $injector.get('Enrolment');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the enrolments', function() {
            httpBackend.expectGET('/api/enrolments/');
            enrolment.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific enrolment', function() {
            httpBackend.expectGET('/api/enrolments/1');
            enrolment.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new enrolment', inject(function($http) {
            httpBackend.expectPOST('/api/enrolments/', {
                aimTypeId: 4,
                courseGroupId: 4,
                courseId: 5,
                grade: 'A',
                ilr: true,
                notes: "Entered"
            });
            enrolment.create({
                aimTypeId: 4,
                courseGroupId: 4,
                courseId: 5,
                grade: 'A',
                ilr: true,
                notes: "Entered"
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing enrolment', function() {
            httpBackend.expectPUT('/api/enrolments/2', {
                id: 2,
                enrolmentId: 2,
                aimTypeId: 4,
                courseGroupId: 4,
                courseId: 5,
                grade: 'A',
                ilr: true,
                notes: "Entered"
            });
            enrolment.save({
                id: 2,
                enrolmentId: 2,
                aimTypeId: 4,
                courseGroupId: 4,
                courseId: 5,
                grade: 'A',
                ilr: true,
                notes: "Entered"
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

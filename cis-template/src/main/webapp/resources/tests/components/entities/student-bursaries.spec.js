(function() {
    'use strict';

    describe('StudentBursaryService', function() {

        var httpBackend;
        var studentBursary;

        beforeEach(module('StudentBursaryService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/students/').respond(200, [{
                db: true,
                freeMealsEligibilty: true,
                gb: true,
                receivingFreeMeals: true,
                studentId: 17001,
                yearId: 18
            }]);
            httpBackend.whenGET('/api/students/17001/bursary').respond(200, {});
            httpBackend.whenPUT('/api/students/17001/bursary').respond(200, {});
            studentBursary = $injector.get('StudentBursary');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the studentBursarys', function() {
            httpBackend.expectGET('/api/students/');
            studentBursary.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific studentBursary', function() {
            httpBackend.expectGET('/api/students/17001/bursary');
            studentBursary.get(17001);
            httpBackend.flush();
        });

        it('should PUT to api to update an existing studentBursary', function() {
            httpBackend.expectPUT('/api/students/17001/bursary', {
                db: true,
                freeMealsEligibilty: true,
                gb: true,
                receivingFreeMeals: true,
                studentId: 17001,
                yearId: 18
            });
            studentBursary.save({
                db: true,
                freeMealsEligibilty: true,
                gb: true,
                receivingFreeMeals: true,
                studentId: 17001,
                yearId: 18
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

(function() {
    'use strict';

    describe('CollegeFundPaymentService', function() {

        var httpBackend;
        var collegeFundPayment;

        beforeEach(module('CollegeFundPaymentService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/').respond(200, [{
                id: 1,
                amount: 12,
                cash: true,
                chequeDate: "30/04/2018",
                giftAid: true,
                payee: "vinaya",
                paymentDate: "31/04/2018",
                studentId: 17001
            }]);
            httpBackend.whenGET('/api/collegeFundPayments/1').respond(200, {});
            httpBackend.whenGET('/api/students/17001/collegeFundPayments').respond(200, {});
            httpBackend.whenPOST('/api/collegeFundPayments').respond(201, {});
            httpBackend.whenPUT('/api/collegeFundPayments/2').respond(200, {});
            collegeFundPayment = $injector.get('CollegeFundPayment');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the collegeFundPayments', function() {
            httpBackend.expectGET('/api/');
            collegeFundPayment.query();
            httpBackend.flush();
        });

        it('should GET from api to retrieve a specific collegeFundPayment by studentId', function() {
            httpBackend.expectGET('/api/students/17001/collegeFundPayments');
            collegeFundPayment.getByStudent(17001);
            httpBackend.flush();
        });

        it('should GET from api to retrieve a specific collegeFundPayment', function() {
            httpBackend.expectGET('/api/collegeFundPayments/1');
            collegeFundPayment.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new collegeFundPayment', inject(function($http) {
            httpBackend.expectPOST('/api/collegeFundPayments', {
                amount: 12,
                studentId: 17001
            });
            collegeFundPayment.create({
                amount: 12,
                studentId: 17001
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing collegeFundPayment', function() {
            httpBackend.expectPUT('/api/collegeFundPayments/2', {
                id: 2,
                amount: 12,
                cash: true,
                chequeDate: "30/04/2018",
                giftAid: true,
                payee: "vinaya",
                paymentDate: "31/04/2018",
                studentId: 17001
            });
            collegeFundPayment.save({
                id: 2,
                amount: 12,
                cash: true,
                chequeDate: "30/04/2018",
                giftAid: true,
                payee: "vinaya",
                paymentDate: "31/04/2018",
                studentId: 17001
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

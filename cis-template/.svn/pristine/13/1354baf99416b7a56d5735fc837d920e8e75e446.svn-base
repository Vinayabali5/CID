(function() {
    'use strict';

    describe('AcademicYearService', function() {

        var httpBackend;
        var academicYear;

        beforeEach(module('AcademicYearService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/academic-years/').respond(200, [{
                id: 17,
                code: '2017/18'
            }]);
            httpBackend.whenGET('/api/academic-years/18').respond(200, {});
            httpBackend.whenGET('/api/academic-years/current').respond(200, {});
            httpBackend.whenPOST('/api/academic-years/').respond(201, {});
            httpBackend.whenPUT('/api/academic-years/18').respond(200, {});
            academicYear = $injector.get('AcademicYear');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all academic years', function() {
            httpBackend.expectGET('/api/academic-years/');
            academicYear.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific academic year', function() {
            httpBackend.expectGET('/api/academic-years/18');
            academicYear.get(18);
            httpBackend.flush();
        });

        it('should GET from api to retrieve the current academic year', function() {
            httpBackend.expectGET('/api/academic-years/current');
            academicYear.getCurrent();
            httpBackend.flush();
        });

        it('should POST to api to create a new academic year', inject(function($http) {
            httpBackend.expectPOST('/api/academic-years/', {
                code: '2018/19'
            });
            academicYear.create({
                code: '2018/19'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing academic year', function() {
            httpBackend.expectPUT('/api/academic-years/18', {
                id: 18,
                code: '18/19',
                description: '2018/19'
            });
            academicYear.save({
                id: 18,
                code: '18/19',
                description: '2018/19'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });

    });

})();

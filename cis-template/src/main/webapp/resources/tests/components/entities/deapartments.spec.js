(function() {
    'use strict';

    describe('DepartmentService', function() {

        var httpBackend;
        var department;

        beforeEach(module('DepartmentService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/departments/').respond(200, [{
                id: 1,
                name: '1',
                description: 'Department A',
                academic: true,
                facultyId: 10,
                hodId: 5,
                hod2Id: 6
            }]);
            httpBackend.whenGET('/api/departments/1').respond(200, {});
            httpBackend.whenPOST('/api/departments/').respond(201, {});
            httpBackend.whenPUT('/api/departments/2').respond(200, {});
            department = $injector.get('Department');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the departments', function() {
            httpBackend.expectGET('/api/departments/');
            department.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific department', function() {
            httpBackend.expectGET('/api/departments/1');
            department.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new department', inject(function($http) {
            httpBackend.expectPOST('/api/departments/', {
                name: '1',
                description: 'Department A',
                academic: true
            });
            department.create({
                name: '1',
                description: 'Department A',
                academic: true
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing department', function() {
            httpBackend.expectPUT('/api/departments/2', {
                id: 2,
                name: '1',
                description: 'Department A',
                academic: true
            });
            department.save({
                id: 2,
                name: '1',
                description: 'Department A',
                academic: true
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

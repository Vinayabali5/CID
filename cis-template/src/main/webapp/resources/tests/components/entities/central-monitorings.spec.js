(function() {
    'use strict';

    describe('CentralMonitoringService', function() {

        var httpBackend;
        var centralMonitoring;

        beforeEach(module('CentralMonitoringService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/centralMonitorings/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Absent',
                warningColour: '/'
            }]);
            httpBackend.whenGET('/api/centralMonitorings/1').respond(200, {});
            httpBackend.whenPOST('/api/centralMonitorings/').respond(201, {});
            httpBackend.whenPUT('/api/centralMonitorings/2').respond(200, {});
            centralMonitoring = $injector.get('CentralMonitoring');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the centralMonitorings', function() {
            httpBackend.expectGET('/api/centralMonitorings/');
            centralMonitoring.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific centralMonitoring', function() {
            httpBackend.expectGET('/api/centralMonitorings/1');
            centralMonitoring.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new centralMonitoring', inject(function($http) {
            httpBackend.expectPOST('/api/centralMonitorings/', {
                code: '1'
            });
            centralMonitoring.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing centralMonitoring', function() {
            httpBackend.expectPUT('/api/centralMonitorings/2', {
                id: 2,
                code: '1',
                description: 'Present',
                warningColour: '/'
            });
            centralMonitoring.save({
                id: 2,
                code: '1',
                description: 'Present',
                warningColour: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

(function() {
    'use strict';

    describe('RoomTypeService', function() {

        var httpBackend;
        var roomType;

        beforeEach(module('RoomTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/roomTypes/').respond(200, [{
                id: 1,
                code: '2',
                description: 'roomType 3',
                timetableable: true
            }]);
            httpBackend.whenGET('/api/roomTypes/1').respond(200, {});
            roomType = $injector.get('RoomType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the roomTypes', function() {
            httpBackend.expectGET('/api/roomTypes/');
            roomType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific roomType', function() {
            httpBackend.expectGET('/api/roomTypes/1');
            roomType.get(1);
            httpBackend.flush();
        });
    });

})();

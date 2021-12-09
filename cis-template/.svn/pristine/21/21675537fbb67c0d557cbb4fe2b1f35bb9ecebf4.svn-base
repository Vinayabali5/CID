(function() {
    'use strict';

    describe('LLDDHealthProblemCategoryService', function() {

        var httpBackend;
        var lLDDHealthProblemCategory;

        beforeEach(module('LLDDHealthProblemCategoryService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/lLDDHealthProblemCategories/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/lLDDHealthProblemCategories/1').respond(200, {});
            httpBackend.whenPOST('/api/lLDDHealthProblemCategories/').respond(201, {});
            httpBackend.whenPUT('/api/lLDDHealthProblemCategories/1').respond(200, {});
            lLDDHealthProblemCategory = $injector.get('LLDDHealthProblemCategory');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the lLDDHealthProblemCategories', function() {
            httpBackend.expectGET('/api/lLDDHealthProblemCategories/');
            lLDDHealthProblemCategory.query();
            httpBackend.flush();
        });

        it('should GET from api to retrieve a specific lLDDHealthProblemCategory', function() {
            httpBackend.expectGET('/api/lLDDHealthProblemCategories/1');
            lLDDHealthProblemCategory.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new lLDDHealthProblemCategory', inject(function($http) {
            httpBackend.expectPOST('/api/lLDDHealthProblemCategories/', {
                code: '1'
            });
            lLDDHealthProblemCategory.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/lLDDHealthProblemCategories/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            lLDDHealthProblemCategory.save({
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();

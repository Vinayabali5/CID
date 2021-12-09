describe('address-details directive', function() {

    var dummyAddress = {
        line1: 'Address Line 1',
        line2: 'Address Line 2',
        line3: 'Address Line 3',
        line4: 'Address Line 4',
        postcode: 'Postcode',
    };

    beforeEach(module('html'));
    beforeEach(module('AddressDetailsDirective'));

    beforeEach(inject(function(_$compile_, _$rootScope_) {
        $compile = _$compile_;
        $rootScope = _$rootScope_;
    }));

    it('should display data on the screen', function() {
        $rootScope.address = dummyAddress;
        var element = $compile('<address-details address="address"></address-details>')($rootScope);
        $rootScope.$digest();
        expect(element.html()).toContain("<div");
        expect(element.html()).toContain(dummyAddress.line1);
        expect(element.html()).toContain(dummyAddress.line2);
        expect(element.html()).toContain(dummyAddress.line3);
        expect(element.html()).toContain(dummyAddress.line4);
        expect(element.html()).toContain(dummyAddress.postcode);
        expect(element.html()).toContain("</div");
    });

});

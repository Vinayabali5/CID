describe('BlankFilter', function() {
    var $filter;

    beforeEach(function() {
        module('BlankFilter');

        inject(function(_$filter_) {
            $filter = _$filter_;
        });
    });

    it('should return the text "No Data" when a null value is passed', function() {
        result = $filter('blank')(null);
        expect(result).toBe('No Data');
    });

    it('should return the text "No Data" when a undefined value is passed', function() {
        result = $filter('blank')(undefined);
        expect(result).toBe('No Data');
    });

    it('should return the text "No Data" when a blank string value is passed', function() {
        result = $filter('blank')('');
        expect(result).toBe('No Data');
    });

    it('should return the text supplied if this is not a blank string', function() {
        result = $filter('blank')('Test');
        expect(result).toBe('Test');
    });

});

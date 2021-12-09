describe('PercentFilter', function() {
    var $filter;

    beforeEach(function() {
        module('PercentFilter');

        inject(function(_$filter_) {
            $filter = _$filter_;
        });
    });

    it('should return the a formatted percentage when supplied a decimal number', function() {
        result = $filter('percent')(0.54321, 0);
        expect(result).toBe('54%');
    });

    it('should return the a formatted percentage when supplied a decimal number, with the correct number of decimal places', function() {
        result = $filter('percent')(0.54321, 2);
        expect(result).toBe('54.32%');
    });

    it('should return the text "No Data" when a null value is passed', function() {
        result = $filter('percent')(null);
        expect(result).toBe('No Data');
    });

    it('should return the text "No Data" when a undefined value is passed', function() {
        result = $filter('percent')(undefined);
        expect(result).toBe('No Data');
    });

    it('should return the text "" when a blank string value is passed', function() {
        result = $filter('percent')('');
        expect(result).toBe('');
    });

    it('should return the text supplied if this is not a blank string', function() {
        result = $filter('percent')('Test');
        expect(result).toBe('Test');
    });

});

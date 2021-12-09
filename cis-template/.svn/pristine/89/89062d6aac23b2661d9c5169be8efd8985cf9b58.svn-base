describe('NotSetFilter', function() {
    var $filter;

    beforeEach(function() {
        module('NotSetFilter');

        inject(function(_$filter_) {
            $filter = _$filter_;
        });
    });

    it('should return the text "Not Set" when a null value is passed', function() {
        result = $filter('notSet')(null);
        expect(result).toBe('Not Set');
    });

    it('should return the text "Not Set" when a undefined value is passed', function() {
        result = $filter('notSet')(undefined);
        expect(result).toBe('Not Set');
    });

    it('should return the text "Not Set" when a blank string value is passed', function() {
        result = $filter('notSet')('');
        expect(result).toBe('Not Set');
    });

    it('should return the text supplied if this is not a blank string', function() {
        result = $filter('notSet')('Test');
        expect(result).toBe('Test');
    });

});

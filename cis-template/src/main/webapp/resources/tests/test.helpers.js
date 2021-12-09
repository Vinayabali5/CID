var MockGLOBALProvider = {
    API: '/api'
};

beforeEach(function() {
    module(function($provide) {
        $provide.value('GLOBAL', MockGLOBALProvider);
    });
});

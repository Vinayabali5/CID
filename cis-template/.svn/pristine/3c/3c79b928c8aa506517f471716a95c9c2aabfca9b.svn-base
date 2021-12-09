/**
 * 
 */
angular.module('IndeterminateCheckboxDirective', ['ngResource', 'ui.bootstrap'])
    .directive('indeterminateCheckbox', function() {
        return {
            scope: true,
            require: '?ndModel',
            link: function(scope, element, attrs, modelCtrl) {
                var childList = attrs.childList;
                var property = attrs.property;

                element.bind('change', function() {
                    scope.$apply(function() {
                        var isChecked = element.prop('checked');

                        angular.forEach(scope.$eval(childList), function(child) {
                            child[property] = isChecked;
                        });
                    });
                });

                scope.$watch(childList, function(newValue) {
                    var hasChecked = false;
                    var hasUnchecked = false;

                    angular.forEach(newValue, function(child) {
                        if (child[property]) {
                            hasChecked = true;
                        } else {
                            hasUnchecked = true;
                        }
                    });

                    if (hasChecked && hasUnchecked) {
                        element.prop('checked', false);
                        element.prop('indeterminate', true);
                        if (modelCtrl) {
                            modelCtrl.$setViewValue(false);
                        }
                    } else {
                        element.prop('checked', hasChecked);
                        element.prop('indeterminate', false);
                        if (modelCtrl) {
                            modelCtrl.$setViewValue(hasChecked);
                        }
                    }
                }, true);
            }
        };
    });

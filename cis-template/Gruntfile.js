module.exports = function(grunt) {
    "use strict";

    require('load-grunt-tasks')(grunt);

    grunt
        .initConfig({
            appConfig: {
                app: require('./bower.json').appPath || 'js',
                name: 'cis-timetable',
                gruntConf: 'Gruntfile.js',
                karmaConf: 'karma.conf.js',
                webapp: 'src/main/webapp/resources',
                js: 'src/main/webapp/resources/js',
                css: 'src/main/webapp/resources/css',
                bower: 'src/main/webapp/resources/bower_components',
                tests: 'src/main/webapp/resources/tests',
                dist: 'src/main/webapp/resources/dist',
            },
            clean: {
                bower: '<%= appConfig.bower %>'
            },
            bower: {
                install: {
                    options: {
                        install: true,
                        copy: false
                    }
                }
            },
            uglify: {
                options: {
                    mangle: false
                },
                bower: {
                    files: {
                        '<%= appConfig.dist %>/vendor.min.js': ['<%= appConfig.dist %>/vendor.js']
                    }
                },
                main: {
                    files: {
                        '<%= appConfig.dist %>/app.min.js': ['<%= appConfig.dist %>/app.js']
                    }
                },
                annotated: {
                    files: {
                        '<%= appConfig.dist %>/app.min.js': ['<%= appConfig.dist %>/app.annotated.js']
                    }
                }
            },
            jshint: {
                options: {
                    jshintrc: true,
                    //jshintrc: '.jshintrc'
                },
                all: [
                    '<%= appConfig.gruntConf %>',
                    '<%= appConfig.karmaConf %>',
                    '<%= appConfig.js %>/**/*.js',
                    '<%= appConfig.tests %>/**/*.js'
                ]
            },
            karma: {
                options: {
                    configFile: '<%= appConfig.karmaConf %>',
                },
                continous: {},
                single: {
                    singleRun: true,
                    browsers: ['PhantomJS']
                }
            },
            angularFileLoader: {
                options: {
                    scripts: ['<%= appConfig.js %>/**/**.js']
                },
                main: {
                    src: ['<%= appConfig.webapp %>/index.html']
                },
                dist: {
                    src: ['<%= appConfig.dist %>/index.html']
                }
            },
            wiredep: {
                dev: {
                    src: ['<%= appConfig.webapp %>/index.html'],
                    options: {
                        directory: '<%= appConfig.bower %>'
                    }
                },
            },
            "jsbeautifier": {
                "javascript": {
                    src: [
                        '<%= appConfig.gruntConf %>',
                        '<%= appConfig.karmaConf %>',
                        '<%= appConfig.js %>/**/*.js',
                        '<%= appConfig.tests %>/**/*.js'
                    ],
                    options: {}
                },
                "html": {
                    src: [
                        '<%= appConfig.webapp %>/index.html',
                        '<%= appConfig.webapp %>/partials/**/**.html',
                        '<%= appConfig.js %>/**/**.html'
                    ],
                    options: {
                        preserveNewlines: true,
                    }
                },
                "indexOnly": {
                    src: [
                        '<%= appConfig.webapp %>/index.html',
                    ],
                    options: {
                        preserveNewlines: true,
                    }
                },
            },
            watch: {
                javascript: {
                    files: ['<%= appConfig.js %>/**/*.js'],
                    tasks: ['build'],
                    options: {
                        spawn: false,
                    },
                },
                html: {
                    files: ['<%= appConfig.webapp %>/**/*.html'],
                    tasks: [
                        'jsbeautifier:html',
                        'karma:single',
                    ],
                    options: {
                        spawn: false,
                    },
                },
                tests: {
                    files: ['<%= appConfig.webapp %>/tests/**/*.spec.js'],
                    tasks: ['karma:single'],
                },
                bowerComponents: {
                    files: ['<%= appConfig.bower %>/**.*'],
                    tasks: ['bower_concat', 'wiredep:dev'],
                },
                dist: {
                    files: ['<%= appConfig.webapp %>/**/*.*'],
                    tasks: ['buildDist']
                }
            },

            /* PRODUCTION RELEASE SCRIPT COMPONENTS */

            bower_concat: {
                dist: {
                    dependencies: {
                        'bootstrap': 'jquery',
                    },
                    options: {
                        separator: ';',
                    },
                    exclude: ['angular-mocks'],
                    mainFiles: {
                        bootstrap: ['dist/css/bootstrap.min.css', 'dist/js/bootstrap.min.js'],
                        "ng-file-upload": ['ng-file-upload-all.min.js'],
                        angular: ['angular.js'],
                        tinymce: ['tinymce.min.js', 'themes/modern/therme.js', 'skins/lightgray/skin.min.css', 'skins/lightgray/content.min.css'],
                    },
                    dest: {
                        'js': '<%= appConfig.dist %>/vendor.js',
                        'css': '<%= appConfig.dist %>/vendor.css'
                    }
                }
            },
            html2js: {
                dist: {
                    options: {
                        module: 'cid',
                        existingModule: true,
                        base: '<%= appConfig.webapp %>',
                        htmlmin: {
                            collapseBooleanAttributes: true,
                            collapseWhitespace: true,
                            removeAttributeQuotes: true,
                            removeComments: true,
                            removeEmptyAttributes: true,
                            removeRedundantAttributes: true,
                            removeScriptTypeAttributes: true,
                            removeStyleLinkTypeAttributes: true
                        },
                        singleModule: true,
                    },
                    src: ['<%= appConfig.js %>/**/*.html'],
                    dest: '<%= appConfig.dist %>/templates.js'
                }
            },
            concat: {
                dist: {
                    options: {
                        separator: ';',
                    },
                    src: [
                        '<%= appConfig.webapp %>/js/components/**/*.js',
                        '<%= appConfig.webapp %>/js/app.dependencies.js',
                        '<%= appConfig.webapp %>/js/app.config.js',
                        '<%= appConfig.webapp %>/js/app.js',
                        '<%= appConfig.webapp %>/js/**/*.directive.js',
                        '<%= appConfig.webapp %>/js/**/*.module.js',
                        '<%= appConfig.webapp %>/js/**/*.js',
                        '<%= appConfig.dist %>/templates.js',
                    ],
                    dest: '<%= appConfig.dist %>/app.js',
                },
                css: {
                    src: [
                        '<%= appConfig.webapp %>/css/basic.css',
                        '<%= appConfig.webapp %>/css/validation.css',
                        '<%= appConfig.webapp %>/css/dropdown-submenu.css',
                        '<%= appConfig.webapp %>/css/seating-plan.css',
                        '<%= appConfig.webapp %>/css/print.css',
                    ],
                    dest: '<%= appConfig.dist %>/app.css',
                },
            },
            copy: {
                index: {
                    src: '<%= appConfig.webapp %>/index.html',
                    dest: '<%= appConfig.dist %>/index.orig.html',
                    options: {
                        process: function(content, srcpath) {
                            return content.replace(/bower_components\/tinymce\//g, '');
                        },
                    }
                },
                config: {
                    src: '<%= appConfig.webapp %>/config.json',
                    dest: '<%= appConfig.dist %>/config.json',
                },
                imgs: {
                    expand: true,
                    cwd: '<%= appConfig.webapp %>/imgs/',
                    src: '**',
                    dest: '<%= appConfig.dist %>/imgs/',

                },
                fonts: {
                    files: [{
                            expand: true,
                            cwd: '<%= appConfig.bower %>/bootstrap/dist/fonts/',
                            src: '**',
                            dest: '<%= appConfig.dist %>/fonts/'
                        },
                        {
                            expand: true,
                            cwd: '<%= appConfig.bower %>/tinymce/skins/lightgray/fonts/',
                            src: '**',
                            dest: '<%= appConfig.dist %>/fonts/'
                        }
                    ]
                },
                tinymce: {
                    files: [{
                            expand: true,
                            cwd: '<%= appConfig.bower %>/tinymce/themes/',
                            src: '**',
                            dest: '<%= appConfig.dist %>/themes/'
                        },
                        {
                            expand: true,
                            cwd: '<%= appConfig.bower %>/tinymce/skins/',
                            src: '**',
                            dest: '<%= appConfig.dist %>/skins/'
                        },
                        {
                            expand: true,
                            cwd: '<%= appConfig.bower %>/tinymce/plugins/',
                            src: '**',
                            dest: '<%= appConfig.dist %>/plugins/'
                        }
                    ]
                }
            },
            processhtml: {
                dist: {
                    files: {
                        '<%= appConfig.dist %>/index.html': ['<%= appConfig.dist %>/index.orig.html']
                    }
                }
            },

            /* Unused/Testing */
            ngAnnotate: {
                dist: {
                    files: [{
                        expand: true,
                        src: ['<%= appConfig.js %>/**/*.js', '!<%= appConfig.js %>/**/*.annotated.js'],
                        dest: '<%= appConfig.dist %>/annotated/',
                        ext: '.annotated.js',
                        extDot: 'last'
                    }],
                }
            },

            /* Unused */
            connect: {
                server: {
                    options: {
                        base: '<%= appConfig.dist %>',
                        open: true,
                        keepalive: true
                    }
                }
            },

        });

    grunt.registerTask('runTests', [
        'karma:single',
    ]);

    grunt.registerTask('build', [
        'jshint',
        'jsbeautifier:javascript',
        'jsbeautifier:html',
        'wiredep:dev',
        'angularFileLoader:main',
        'jsbeautifier:indexOnly',
        'karma:single',
    ]);

    grunt.registerTask('prepareDeployment', [
        'jshint',
        'wiredep:dev',
        'angularFileLoader:main',
    ]);

    grunt.registerTask('buildDist', [
        'bower_concat',
        'html2js',
        'concat:dist',
        'concat:css',
        'copy:index',
        'processhtml:dist',
        'copy:config',
        'copy:imgs',
        'copy:fonts',
        'copy:tinymce',

        // 'ngAnnotate',
        // 'concat_css',
        // 'uglify:annotated',
        // 'copy:main',
        // 'angularFileLoader:dist',
        // 'copy:dist',
    ]);

    grunt.registerTask('default', ['build']);

    grunt.registerTask('serve', ['buildDist', 'connect:server']);
};

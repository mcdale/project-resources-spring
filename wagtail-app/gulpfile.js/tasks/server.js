var exec = require('child_process').exec
    gulp = require('gulp')
    sass = require('../config').sassDirs
    hostport = '0.0.0.0:8000'
    reload = require('browser-sync').create();

gulp.task('watch:stylesheets', function() {
    "use strict";
    gulp.watch(sass, ['stylesheets']);
});

gulp.task('watch', ['watch:stylesheets']);

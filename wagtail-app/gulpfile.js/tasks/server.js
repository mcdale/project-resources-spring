var exec = require('child_process').exec
    gulp = require('gulp')
    sass = require('../config').sassDirs
    hostport = '0.0.0.0:8000'
    reload = require('browser-sync').create();

gulp.task('watch:stylesheets', function() {
    "use strict";
    return gulp.watch('./**/*.scss', ['stylesheets']);
});

gulp.task('watch:static:css', ['watch:stylesheets'], function(){
    "use strict";
    return gulp.watch('app/static/css/**/*.min.css', ['server:reload']);
});

gulp.task('server:reload', function(done){
    "use strict";

    done();
})
gulp.task('server:start', function(done){
    "use strict";
    var proc = exec('./manage.py runserver ' + hostport);

    proc.stderr.on('data', function(data) {
        process.stdout.write(data);
    });

    proc.stdout.on('data', function(data) {
        process.stdout.write(data);
    });

    done();
});

gulp.task('server', ['server:start', 'watch:static:css']);

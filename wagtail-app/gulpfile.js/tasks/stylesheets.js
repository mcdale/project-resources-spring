var autoprefix = require('gulp-autoprefixer')
    clean = require('del')
    cssDirs = require('../config').cssDirs
    gulp = require('gulp')
    uglify = require('gulp-clean-css')
    path = require('path')
    plumber = require('gulp-plumber')
    rename = require('gulp-rename')
    sass = require('gulp-sass')
    sassDirs = require('../config').sassDirs,
    sassOptions = require('../config').sassOptions,
    util = require('gulp-util');

gulp.task('sass:compile', function(){
    "use strict";
    return gulp.src(sassDirs)
        .pipe(plumber())
        .pipe(sass(sassOptions))
        .pipe(autoprefix())
        .pipe(plumber.stop())
        .pipe(gulp.dest(function(file) {
            return path.normalize(file.base).replace('/sass/','/css/')
        }));
});

gulp.task('static:css', ['sass:compile'], function(){
    "use strict";
    return gulp.src(cssDirs)
        .pipe(plumber())
        .pipe(plumber.stop())
        .pipe(gulp.dest('app/static/css'));
});

gulp.task('static:css:uglify', ['static:css'], function(){
    "use strict";
    return gulp.src(['app/static/css/**/*.css','!app/static/css/**/*.min.css'])
        .pipe(plumber())
        .pipe(rename({ suffix:'.min' }))
        .pipe(uglify())
        .pipe(plumber.stop())
        .pipe(gulp.dest('app/static/css'));

});


gulp.task('stylesheets', ['static:css:uglify'], function(){
    "use strict";
    return clean(cssDirs);
});
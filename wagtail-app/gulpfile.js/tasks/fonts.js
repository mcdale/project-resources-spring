var gulp = require('gulp')
    util = require('gulp-util');

gulp.task('fonts:font-awesome', function(){
    "use strict";
    return gulp.src('node_modules/font-awesome/fonts/**/*.{otf,eot,svg,ttf,woff,woff2}')
        .pipe(gulp.dest('app/static/fonts'));
});

gulp.task('fonts', ['fonts:font-awesome']);

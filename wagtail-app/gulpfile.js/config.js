var path = require('path');
var bourbon = require('bourbon').includePaths;
var neat = require('bourbon-neat').includePaths;


var sassOptions = {
    includePaths: [
        'node_modules/font-awesome/scss',
        'node_modules/normalize-scss/sass',
        bourbon,
        neat,
    ],
    outputStyle: 'expanded'
};

var cssDirs = [
    'base/assets/stylesheets/css/**/*.css',
    'home/assets/stylesheets/css/**/*.css',
    'search/assets/stylesheets/css/**/*.css',
]
var sassDirs = [
    "base/assets/stylesheets/sass/**/*.scss",
    "home/assets/stylesheets/sass/**/*.scss",
    "search/assets/stylesheets/sass/**/*.scss",
];

module.exports = {
    cssDirs: cssDirs,
    sassDirs: sassDirs,
    sassOptions: sassOptions,
};
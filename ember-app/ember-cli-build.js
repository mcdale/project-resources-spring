/* eslint-env node */
const EmberApp = require('ember-cli/lib/broccoli/ember-app');
var mergeTrees = require('broccoli-merge-trees');
var pickFiles = require('broccoli-static-compiler');

module.exports = function(defaults) {
  var app = new EmberApp(defaults, {
    // Add options here
    sassOptions: {
      includePaths: [
          'node_modules/normalize-scss/sass',
          'node_modules/font-awesome/scss',
          'node_modules/bourbon/core',
          'node_modules/bourbon-neat/core',
      ]
    }
  });

  // Use `app.import` to add additional libraries to the generated
  // output files.
  //
  // If you need to use different assets in different
  // environments, specify an object as the first parameter. That
  // object's keys should be the environment name and the values
  // should be the asset to use in that environment.
  //
  // If the library that you are including contains AMD or ES6
  // modules that you would like to import into your application
  // please specify an object with the list of modules as keys
  // along with the exports of each module as its value.
  var fontTree = pickFiles('node_modules/font-awesome/fonts', {
    srcDir: '/',
    files: ['fontawesome-webfont.eot','fontawesome-webfont.ttf','fontawesome-webfont.svg','fontawesome-webfont.woff','fontawesome-webfont.woff2'],
    destDir: '/assets/fonts'
  });
  return mergeTrees([app.toTree(), fontTree]);
};

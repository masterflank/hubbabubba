module.exports = function(config){
  config.set({

    basePath : './',

    files : [
      'src/main/webapp/app/bower_components/angular/angular.js',
      'src/main/webapp/app/bower_components/angular-route/angular-route.js',
      'src/main/webapp/app/bower_components/angular-mocks/angular-mocks.js',
      'src/main/webapp/app/components/**/*.js',
      'src/main/webapp/app/view*/**/*.js',
      'src/main/webapp/app/playerlist/**/*.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['Chrome'],

    plugins : [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine',
            'karma-phantomjs-launcher',
            'karma-junit-reporter'
            ],

    junitReporter : {
      outputFile: 'target/surefire-reports/TEST-karma-test-results.xml',
      suite: 'unit'
    }

  });
};

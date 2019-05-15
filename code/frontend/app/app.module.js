console.log('application loading...');

import angular from 'angular';
import uiRouter from 'angular-ui-router';
import animate from 'angular-animate';
import AppStyles from '../styles/app.scss';
import AppComponent from './app.component';
import Components from '../components/components.module';
import Services from '../services/services.module';

// create our app module and setup core dependencies
angular.module('app', [

  uiRouter,
  animate,
  Components,
  Services

])

.config(($stateProvider, $urlRouterProvider) => {
  'ngInject';

  $stateProvider

  .state({
    name: "login",
    url: "/login",
    template: "<authentification/>"
  })

  // setup default route
  $urlRouterProvider.otherwise('/login');

})

// setup root component
.component('app', AppComponent);


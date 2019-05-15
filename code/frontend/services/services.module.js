import AuthentificationService from './authentification/authentification.service';

const module = angular.module('frontend.services', []);

module.service('AuthentificationService', AuthentificationService);

export default module.name;

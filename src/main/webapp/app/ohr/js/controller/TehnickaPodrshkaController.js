'use strict';

app.controller('TehnickaPodrshkaController',['$scope','$window','TehnickaPodrshkaService',function($scope,$window,TehnickaPodrshkaService) {
  var self = this;
  self.tehPod = {
    id:"",
    idTehnicka:"",
    problem:"",
    odgovor:"",
    korisnikById:{
      id:""
    },
    tehnickapodrshkaByIdTehnicka:{
      korisnikById:{
        id:""
      }
    }
  };
  self.tehPods =[];
  self.primer = "Yes";
  self.HelpFunction = function (t) {
    console.log(t);
    self.tehPod = t;
    location.href = location.href.substr(0,location.href.length-15)+"tehnickapodrskaodgovor";
  }
  self.fetchAll = function () {
    TehnickaPodrshkaService.FetchAll()
        .then(
            function(d){
              console.log(d);
              self.tehPods = d;
            },
            function(errResponse){
              console.log('Error while fetching all tehnickaPods in TehnickaPodrshakaController');
            }
        )
  }
  self.createNew = function (user) {
    self.tehPod.tehnickapodrshkaByIdTehnicka.id = user.id;
    self.tehPod.tehnickapodrshkaByIdTehnicka.korisnikById = user;
    console.log(self.tehPod);
    TehnickaPodrshkaService.CreateNew(self.tehPod)
        .then(
            function(d){
              self.tehPod = d;
            },
            function(errResponse){
              console.log('Error while creatng tehnickaPod in TehnickaPodrshakaController');
            }
        )
  }
  self.fetchAll();
}]);

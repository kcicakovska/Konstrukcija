'use strict';

app.controller('userController',['$scope','$window','UserService', function($scope,$window,UserService) {
	var self = this;


	self.checkLogged=false;
    self.logedUser='',
	self.user={
        korisnickoIme:'',
        lozinka:'',
        loginStatus:'',
        ime:'',
        prezime:'',
        embg:'',
        email:'',
        drzava:'',
        grad:'',
        adresa:'',
        notifikacijaDo:'',
        notifikacijaOd:'',
		tip:''
	};
	self.users = [];

  /**
   * See if user exist in database if add him to Session and local storage and redirect
   */
		self.checkSingIn = function(){
			console.log(self.user.lozinka+" "+self.user.korisnickoIme);
		UserService.LogginUser(self.user).then(
				function (d) {
					//console.log(d);
					self.user = d;
					//console.log(self.user.korisnickoIme+"   Ovaa e korisnikot "+self.user.tip);
                    sessionStorage.setItem('user', JSON.stringify(self.user.korisnickoIme));
                    if(self.user.tip==='admin'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="admin";
					}else if(self.user.tip==='kupuvac'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="korisnik";
					}else if(self.user.tip==='direktor'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="direktor";
					}else if(self.user.tip==='validator'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="validator";
					}else if(self.user.tip==='tehnickapodrshka'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="tehnickapodrska";
					}
                    else if(self.user.tip==='recepcioner'){
                        self.checkLogged=true;
                        $('#htlfndr-sing-in').modal('hide');
                        location.href +="recepcioner";
                    }
                },
                function (errResponse) {
                    console.log('Error while fetching ticket in TicketController');
                }
)};

  /**
   * On refresh if user is already logged don't logout him redirect to home page
   */
  self.populateLogUser = function () {

        if (sessionStorage.getItem('user')) {
            console.log(sessionStorage.getItem('user'));
            self.logedUser = sessionStorage.getItem('user');
            var name = self.logedUser.substring(1, self.logedUser.length - 1);
            UserService.FetchByName(name)
                .then(
                    function (d) {


                        self.user = d;
                        if(self.user.tip==='admin'){
                            self.checkLogged=true;
                            $('#htlfndr-sing-in').modal('hide');
                            location.href +="admin";
                        }else if(self.user.tip==='kupuvac'){
                            self.checkLogged=true;
                            $('#htlfndr-sing-in').modal('hide');
                            location.href +="korisnik";
                        }else if(self.user.tip==='direktor'){
                            self.checkLogged=true;
                            $('#htlfndr-sing-in').modal('hide');
                            location.href +="direktor";
                        }else if(self.user.tip==='validator'){
                            self.checkLogged=true;
                            $('#htlfndr-sing-in').modal('hide');
                            location.href +="validator";
                        }else if(self.user.tip==='tehnickapodrshka'){
                            self.checkLogged=true;
                            $('#htlfndr-sing-in').modal('hide');
                            location.href +="tehnickapodrska";
                        }else if(self.user.tip==='recepcioner'){
                            self.checkLogged=true;
                            $('#htlfndr-sing-in').modal('hide');
                            location.href +="recepcioner";
                        }

                    },
                    function (err) {
                        console.log("Error!!!")
                    }
                )
        }
    };

  /**
   * User registration if everything is successful redirect to screen depending of type of user
   *
   */
  self.Register = function(){

	UserService.RegisterUser(self.user).then(
				function (d) {
          if(self.user.tip==='admin'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="admin";
					}else if(self.user.tip==='kupuvac'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="korisnik";
					}else if(self.user.tip==='direktor'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="direktor";
					}else if(self.user.tip==='validator'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="validator";
					}else if(self.user.tip==='tehnickapodrshka'){
						self.checkLogged=true;
						$('#htlfndr-sing-in').modal('hide');
						location.href +="tehnickapodrska";
					}
                },
                function (errResponse) {
                    console.log('Error while registering user in UserController');
                }
)}
  /**
   * Logout clear Session and Local Storage
   */
	self.Logout = function(){
		self.user = {};
		self.checkLogged=false;
        sessionStorage.clear();
        localStorage.clear();
	};
	self.populateLogUser();
}])
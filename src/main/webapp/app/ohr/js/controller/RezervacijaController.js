'use strict';

app.controller('rezervacijaController',['$scope','$window','$document','RezervacijaService','HotelServices', function($scope,$window,$document,RezervacijaService,HotelServices) {
    var self = this;
    self.FilterAtReservation=[];
    self.hotelsFree = [];
    self.hotel={
        ime:'',
        adresa:'',
        opis:'',
        brojNaSobi:'',
        //sliki:'',
        internet:'',
        parking:'',
        klima:'',
        parno:'',
        lift:'',
        bazen:'',
        spaIFitnes:'',
        sobnaUsloga:'',
        pojadokVoSoba:'',
        restorant:'',
        bar:'',
        terasa:'',
        milenicijaDozvoluva:'',
        direktorByIdDirektor:{},
        sobasById:{},
        zvezdi:'',
    };
    self.rezervaciiFiltered = [];
    self.pomoshHotel='';
    self.rezervacija={
        datumDo:'',
        datumOd:'',
        datumOdjava:'',
        ocenka:'',
        komentar:'',
        sobaByIdSoba:{},
        korisnikKupuvacByIdKorisnik:{},
    };
    self.hotels=[];

  /**
   * Fetching all reservation from database
   */
  self.FetchAll = function () {
        RezervacijaService.FetchAll()
            .then(
                function(d){
                    self.rezervacii = d;
                    self.Filter(0);
                },
                function(errResponse){
                    console.log('Error while fetching all Reservation in RezervacijaController');
                }

            )
    };

    self.findReservation = function(){
        console.log(self.rezervacija.datumOd+" "+self.rezervacija.datumDo);
        if(self.rezervacija.datumOd!="" && self.rezervacija.datumDo!="") {
            RezervacijaService.FindReservation(self.rezervacija.datumOd, self.rezervacija.datumDo)
                .then(
                    function (d) {
                        self.hotelsFree = d;

                    },
                    function (errResponse) {
                        console.log('Error while fetching filtered reservaction in RezervacijaController');
                    }
                )
        }else{
            HotelServices.FetchAll()
                .then(
                    function(d){

                        self.hotelsFree = d;
                    },
                    function(errResponse){
                        console.log('Error while fetching all hotel in RezervacijaControlller')
                    }
                )
        }
    };

  /**
   * Making the json in form that can be entered in database for submitting an reservation
   * @param korisnik
   * @param pomosh
   * @param ime
   */
    self.makeReservation = function(korisnik,pomosh,ime){
        //console.log(korisnik);

        var boolea = false;
        self.rezervacija.korisnikKupuvacByIdKorisnik.id = korisnik.id;
        for(var i = 0; i < self.hotels.length; i++){
            if(self.hotels[i].ime==ime) {
                for (var k = 0; k < self.hotels[i].sobasById.length; k++) {
                    //console.log(self.hotels[i].sobasById[k]);
                    if (pomosh.brSoba == self.hotels[i].sobasById[k].brSoba) {
                        console.log(self.hotels[i].sobasById[k]);
                        self.rezervacija.sobaByIdSoba.id = self.hotels[i].sobasById[k].id;
                        self.rezervacija.sobaByIdSoba.cena = self.hotels[i].sobasById[k].cena;
                        self.rezervacija.sobaByIdSoba.brSoba = self.hotels[i].sobasById[k].brSoba;
                        self.rezervacija.sobaByIdSoba.tip = self.hotels[i].sobasById[k].tip;
                        self.pomoshHotel = ime;
                        boolea = true;
                        break;
                    }
                }
            }
            if(boolea)
                break;
        }
        var oneDay = 24*60*60*1000;
        var firsDay = new Date(self.rezervacija.datumOd);
        var lastDay = new Date(self.rezervacija.datumDo);
        var diffDay = Math.round(Math.abs((firsDay.getTime()-lastDay.getTime())/oneDay));
        self.DenoviRezervirani = diffDay;

       // self.saveReservation();
        var url = location.href;
        url = url.substr(0,url.length-11);
        location.href = url +"payment";
    };
  /**
   * Saving reservation
   */
  self.saveReservation = function(){
        console.log(self.rezervacija);
        RezervacijaService.saveReservation(self.rezervacija)
            .then(
                function(d){
                    self.rezervacija = d;
                    alert("Вашата резервација е платена")
                },
                function(errResponse){
                    console.log('Error while saving reservation in reservationController');
                }
            )
    };
  /**
   * Fetching all hotels from database
   */
  self.fetchAllHotels = function(){
        HotelServices.FetchAll()
            .then(
                function(d){

                    self.hotels = d;
                },
                function(errResponse){
                    console.log('Error while fetching all hotel in RezervacijaControlller')
                }
            )
    };
  /**
   * Filter function adding id of hotel to see just reservation from that hotel
   * @param id
   */
    self.Filter=function(id){
        for (var i =0; i<self.rezervacii.length;i++){
            if(self.rezervacii[i].sobaByIdSoba.hotelByHotelId.id==id){
                self.FilterAtReservation.push(self.rezervacii[i]);
            }
        }
    };

    self.RezervationById=function(id){
        RezervacijaService.reservationById(id)
            .then(
                function (d) {
                    self.rezervacii = d;

                   // var url = location.href;
                   // url = url.substr(0,url.length-6);
                    location.href += "rezervacii";
                 /*   $( document ).ready(function() {
                        var today = new Date();
                    var dd = today.getDate();
                    var mm = today.getMonth()+1; //January is 0!
                    var yyyy = today.getFullYear();

                    if(dd<10) {
                        dd='0'+dd
                    }

                    if(mm<10) {
                        mm='0'+mm
                    }

                    today = mm+'/'+dd+'/'+yyyy;
                    console.log(today);
                    //var odjavaElements = $document[0].getElementsByClassName("odjavaData");
                    var odjavaElements =angular.element(document).find(".odjavaData");

                    console.log(odjavaElements.length,"ooooooo");
                    for (var i =0 ; i <odjavaElements.length; i++) {
                        odjavaElements[i].style.backgroundColor = "red";
                   }


                    });*/
                },
                function (errResponse) {
                    console.log('Error while fetching filtered reservaction in RezervacijaController');
                }
            )

    }
    self.fetchAllHotels();
    self.FetchAll();

    //data now


   // $('.inptedit').removeAttr('readonly')
}]);
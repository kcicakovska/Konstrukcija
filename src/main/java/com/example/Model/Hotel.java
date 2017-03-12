package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "hotel", schema = "example")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Hotel.class,
        property = "id")
public class Hotel {
    private int id;
    private String ime;
    private Collection<Soba> sobasById;
    private String adresa;
    private String opis;
    private Integer brojNaSobi;
    private String sliki;
    private boolean internet;
    private boolean parking;
    private boolean klima;
    private boolean parno;
    private boolean lift;
    private boolean bazen;
    private boolean spaIFitnes;
    private boolean sobnaUsloga;
    private boolean pojadokVoSoba;
    private boolean restorant;
    private boolean bar;
    private boolean terasa;
    private boolean milenicijaDozvoluva;
    private Direktor direktorByIdDirektor;
    private int zvezdi;



    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ime")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel that = (Hotel) o;

        if (id != that.id) return false;
        if (ime != null ? !ime.equals(that.ime) : that.ime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "hotelByHotelId",fetch = FetchType.LAZY)
    public Collection<Soba> getSobasById() {
        return sobasById;
    }

    public void setSobasById(Collection<Soba> sobasById) {
        this.sobasById = sobasById;
    }

    @Basic
    @Column(name = "adresa")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Basic
    @Column(name = "broj_na_sobi")
    public Integer getBrojNaSobi() {
        return brojNaSobi;
    }

    public void setBrojNaSobi(Integer brojNaSobi) {
        this.brojNaSobi = brojNaSobi;
    }

    @Basic
    @Column(name = "sliki")
    public String getSliki() {
        return sliki;
    }

    public void setSliki(String sliki) {
        this.sliki = sliki;
    }

    @Basic
    @Column(name = "internet")
    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    @Basic
    @Column(name = "parking")
    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    @Basic
    @Column(name = "klima")
    public Boolean getKlima() {
        return klima;
    }

    public void setKlima(Boolean klima) {
        this.klima = klima;
    }

    @Basic
    @Column(name = "parno")
    public Boolean getParno() {
        return parno;
    }

    public void setParno(Boolean parno) {
        this.parno = parno;
    }

    @Basic
    @Column(name = "lift")
    public Boolean getLift() {
        return lift;
    }

    public void setLift(Boolean lift) {
        this.lift = lift;
    }

    @Basic
    @Column(name = "bazen")
    public Boolean getBazen() {
        return bazen;
    }

    public void setBazen(Boolean bazen) {
        this.bazen = bazen;
    }

    @Basic
    @Column(name = "spa_i_fitnes")
    public Boolean getSpaIFitnes() {
        return spaIFitnes;
    }

    public void setSpaIFitnes(Boolean spaIFitnes) {
        this.spaIFitnes = spaIFitnes;
    }

    @Basic
    @Column(name = "sobna_usloga")
    public Boolean getSobnaUsloga() {
        return sobnaUsloga;
    }

    public void setSobnaUsloga(Boolean sobnaUsloga) {
        this.sobnaUsloga = sobnaUsloga;
    }

    @Basic
    @Column(name = "pojadok_vo_soba")
    public Boolean getPojadokVoSoba() {
        return pojadokVoSoba;
    }

    public void setPojadokVoSoba(Boolean pojadokVoSoba) {
        this.pojadokVoSoba = pojadokVoSoba;
    }

    @Basic
    @Column(name = "restorant")
    public Boolean getRestorant() {
        return restorant;
    }

    public void setRestorant(Boolean restorant) {
        this.restorant = restorant;
    }

    @Basic
    @Column(name = "bar")
    public Boolean getBar() {
        return bar;
    }

    public void setBar(Boolean bar) {
        this.bar = bar;
    }

    @Basic
    @Column(name = "terasa")
    public Boolean getTerasa() {
        return terasa;
    }

    public void setTerasa(Boolean terasa) {
        this.terasa = terasa;
    }

    @Basic
    @Column(name = "milenicija_dozvoluva")
    public Boolean getMilenicijaDozvoluva() {
        return milenicijaDozvoluva;
    }

    public void setMilenicijaDozvoluva(Boolean milenicijaDozvoluva) {
        this.milenicijaDozvoluva = milenicijaDozvoluva;
    }

    @ManyToOne
    @JoinColumn(name = "id_direktor", referencedColumnName = "ID", nullable = false)
    public Direktor getDirektorByIdDirektor() {
        return direktorByIdDirektor;
    }

    public void setDirektorByIdDirektor(Direktor direktorByIdDirektor) {
        this.direktorByIdDirektor = direktorByIdDirektor;
    }

    public int getZvezdi() {
        return zvezdi;
    }

    public void setZvezdi(int zvezdi) {
        this.zvezdi = zvezdi;
    }

    public Hotel(int id) {
        this.id = id;
    }

    public Hotel() {
    }
}

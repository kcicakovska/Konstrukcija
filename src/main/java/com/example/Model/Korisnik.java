package com.example.Model;

import javax.persistence.*;


@Entity
@Table(name = "korisnik", schema = "example")
public class Korisnik {
    private int id;
    private String korisnickoIme;
    private String lozinka;
    private byte loginStatus;
    private String ime;
    private String prezime;
    private String embg;
    private String email;
    private String drzava;
    private String grad;
    private String adresa;
    private String notifikacijaDo;
    private String notifikacijaOd;
    private String tip;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Korisnik() {
    }

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String embg, String email, String drzava, String grad, String adresa,String tip) {
        this.tip = tip;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.embg = embg;
        this.email = email;
        this.drzava = drzava;
        this.grad = grad;
        this.adresa = adresa;
    }

    public Korisnik(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "korisnickoIme")
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Basic
    @Column(name = "lozinka")
    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Basic
    @Column(name = "loginStatus")
    public byte getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(byte loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Basic
    @Column(name = "Ime")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "Prezime")
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "embg")
    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "drzava")
    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Basic
    @Column(name = "grad")
    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
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
    @Column(name = "notifikacija_do")
    public String getNotifikacijaDo() {
        return notifikacijaDo;
    }

    public void setNotifikacijaDo(String notifikacijaDo) {
        this.notifikacijaDo = notifikacijaDo;
    }

    @Basic
    @Column(name = "notifikacija_od")
    public String getNotifikacijaOd() {
        return notifikacijaOd;
    }

    public void setNotifikacijaOd(String notifikacijaOd) {
        this.notifikacijaOd = notifikacijaOd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Korisnik that = (Korisnik) o;

        if (id != that.id) return false;
        if (loginStatus != that.loginStatus) return false;
        if (korisnickoIme != null ? !korisnickoIme.equals(that.korisnickoIme) : that.korisnickoIme != null)
            return false;
        if (lozinka != null ? !lozinka.equals(that.lozinka) : that.lozinka != null) return false;
        if (ime != null ? !ime.equals(that.ime) : that.ime != null) return false;
        if (prezime != null ? !prezime.equals(that.prezime) : that.prezime != null) return false;
        if (embg != null ? !embg.equals(that.embg) : that.embg != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (drzava != null ? !drzava.equals(that.drzava) : that.drzava != null) return false;
        if (grad != null ? !grad.equals(that.grad) : that.grad != null) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;
        if (notifikacijaDo != null ? !notifikacijaDo.equals(that.notifikacijaDo) : that.notifikacijaDo != null)
            return false;
        if (notifikacijaOd != null ? !notifikacijaOd.equals(that.notifikacijaOd) : that.notifikacijaOd != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (korisnickoIme != null ? korisnickoIme.hashCode() : 0);
        result = 31 * result + (lozinka != null ? lozinka.hashCode() : 0);
        result = 31 * result + (int) loginStatus;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (embg != null ? embg.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (drzava != null ? drzava.hashCode() : 0);
        result = 31 * result + (grad != null ? grad.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (notifikacijaDo != null ? notifikacijaDo.hashCode() : 0);
        result = 31 * result + (notifikacijaOd != null ? notifikacijaOd.hashCode() : 0);
        return result;
    }
}

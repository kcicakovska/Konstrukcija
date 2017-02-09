package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "soba", schema = "example" )

@JsonIdentityReference(alwaysAsId=true)
public class Soba implements Serializable{
    private int id;
    private String tipNaSoba;
    private int brSoba;
    private boolean klima;
    private boolean parno;
    private boolean terasa;
    private boolean pogled;
    private boolean internet;
    private boolean televizor;
    private Hotel hotelByHotelId;
    private int cena;

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Soba(String tipNaSoba, int brSoba, boolean klima, boolean parno, boolean terasa, boolean pogled, boolean internet, boolean televizor, Hotel hotelByHotelId, int cena) {
        this.tipNaSoba = tipNaSoba;
        this.brSoba = brSoba;
        this.klima = klima;
        this.parno = parno;
        this.terasa = terasa;
        this.pogled = pogled;
        this.internet = internet;
        this.televizor = televizor;
        this.hotelByHotelId = hotelByHotelId;
        this.cena = cena;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soba that = (Soba) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Basic
    @Column(name = "tip_na_soba")
    public String getTipNaSoba() {
        return tipNaSoba;
    }

    public void setTipNaSoba(String tipNaSoba) {
        this.tipNaSoba = tipNaSoba;
    }

    @Basic
    @Column(name = "br_soba")
    public Integer getBrSoba() {
        return brSoba;
    }

    public void setBrSoba(Integer brSoba) {
        this.brSoba = brSoba;
    }

    @Basic
    @Column(name = "klima")
    public boolean getKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    @Basic
    @Column(name = "parno")
    public boolean getParno() {
        return parno;
    }

    public void setParno(boolean parno) {
        this.parno = parno;
    }

    @Basic
    @Column(name = "terasa")
    public boolean getTerasa() {
        return terasa;
    }

    public void setTerasa(boolean terasa) {
        this.terasa = terasa;
    }

    @Basic
    @Column(name = "pogled")
    public boolean getPogled() {
        return pogled;
    }

    public void setPogled(boolean pogled) {
        this.pogled = pogled;
    }

    @Basic
    @Column(name = "internet")
    public boolean getInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    @Basic
    @Column(name = "televizor")
    public boolean getTelevizor() {
        return televizor;
    }

    public void setTelevizor(boolean televizor) {
        this.televizor = televizor;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "ID",insertable=false, updatable=false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel  hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public Soba() {
    }

    public void setBrSoba(int brSoba) {
        this.brSoba = brSoba;
    }
}

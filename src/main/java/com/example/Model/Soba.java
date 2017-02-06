package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "soba", schema = "example" )
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",scope =Soba.class)
@JsonIdentityReference(alwaysAsId=true)
public class Soba implements Serializable{
    private int id;
    private Hotel hotelByHotel;
    private String tipNaSoba;
    private Integer brSoba;
    private Byte klima;
    private Byte parno;
    private Byte terasa;
    private Byte pogled;
    private Byte internet;
    private Byte televizor;
    private Hotel hotelByHotelId;
    private int cena;

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Soba(Hotel hotelByHotel, String tipNaSoba, Integer brSoba, Byte klima, Byte parno, Byte terasa, Byte pogled, Byte internet, Byte televizor, Hotel hotelByHotelId, int cena) {
        this.hotelByHotel = hotelByHotel;
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

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "ID")
    public Hotel  getHotelByHotel() {
        return hotelByHotel;
    }

    public void setHotelByHotel(Hotel hotelByHotel) {
        this.hotelByHotel = hotelByHotel;
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
    public Byte getKlima() {
        return klima;
    }

    public void setKlima(Byte klima) {
        this.klima = klima;
    }

    @Basic
    @Column(name = "parno")
    public Byte getParno() {
        return parno;
    }

    public void setParno(Byte parno) {
        this.parno = parno;
    }

    @Basic
    @Column(name = "terasa")
    public Byte getTerasa() {
        return terasa;
    }

    public void setTerasa(Byte terasa) {
        this.terasa = terasa;
    }

    @Basic
    @Column(name = "pogled")
    public Byte getPogled() {
        return pogled;
    }

    public void setPogled(Byte pogled) {
        this.pogled = pogled;
    }

    @Basic
    @Column(name = "internet")
    public Byte getInternet() {
        return internet;
    }

    public void setInternet(Byte internet) {
        this.internet = internet;
    }

    @Basic
    @Column(name = "televizor")
    public Byte getTelevizor() {
        return televizor;
    }

    public void setTelevizor(Byte televizor) {
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
    public Soba(String id){
        this.id = Integer.parseInt(id);
    }

    public Soba() {
    }
}

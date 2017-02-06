package com.example.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


public class OcenaNaHotelPK implements Serializable {
    private int id;
    private int idHotel;

    @Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_hotel")
    @Id
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OcenaNaHotelPK that = (OcenaNaHotelPK) o;

        if (id != that.id) return false;
        if (idHotel != that.idHotel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idHotel;
        return result;
    }
}

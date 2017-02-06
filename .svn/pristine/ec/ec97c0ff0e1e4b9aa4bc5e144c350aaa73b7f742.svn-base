package com.example.Model;

import javax.persistence.*;


@Entity
@Table(name = "validiraj", schema = "example", catalog = "")
public class Validiraj  {
    private int id;
    private String validiraj;
    private Hotel  hotelByIdHotel;
    private Validator  validatorByIdValidator;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "validiraj")
    public String getValidiraj() {
        return validiraj;
    }

    public void setValidiraj(String validiraj) {
        this.validiraj = validiraj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Validiraj  that = (Validiraj ) o;

        if (id != that.id) return false;
        if (validiraj != null ? !validiraj.equals(that.validiraj) : that.validiraj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (validiraj != null ? validiraj.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public Hotel  getHotelByIdHotel() {
        return hotelByIdHotel;
    }

    public void setHotelByIdHotel(Hotel  hotelByIdHotel) {
        this.hotelByIdHotel = hotelByIdHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_validator", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public Validator  getValidatorByIdValidator() {
        return validatorByIdValidator;
    }

    public void setValidatorByIdValidator(Validator  validatorByIdValidator) {
        this.validatorByIdValidator = validatorByIdValidator;
    }
}

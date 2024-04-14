package com.ttknpdev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    private String cid;
    private String brand;
    private String model;
    private Float price;
    private String releaseDate; // -> release_date

    // way to work(access) with relation table
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable( // ***
            name = "cars_engines",
            joinColumns = {
                    // mean to access cars.cid and referent cars_engines.cid
                    @JoinColumn(name = "cid", referencedColumnName = "cid")
            },
            inverseJoinColumns = {
                    // mean to access engines.eid and referent cars_engines.eid
                    @JoinColumn(name = "eid", referencedColumnName = "eid")
            })
    private Engine engine;

    public Car(String cid, String brand, String model, Float price, String releaseDate, Engine engine) {
        this.cid = cid;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.releaseDate = releaseDate;
        this.engine = engine;
    }
    // must have default constructor
    public Car() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid='" + cid + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", releaseDate='" + releaseDate + '\'' +
                ", engine=" + engine +
                '}';
    }
}

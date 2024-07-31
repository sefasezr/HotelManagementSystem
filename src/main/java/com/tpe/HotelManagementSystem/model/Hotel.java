package com.tpe.HotelManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//2.adım hotel isimli bir class olusturduk ve bu classi entegre edebilmek icin entity ve table anotasyonlarını kullandık
@Entity
@Table(name = "tbl_hotels")
public class Hotel {

    //3.adım primary key yani id olusturma
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.AUTO otomatik deger atamasi saglar//GenerationType.IDENTITY deger atamasini databse yapıyor
    //GenerationType.SEQUENCE: istediğimiz sayıdan başlayıp kaçarlı istersek artırarak otomatik atama yaptırabiliyoruz
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    //private List<Room> rooms = new ArrayList<>();

    //4.adım daha hızlı deger atamas ıyapabilmek icin constructor olusturdum

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Hotel() {}

    //5.adım degerlerime erişebilmek icin getter setter metodlarını olusturdum


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //toString ekledik
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    //Room isimli classı olusturucaz ve room uzerinde getter setter ve to stringi eklemeyi unutma
}

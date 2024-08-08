package com.tpe.HotelManagementSystem.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//2.adım hotel isimli bir class olusturdum ve bu classi entegre edebilmek icin entity ve table anotasyonlarını kullandım
@Entity
@Table(name = "t_hotel")
public class Hotel {

    //3.adım primary key yani id olusturma
    @Id//id sütununun primary key olacağını gösterir
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.AUTO otomatik deger atamasi saglar//GenerationType.IDENTITY deger atamasini databse yapıyor
    //GenerationType.SEQUENCE: istediğimiz sayıdan başlayıp kaçarlı istersek artırarak otomatik atama yaptırabiliyoruz
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    //orphanRemoval
    //A otelinin odaları: 11,12,13
    //A otelinin oda listesinden 11i çıkarırsam:room tabledan 11i siler.

    //CascadeTypeREMOVE ise
    //A otelinin odaları: 11,12,13
    //A otelinin oda listesinden 11i çıkarırsam:room tableda 11 hala var
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.REMOVE)//hotel ile room arasında ilişki kurulmasını sağlar
    private List<Room> rooms = new ArrayList<>();

    //4.adım daha hızlı deger atamas ıyapabilmek icin constructor olusturdum

    //param const
    public Hotel(Long id, String name, String location) {
        this.name = name;
        this.location = location;
    }

    //hibernate data çekerken(fetch) default constructorı kullanır.
    public Hotel() {}

    //5.adım degerlerime erişebilmek icin getter setter metodlarını olusturdum


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    //toString ekledik


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}

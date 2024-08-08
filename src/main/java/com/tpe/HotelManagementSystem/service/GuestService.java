package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.domain.Address;
import com.tpe.HotelManagementSystem.domain.Guest;
import com.tpe.HotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.HotelManagementSystem.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestService {
    Scanner scan  = new Scanner(System.in);

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest findGuestById(Long guestId) {

        try{
            Guest foundGuest = guestRepository.findById(guestId);
            if(foundGuest != null){
                System.out.println("*----------------------------------*");
                System.out.println(foundGuest);
                return foundGuest;
            }else{
                throw new GuestNotFoundException("Guest not found with id " + guestId);
            }
        }catch (GuestNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void getAllGuest() {
        List<Guest> guests = guestRepository.findAll();
        if(!guests.isEmpty()){
            for(Guest guest : guests){
                System.out.println(guest);
            }
            System.out.println("----------------------");
        }else{
            System.out.println("Guests is empty");
        }
    }

    public void deleteGuestById(Long deletedGuestId) {
        Guest foundGuest = guestRepository.findById(deletedGuestId);
        //guestin rezervasyonları varsa orphanremoval ile bunlar otomatik silinsin
        if(foundGuest != null){
            guestRepository.delete(foundGuest);
            System.out.println("Guest is removed successfully..Guest id : "+foundGuest.getId());
        }
    }

    public void saveGuest() {
        Guest guest = new Guest();

        System.out.println("Enter guest name : ");
        guest.setName(scan.nextLine());

        Address address = new Address();

        System.out.println("Enter street : ");
        address.setStreet(scan.nextLine());
        System.out.println("Enter city : ");
        address.setCity(scan.nextLine());
        System.out.println("Enter country : ");
        address.setCountry(scan.nextLine());
        System.out.println("Enter zipcode : ");
        address.setZipcode(scan.nextInt());

        guest.setAddress(address);

        guestRepository.save(guest);
        System.out.println("Guest is saved successfully...");

    }
}

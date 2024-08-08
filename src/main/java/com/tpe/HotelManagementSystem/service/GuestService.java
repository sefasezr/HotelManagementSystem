package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.domain.Guest;
import com.tpe.HotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.HotelManagementSystem.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestService {
    Scanner scan  = new Scanner(System.in);
    GuestRepository guestRepository;
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest findGuestById(Long guestId) {
        Guest foundGuest = guestRepository.findById(guestId);
        try{
            if(foundGuest != null){
                System.out.println(foundGuest);
                return foundGuest;
            }else{
                throw new GuestNotFoundException("Guest not found");
            }
        }catch (GuestNotFoundException e){
            e.printStackTrace();
            return null;
        }
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

    public void deleteGuest(Long deletedGuestId) {
        Guest foundGuest = guestRepository.findById(deletedGuestId);
        if(foundGuest != null){
            System.out.println(foundGuest);
            System.out.println("Are you sure to delete this hotel? : ");
            System.out.println("Please answer with Y or N");
            String select = scan.nextLine();

            if(select.equalsIgnoreCase("Y")){
                guestRepository.delete(foundGuest);
                System.out.println("Room deleted successfully.");
            }else{
                System.out.println("Delete operation is CANCELLED!!!");
            }
        }
    }
}

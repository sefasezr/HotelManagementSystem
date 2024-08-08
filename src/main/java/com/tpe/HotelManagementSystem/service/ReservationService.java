package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.domain.Guest;
import com.tpe.HotelManagementSystem.domain.Reservation;
import com.tpe.HotelManagementSystem.domain.Room;
import com.tpe.HotelManagementSystem.exception.ReservationNotFoundException;
import com.tpe.HotelManagementSystem.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationService {
    Scanner scan = new Scanner(System.in);

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;
    private final GuestService guestService;

    public ReservationService(ReservationRepository reservationRepository, RoomService roomService, GuestService guestService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
        this.guestService = guestService;
    }

    public Reservation findReservationById(Long reservationId) {
        Reservation foundReservation = reservationRepository.findById(reservationId);
        try {
            if (foundReservation != null) {
                System.out.println(foundReservation);
                return foundReservation;
            }else{
                throw new ReservationNotFoundException("Reservation not found with id " + reservationId);
            }
        }catch (ReservationNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void getAllReservation() {
        List<Reservation> reservations = reservationRepository.findAll();
        if(!reservations.isEmpty()){
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
            System.out.println("---------------------------------------");
        }else{
            System.out.println("Reservation list is empty");
        }
    }

    public void deleteReservation(Long deleteId) {
        Reservation foundReservation = reservationRepository.findById(deleteId);
        if (foundReservation != null) {
            reservationRepository.delete(foundReservation);
            System.out.println("Reservation is cancelled successfully.. Reservation id: "+foundReservation.getId());
        }
    }

    public void createReservation() {
        Reservation reservation = new Reservation();

        //girilen tarihlerin uygunluğu kontrol edilmiş gibi varsayıcam çünkü tarih girişi böyle olmaz
        System.out.println("Enter check-in date (yyyy-MM-dd) :");
        reservation.setCheckInDate(LocalDate.parse(scan.nextLine()));

        System.out.println("Enter check-out date (yyyy-MM-dd) :");
        reservation.setCheckOutDate(LocalDate.parse(scan.nextLine()));

        System.out.println("Enter Room ID : ");
        Long roomId = scan.nextLong();
        Room foundRoom = roomService.findRoomById(roomId);

        System.out.println("Enter Guest ID : ");
        Long guestId = scan.nextLong();
        scan.nextLine();
        Guest foundGuest = guestService.findGuestById(guestId);

        if (foundRoom != null && foundGuest != null) {
            reservation.setRoom(foundRoom);
            reservation.setGuest(foundGuest);
            reservationRepository.save(reservation);
            System.out.println("Reservation saved successfully.");
        }else{
            System.out.println("Reservation could not saved!!!");
        }
    }
}

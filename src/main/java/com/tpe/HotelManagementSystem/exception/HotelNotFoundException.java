package com.tpe.HotelManagementSystem.exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String message) {
        super(message);
    }
}
//ödev:RoomNotFoundException, ReservationNotFoundException, GuestNotFoundException
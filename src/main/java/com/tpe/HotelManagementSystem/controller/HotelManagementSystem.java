package com.tpe.HotelManagementSystem.controller;

import com.tpe.HotelManagementSystem.config.HibernateUtils;
import com.tpe.HotelManagementSystem.repository.GuestRepository;
import com.tpe.HotelManagementSystem.repository.HotelRepository;
import com.tpe.HotelManagementSystem.repository.ReservationRepository;
import com.tpe.HotelManagementSystem.repository.RoomRepository;
import com.tpe.HotelManagementSystem.service.GuestService;
import com.tpe.HotelManagementSystem.service.HotelService;
import com.tpe.HotelManagementSystem.service.ReservationService;
import com.tpe.HotelManagementSystem.service.RoomService;

import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    //ana menü
    public static void displayHotelManagementSystemMenu(){
        //sadece bir tane hotel repo oluşturdum tüm uygulamada kullanabiliriz artık
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        RoomRepository roomRepository = new RoomRepository();
        RoomService roomService = new RoomService(roomRepository, hotelService);

        GuestRepository guestRepository = new GuestRepository();
        GuestService guestService = new GuestService(guestRepository);

        ReservationRepository reservationRepository  = new ReservationRepository();
        ReservationService reservationService = new ReservationService(reservationRepository,roomService,guestService);


        boolean exit = false;

        while(!exit){
            System.out.println("========= Hotel Management System Menu =========");
            System.out.println("1.Hotel Operations");
            System.out.println("2.Room Operations");
            System.out.println("3.Guest Operations");
            System.out.println("4.Reservation Operations");
            System.out.println("0.Exit");
            System.out.println("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    displayHotelOperationsMenu(hotelService);
                    break;
                case 2:
                    displayRoomOperationsMenu(roomService);
                    break;
                case 3:
                    displayGuestOperationsMenu(guestService);
                    break;
                case 4:
                    displayReservationOperationsMenu(reservationService);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good Bye...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }


        }
    }

    //hotel operations
    private static void displayHotelOperationsMenu(HotelService hotelService){

        System.out.println("Hotel Operation Menu");

        boolean exit = false;
        while(!exit){
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new Hotel");
            System.out.println("2. Find Hotel by ID");
            System.out.println("3. Delete Hotel by ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel by ID");
            System.out.println("0. Return to main menu");
            System.out.println("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    hotelService.saveHotel();
                    break;
                case 2:
                    //2-a:hotel bulma
                    System.out.println("Enter hotel ID : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    hotelService.findHotelById(id);
                    break;
                case 3:
                    //7-a : hotel silme
                    System.out.println("Enter hotel ID : ");
                    Long hotelId = scanner.nextLong();
                    scanner.nextLine();
                    hotelService.deleteHotel(hotelId);
                    break;
                case 4:
                    //3-a: tüm hotelleri listeleme
                    hotelService.getAllHotels();
                    break;
                case 5:
                    //8-a: hotel güncelleme
                    System.out.println("Enter hotel ID : ");
                    Long updatedHotelId = scanner.nextLong();
                    scanner.nextLine();
                    hotelService.updateHotelById(updatedHotelId);

                    break;
                case 0:
                    exit = true;
                    System.out.println("Return to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        }

    }

    //room operations
    private static void displayRoomOperationsMenu(RoomService roomService){

        System.out.println("Room Operation Menu");
        boolean exit = false;
        while(!exit){
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new Room");
            System.out.println("2. Find Room by ID");
            System.out.println("3. Delete Room by ID");
            System.out.println("4. Find All Rooms");
            System.out.println("0. Return to main menu");
            System.out.println("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    //4-a : oda ekleme
                    roomService.saveRoom();
                    break;
                case 2:
                    //5-a :
                    System.out.println("Enter room ID : ");
                    Long roomId = scanner.nextLong();
                    scanner.nextLine();
                    roomService.findRoomById(roomId);
                    break;
                case 3:
                    System.out.println("Enter room ID : ");
                    Long deletedRoomId = scanner.nextLong();
                    scanner.nextLine();
                    roomService.deleteRoom(deletedRoomId);
                    break;
                case 4:
                    //6-a:
                    roomService.getAllRooms();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Return to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        }
    }

    //guest operations
    private static void displayGuestOperationsMenu(GuestService guestService){
        System.out.println("Guest Operation Menu");

        boolean exit = false;
        while(!exit){
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new Guest");
            System.out.println("2. Find Guest by ID");
            System.out.println("3. Delete Guest by ID");
            System.out.println("4. Find All Guests");
            System.out.println("0. Return to main menu");
            System.out.println("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    guestService.saveGuest();
                    break;
                case 2:
                    System.out.println("Enter the guest ID : ");
                    Long guestId = scanner.nextLong();
                    scanner.nextLine();
                    guestService.findGuestById(guestId);
                    break;
                case 3:
                    System.out.println("Enter guest ID : ");
                    Long deletedGuestId = scanner.nextLong();
                    scanner.nextLine();
                    guestService.deleteGuestById(deletedGuestId);
                    break;
                case 4:
                    guestService.getAllGuest();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Return to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        }
    }

    //reservation operations
    private static void displayReservationOperationsMenu(ReservationService reservationService){
        System.out.println("Reservation Operation Menu");

        boolean exit = false;
        while(!exit){
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new Reservation");
            System.out.println("2. Find Reservation by ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation by ID");
            System.out.println("0. Return to main menu");
            System.out.println("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    reservationService.createReservation();
                    break;
                case 2:
                    System.out.println("Enter the reservation ID : ");
                    Long reservationId = scanner.nextLong();
                    scanner.nextLine();
                    reservationService.findReservationById(reservationId);
                    break;
                case 3:
                    reservationService.getAllReservation();
                    break;
                case 4:
                    System.out.println("Enter reservation ID : ");
                    Long deleteId = scanner.nextLong();
                    scanner.nextLine();
                    reservationService.deleteReservation(deleteId);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Return to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        }
    }


}

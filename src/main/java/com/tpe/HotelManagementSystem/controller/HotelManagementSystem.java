package com.tpe.HotelManagementSystem.controller;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.repository.HotelRepository;
import com.tpe.HotelManagementSystem.service.HotelService;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    //ana menü
    public static void displayHotelManagementSystemMenu(){
        //sadece bir tane hotel repo oluşturdum tüm uygulamada kullanabiliriz artık
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

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
                    displayRoomOperationsMenu();
                    break;
                case 3:
                    displayGuestOperationsMenu();
                    break;
                case 4:
                    displayReservationOperationsMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good Bye...");
                    HibernateUtil.shutDown();
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
                    break;
                case 4:
                    //3-a: tüm hotelleri listeleme
                    hotelService.getAllHotels();
                    break;
                case 5:
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
    private static void displayRoomOperationsMenu(){

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
    private static void displayGuestOperationsMenu(){
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
    private static void displayReservationOperationsMenu(){
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

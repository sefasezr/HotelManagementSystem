package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.domain.Hotel;
import com.tpe.HotelManagementSystem.domain.Room;
import com.tpe.HotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.HotelManagementSystem.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

//serviceler servicelerle veya kendi repoları ile iletişime geçer

public class RoomService {
    private Scanner scan  = new Scanner(System.in);

    private final HotelService hotelService;

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository, HotelService hotelService) {
        this.roomRepository = roomRepository;
        this.hotelService = hotelService;
    }

    //4-b
    public void saveRoom(){

        Room room = new Room();

        System.out.println("Enter room ID : ");
        room.setId(scan.nextLong());
        scan.nextLine();

        System.out.println("Enter room number : ");
        room.setNumber(scan.nextLine());

        System.out.println("Enter room capacity : ");
        room.setCapacity(scan.nextInt());
        scan.nextLine();

        System.out.println("Enter hotel ID : ");
        Long hotelId = scan.nextLong();
        scan.nextLine();

        Hotel foundHotel = hotelService.findHotelById(hotelId);
        if(foundHotel != null){
            room.setHotel(foundHotel);//oda hangi otele aitse set edildi.

            //t_room tablosunda hotel_id sütununa bulunan otelin sadece idsini ekler

            //bu odayı otelin oda listesine ekleyelim.
            //Ancak uygulamada çift yönlü bir ilişki kurup hotel tarafında mappedBy yaptığımız için manuel eklemeye gerek klamadı
            //foundHotel.getRooms().add(room);  --->mappedBy bu işlemi bizim yerimize yapıyor.

            roomRepository.save(room);//tabloya eklendi
            System.out.println("Room is saved successfully. Room ID : "+room.getId());
        }else{
            System.out.println("Room could not saved!!!");
        }


    }
    //5-b : Id si verilen odayı tablodan bulup yazdırma ve geri dondurme
    public Room findRoomById(Long roomId) {
        Room foundRoom = roomRepository.findById(roomId);
        try{
            if(foundRoom != null){
                System.out.println(foundRoom);
                return foundRoom;
            }else{
                throw new RoomNotFoundException("Room not found by ID : "+roomId);
            }
        }catch (RoomNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    //6-b eger tablo bos degilse tum listeleri goruntulerim
    public void getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        if(!rooms.isEmpty()){
            for(Room room : rooms){
                System.out.println(room);
            }
            System.out.println("-----------------------------------------------------");
        }else{
            System.out.println("Room List is empty");
        }
    }

    public void deleteRoom(Long deletedRoomId) {
        Room foundRoom = roomRepository.findById(deletedRoomId);
        if(foundRoom != null){
            System.out.println(foundRoom);
            System.out.println("Are you sure to delete this hotel? : ");
            System.out.println("Please answer with Y or N");
            String select = scan.nextLine();

            if(select.equalsIgnoreCase("Y")){
                roomRepository.delete(foundRoom);
                System.out.println("Room deleted successfully.");
            }else{
                System.out.println("Delete operation is CANCELLED!!!");
            }
        }
    }
}

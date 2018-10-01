

package jrobokill;

import java.util.ArrayList;

public class GenerateRooms
{
    public ArrayList<Room> roomsArray;

    public GenerateRooms() 
    {
        roomsArray = new ArrayList<Room>();

        //fe'lan hame dar ha ro az noe 1 yani bedoone niaz be key gereftam
        // age bekhaym 1 daro avaz konim bayad hamoon dar to otagh baghalisham avaz konim
        // masalan dare shomalie otaghe 1 mishe dare jonoobie otaghe 2

        // Making room 1 :
        //Creating 4 borders for a room
        Border room1North = new Border(1, 1, 2); // ye divar az noe 1 (dari ke kilid nemikhad) beyne otagh haye 1 & 2
        Border room1East = new Border(0, 1, 0); // ye divare az noe 0 (divare khali bedoone dar) beyne otaghe 1 & fazaye khalie biroon
        Border room1South = new Border(0, 1, 0);
        Border room1West = new Border(0, 1, 0);
        // Defining the matrix
        int[][] sc = new int[15][11];
        //Creating a room with borders that were made before
        Room room1 = new Room(1, room1North, room1East, room1South, room1West);
        // Determining position of room in map
        room1.setRoomPositionInMap(300, 700);
        // Setting room status
        room1.setRoomStatus(1);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room1);

        // Making room 2:
        //Creating 4 borders for a room
        Border room2North = new Border(1, 2, 3); // in dare beyne otaghe 2 , 3
        Border room2East = new Border(0, 2, 0);
        Border room2South = new Border(1, 1, 2); // divare jonoobie otaghe 2 ke mishe hamoon divare shomalie otaghe 1 ke payinesh
        Border room2West = new Border(0, 2, 0);
        //Creating a room with borders that were made before
        Room room2 = new Room(2, room2North, room2East, room2South, room2West);
        // Determining position of room in map
        room2.setRoomPositionInMap(300, 670);
        // Setting room status
        room2.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room2);

        // Making room 3:
        //Creating 4 borders for a room
        Border room3North = new Border(1, 3, 4);
        Border room3East = new Border(0, 3, 0);
        Border room3South = new Border(1, 2, 3);
        Border room3West = new Border(0, 3, 4);
        //Creating a room with borders that were made before
        Room room3 = new Room(3, room3North, room3East, room3South, room3West);
        // Determining position of room in map
        room3.setRoomPositionInMap(300, 640);
        // Setting room status
        room3.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room3);

        // Making room 4:
        //Creating 4 borders for a room
        Border room4North = new Border(2, 4, 5); // reqiures key
        Border room4East = new Border(1, 4, 6);
        Border room4South = new Border(1, 3, 4);
        Border room4West = new Border(2, 4, 7);// reqiures key
        //Creating a room with borders that were made before
        Room room4 = new Room(4, room4North, room4East, room4South, room4West);
        // Determining position of room in map
        room4.setRoomPositionInMap(300, 610);
        // Setting room status
        room4.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room4);

        // Making room 5:
        //Creating 4 borders for a room
        Border room5North = new Border(1, 5, 10);
        Border room5East = new Border(0, 5, 0);
        Border room5South = new Border(2, 4, 5); // reqiures key
        Border room5West = new Border(0, 5, 0);
        //Creating a room with borders that were made before
        Room room5 = new Room(5, room5North, room5East, room5South, room5West);
        // Determining position of room in map
        room5.setRoomPositionInMap(300, 580);
        // Setting room status
        room5.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room5);

        // Making room 6:
        //Creating 4 borders for a room
        Border room6North = new Border(0, 6, 0);
        Border room6East = new Border(1, 6, 8);
        Border room6South = new Border(0, 6, 0);
        Border room6West = new Border(1, 4, 6);
        //Creating a room with borders that were made before
        Room room6 = new Room(6, room6North, room6East, room6South, room6West);
        // Determining position of room in map
        room6.setRoomPositionInMap(340, 610);
        // Setting room status
        room6.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room6);

        // Making room 7:
        //Creating 4 borders for a room
        Border room7North = new Border(0, 7, 0);
        Border room7East = new Border(2, 4, 7);// reqiures key
        Border room7South = new Border(0, 7, 0);
        Border room7West = new Border(1, 7, 9);
        //Creating a room with borders that were made before
        Room room7 = new Room(7, room7North, room7East, room7South, room7West);
        // Determining position of room in map
        room7.setRoomPositionInMap(260, 610);
        // Setting room status
        room7.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room7);

        // Making room 8:
        //Creating 4 borders for a room
        Border room8North = new Border(0, 8, 0);
        Border room8East = new Border(0, 8, 0);
        Border room8South = new Border(0, 8, 0);
        Border room8West = new Border(1, 6, 8);
        //Creating a room with borders that were made before
        Room room8 = new Room(8, room8North, room8East, room8South, room8West);
        // Determining position of room in map
        room8.setRoomPositionInMap(380, 610);
        // Setting room status
        room8.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room8);

        // Making room 9:
        //Creating 4 borders for a room
        Border room9North = new Border(2, 9, 13); // reqiures key
        Border room9East = new Border(1, 7, 9);
        Border room9South = new Border(1, 9, 14);
        Border room9West = new Border(0, 9, 0);
        //Creating a room with borders that were made before
        Room room9 = new Room(9, room9North, room9East, room9South, room9West);
        // Determining position of room in map
        room9.setRoomPositionInMap(220, 610);
        // Setting room status
        room9.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room9);

        // Making room 10:
        //Creating 4 borders for a room
        Border room10North = new Border(1, 10, 11);
        Border room10East = new Border(0, 10, 0);
        Border room10South = new Border(1, 5, 10);
        Border room10West = new Border(0, 10, 0);
        //Creating a room with borders that were made before
        Room room10 = new Room(10, room10North, room10East, room10South, room10West);
        // Determining position of room in map
        room10.setRoomPositionInMap(300, 550);
        // Setting room status
        room10.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room10);

        // Making room 11:
        //Creating 4 borders for a room
        Border room11North = new Border(0, 11, 0);
        Border room11East = new Border(1, 11, 12);
        Border room11South = new Border(1, 10, 11);
        Border room11West = new Border(0, 11, 0);
        //Creating a room with borders that were made before
        Room room11 = new Room(11, room11North, room11East, room11South, room11West);
        // Determining position of room in map
        room11.setRoomPositionInMap(300, 520);
        // Setting room status
        room11.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room11);

        // Making room 12:
        //Creating 4 borders for a room
        Border room12North = new Border(1, 15, 12);
        Border room12East = new Border(0, 12, 0);
        Border room12South = new Border(0, 12, 10);
        Border room12West = new Border(1, 11, 12);
        //Creating a room with borders that were made before
        Room room12 = new Room(12, room12North, room12East, room12South, room12West);
        // Determining position of room in map
        room12.setRoomPositionInMap(340, 520);
        // Setting room status
        room12.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room12);

        // Making room 13:
        //Creating 4 borders for a room
        Border room13North = new Border(0, 0, 13);
        Border room13East = new Border(0, 0, 13);
        Border room13South = new Border(2, 9, 13);// reqiures key
        Border room13West = new Border(0, 0, 13);
        //Creating a room with borders that were made before
        Room room13 = new Room(13, room13North, room13East, room13South, room13West);
        // Determining position of room in map
        room13.setRoomPositionInMap(220, 580);
        // Setting room status
        room13.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room13);

        // Making room 14:
        //Creating 4 borders for a room
        Border room14North = new Border(1, 9, 14);
        Border room14East = new Border(0, 0, 14);
        Border room14South = new Border(0, 0, 14);
        Border room14West = new Border(0, 0, 14);
        //Creating a room with borders that were made before
        Room room14 = new Room(14, room14North, room14East, room14South, room14West);
        // Determining position of room in map
        room14.setRoomPositionInMap(220, 640);
        // Setting room status
        room14.setRoomStatus(0);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room14);

        // Making room 15:
        //Creating 4 borders for a room
        Border room15North = new Border(0, 15, 0);
        Border room15East = new Border(0, 15, 0);
        Border room15South = new Border(1, 12, 15);
        Border room15West = new Border(0, 15, 0);
        //Creating a room with borders that were made before
        Room room15 = new Room(15, room15North, room15East, room15South, room15West);
        // Determining position of room in map
        room15.setRoomPositionInMap(340, 490);
        // Setting room status
        room15.setRoomStatus(3);
        // Adding the new room to the arraylist roomsArray
        roomsArray.add(room15);
    }
    
    
    
}

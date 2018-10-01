package jrobokill;

import java.util.ArrayList;

public class Room {

    private Robot robot;

    public ArrayList<Border> borders; // This arraylist is a field that contains 4 walls around each room

    public ArrayList<Thing> things;

    public ArrayList<Box> boxes;
    
    public ArrayList<EnemyWithGun> enemiesWG; // with gun
    
    public ArrayList<EnemyWithoutGun> enemiesWOG; //without gun

    private int roomNumber; // This variable is to determine the number of the room
    private int xPosition, yPosition; // Position of this room in the map
    
    public int[][] screenArray;

    // borders.get(0) ===> northern wall
    // borders.get(1) ===> eastern wall
    // borders.get(2) ===> southern wall
    // borders.get(3) ===> western wall
    private int roomStatus; //This field represent the status of room
    // 0 ===> room which is not passed
    // 1 ===> room that right now the robot is in
    // 2 ===> room that is passed and cleaned
    // 3 ===> room which is the target (hamoon ke star dare)

    // Constructor :
    public Room(int roomNumber, Border northern, Border eastern, Border southern, Border western ) {
        screenArray = new int[15][11];
        borders = new ArrayList<Border>();
        // Setting the room number
        this.roomNumber = roomNumber;
        //Adding constructor parameters to ArrayList "borders" :
        this.borders.add(northern);
        this.borders.add(eastern);
        this.borders.add(southern);
        this.borders.add(western);
        
    }

    // Getter for roomNumber
    public int getRoomNumber() {
        return roomNumber;
    }

    // Setter for xPosition and yPosition (position of room in the map)
    public void setRoomPositionInMap(int x, int y) {
        xPosition = x;
        yPosition = y;
    }

    // Getters for xPosition and yPosition
    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int s) {
        roomStatus = s;
    }

    public void setRobot(Robot r) {
        this.robot = r;
    }

    public Robot getRobot() {
        return robot;
    }


public void crossOfThings(){
    for(Thing t:things){
        switch(t.getCondition()){
            case 1:
                robot.setShield(robot.getShield() + 10);
                break;
                
            case 2:
                robot.setCash(robot.getCash() + 20);
                break;
                
            case 3: 
                robot.setShield(robot.getShield()+ 20);
                break;
                 
            case 4:
                 //shop will be newed here!!
                
            
               
        }
        
    }
}
    
    
    
}

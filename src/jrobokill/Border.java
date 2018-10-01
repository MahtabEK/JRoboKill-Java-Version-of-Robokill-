
package jrobokill;

import java.util.ArrayList;


public class Border 
{
    public ArrayList<Integer> betweenWhichRooms;
    public int typeOfBorder; // This Field shows the type of this border
    // 0 ===> a wall without a door
    // 1 ===> door that doesn't require a key to open
    // 2 ===> door that requires a key to open 
    // in adada ro fe'lan movaghat gozashtam hala rooshon fekr mikonim

    public Border(int typeOfBorder, int room1 , int room2)
    // room1 and room2 are numbers of rooms which this border is located between them
    {
        betweenWhichRooms = new ArrayList<Integer>();
        // Setting the field "typeOfBorder" through constructor parameters
        this.typeOfBorder = typeOfBorder;
        //Setting the field "betweenWhichRooms" 
        betweenWhichRooms.add(room1);
        betweenWhichRooms.add(room2);
    }
    
    
}

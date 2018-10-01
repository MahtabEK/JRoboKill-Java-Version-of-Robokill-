
package jrobokill;

import java.util.ArrayList;


public class Key 
{
    public ArrayList<Integer> betweenWhichRooms;

    public Key(int a, int b) 
    {
        betweenWhichRooms = new ArrayList<Integer>();
        betweenWhichRooms.add(a);
        betweenWhichRooms.add(b);
    }
}

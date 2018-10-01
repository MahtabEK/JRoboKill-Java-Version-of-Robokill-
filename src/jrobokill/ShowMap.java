

package jrobokill;


import java.util.ArrayList;
import javax.swing.*;

public class ShowMap extends JFrame
{
    
    public ShowMap(ArrayList<Room> roomsArray)
    {
        super("Show Map");
        this.setLayout(null);
        this.setSize(1200,1200);
        //ShowMapPanel mapPanel = new ShowMapPanel();
        //mapPanel.setLocation(100,100);
        //this.add(mapPanel);
        //GameEngine g = new GameEngine();
        ShowMapPanel mapPanel = new ShowMapPanel(roomsArray);
        mapPanel.setLocation(100,100);
        this.add(mapPanel);
//        g.setLocation(0,0);
//        this.add(g);
//        RoomPanel roomPanel = new RoomPanel();
//        roomPanel.setLocation(100,100);
//        this.add(roomPanel);
    }
        
    
    
}

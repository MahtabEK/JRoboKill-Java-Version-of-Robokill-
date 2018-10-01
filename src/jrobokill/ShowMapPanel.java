/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrobokill;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class ShowMapPanel extends JPanel
{

    // Defining Image Icons
    Image notpassed = (new ImageIcon(getClass().getResource("notpassed.png"))).getImage();
    Image passed = (new ImageIcon(getClass().getResource("passed.png"))).getImage();
    Image here = (new ImageIcon(getClass().getResource("here.png"))).getImage();
    Image target = (new ImageIcon(getClass().getResource("target.png"))).getImage();
    
    Image roomImage;
    int x , y;
    
    public ArrayList<Room> roomsArray;
    
    public ShowMapPanel(ArrayList<Room> roomsArray)
    {
        this.roomsArray = new ArrayList<Room>();
        this.setBackground(Color.DARK_GRAY);
        this.setSize(800,800);
        //GameEngine g = new GameEngine();
        GenerateRooms g = new GenerateRooms();
//        roomsArray = g.roomsArray;
        this.roomsArray = roomsArray;
       // makeRoomsAndBorders();
        //paintAllRoomsInMap();
        repaint();
        
    }
    @Override
    public void paint(Graphics g) // kolle keshidane khhone ha ro bayad too paint bezarim
    {
        super.paint(g);
        for( Room r : roomsArray)
        {
            // Setting icon of room according to room status
            switch(r.getRoomStatus())
            {
                case 0: roomImage = notpassed; break;
                case 1: roomImage = here; break;   
                case 2: roomImage = passed; break;
                case 3: roomImage = target; break;   
            }
            x = r.getXPosition();
            y = r.getYPosition();
            g.drawImage(roomImage, x, y, null);
        }
    }
    
}

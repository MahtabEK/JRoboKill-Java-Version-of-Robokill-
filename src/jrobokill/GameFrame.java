

package jrobokill;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameFrame extends JFrame
{
    JButton map;
    public GameFrame() 
    { // too in har componenti gozadhtim hatttttmaaaannnn focusable esh ro false bayad bokonim
        super("Game Frame");
        this.setLayout(null);
        this.setSize(1200,1200);
        GameEngine gameEngine = new GameEngine();
        gameEngine.setLocation(0,0);
        this.add(gameEngine);
        map = new JButton("map");
        map.setSize(100,40);
        map.setLocation(900,900);
        map.setFocusable(false);
        this.add(map);
        map.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed (ActionEvent event)
                    {
                        ShowMap map = new ShowMap(gameEngine.roomsArray);
//                        map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        map.setVisible(true);
                    }
                }  
        ); 
    }
    
}

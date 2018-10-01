
package jrobokill;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
// Chizayi ke moonde: gozashtane key to jabe, gozashtane weapon, doshman dar biad az toosh, vaghti tir khord tire mahv beshe, enfejar
public class Bullet implements Runnable
{
    public double xOfBullet , yOfBullet ;
    int initialx, initialy;
    int xOfMouse, yOfMouse , velocity;
    int t =    1; // This is time
    double shib, degree;
    boolean flag = true;
    int [][] screenArray;
    public Bullet(int initialx, int initialy , int xOfMouse, int yOfMouse , int[][] screenArray ) 
    {
        //t=1;
        velocity = 2;
        this.initialx = initialx;
        this.initialy = initialy;
        this.xOfMouse = xOfMouse;
        this.yOfMouse = yOfMouse;
        shib = ((double)(yOfMouse - initialy)/(xOfMouse - initialx));
        degree = Math.atan(shib);
        this.screenArray = new int[15][11];
        this.screenArray = screenArray;
    }
    
    

    @Override
    public void run()
    {
        while(flag)
        {
            if( ((yOfMouse - initialy) >0 &&  (xOfMouse - initialx) > 0) || ( (yOfMouse - initialy) <0 &&  (xOfMouse - initialx) > 0)) 
            {
            xOfBullet =  velocity*Math.cos(degree)*t + initialx;
            yOfBullet = velocity*Math.sin(degree)*t + initialy;
            }
           if( ((yOfMouse - initialy) >0 &&  (xOfMouse - initialx) < 0) || ( (yOfMouse - initialy) <0 &&  (xOfMouse - initialx) < 0))
            {
                xOfBullet =  -velocity*Math.cos(degree)*t + initialx;
                yOfBullet = -velocity*Math.sin(degree)*t + initialy;
            }
           
            t+=3;
            
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if( (screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] == 3))
            {
//                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 24;
                
                flag = false;
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 24;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
                }

                Random rand = new Random();
                int value = rand.nextInt(7);
                switch(value)
                {
                    case 0: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 1; break;
                    case 1: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 1; break;
                    case 5: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 1; break;
                    case 6: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 1; break;
                    case 2: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 5; break;
                    case 3: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 8; break;
                    case 4: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 22; break;
                }

            }
            if( screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] == 4)
            {
                flag = false;
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 24;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
                }
                Random rand = new Random();
                int value = rand.nextInt(7);
                switch(value)
                {
                    case 0: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 2; break;
                    case 1: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 2; break;
                    case 5: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 2; break;
                    case 6: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 2; break;
                    case 2: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 6; break;
                    case 3: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 9; break;
                    case 4: screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 21; break;
                }
            }
            if(screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] == 10)
            {
                flag = false;
                //////////////////////////////////////
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 24;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
                }
                ///////////////////////////////////////
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 1; 
            }
            
            if(screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] == 11)
            {
                flag = false;
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 24;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
                }
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 2; 
            }
            
            if(screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] == 7)
            {
                flag = false;
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 24;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
                }
                screenArray [((int)xOfBullet )/ 60] [((int)yOfBullet) /60] = 7; 
            }
            
        }
        
    }
    
    
    
}

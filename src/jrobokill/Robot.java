package jrobokill;

import java.util.ArrayList;

public class Robot {

    private int shield ;
    private int cash;
    private int x;
    private int y;
    private int numberOfKeys ;
    public ArrayList<Thing> things;
    public ArrayList<Box> boxes;
    
    
    public Robot(){
        shield = 100;
        cash = 0;
        numberOfKeys = 0;
        
        
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setShield(int s) {
        this.shield = s;
    }

    public int getShield() {
        return shield;
    }

    public void setCash(int y) {
        this.cash = y;
    }

    public int getCash() {
        return cash;
    }
    
     public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }
}



package jrobokill;

public class Box 
{
    protected int x;
    protected int y;
    protected int xOfBullet;
    protected int yOfBullet;
    protected int conditionTest;
    
    // conditionTest 0 : Empty box
    // conditionTest 1 : Gas box
    // conditionTest 2 : box with money
    // conditionTest 3 : box with shield
    // conditionTest 4 : box with enemy
    // conditionTest 5 : box with gun
    
    public Box(){
      
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setCondition(int conditionTest){
        this.conditionTest = conditionTest;
    }
    
    public int getCondition(){
        return conditionTest;
    }
    
    public void checkTheEqualityOfLocations(){
        if((xOfBullet == x)&&(yOfBullet == y)){
            recieve();
        }
    }
    public void recieve(){
        
    }
    
}

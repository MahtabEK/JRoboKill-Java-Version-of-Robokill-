

package jrobokill;

public class Thing 
{
    protected int x;
    protected int y;
    protected int conditionTest;
    
    //conditiontest = 1:shield
    //conditiontest = 2:money
    //conditiontest = 3:firstaid
    //conditiontest = 4:shop

    public void recieve(){
        
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
    
}

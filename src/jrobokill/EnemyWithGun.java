
package jrobokill;

public class EnemyWithGun 
{
    private  int type;
    public EnemyWithGun(int x, int y) 
    {
        type = 4;
        this.x = x;
        this.y = y;
    }
    
    private int x;
    private int y;
    
    public int getX()
    {
        return x;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    public int getType()
    {
        return type;
    }
    
    
    
}

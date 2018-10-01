



package jrobokill;

import java.util.ArrayList;

public class GenerateEnemies 
{
//    public ArrayList<EnemyWithGun> enemiesWG;
//    public ArrayList<EnemyWithoutGun> enemiesWOG;
    ArrayList<ArrayList<EnemyWithGun>> enemiesWG = new ArrayList<ArrayList<EnemyWithGun>>();
    ArrayList<ArrayList<EnemyWithoutGun>> enemiesWOG = new ArrayList<ArrayList<EnemyWithoutGun>>();
    ArrayList<EnemyWithGun> enemiesWG1;
    ArrayList<EnemyWithoutGun> enemiesWOG1;
    //Room 1:

    public GenerateEnemies() 
    {
        //Room 1:
        enemiesWG1 = new ArrayList<EnemyWithGun>();
        enemiesWOG1 = new ArrayList<EnemyWithoutGun>();
        enemiesWG1.add(new EnemyWithGun(200, 200));
        enemiesWOG1.add(new EnemyWithoutGun(380, 380, 1));
        enemiesWG.add(enemiesWG1);
        enemiesWOG.add(enemiesWOG1);
        
        
        //Room 2:
        enemiesWG1 = new ArrayList<EnemyWithGun>();
        enemiesWOG1 = new ArrayList<EnemyWithoutGun>();
        enemiesWG1.add(new EnemyWithGun(200, 200));
        enemiesWG1.add(new EnemyWithGun(230, 230));
        enemiesWOG1.add(new EnemyWithoutGun(380, 380,2));
        enemiesWOG1.add(new EnemyWithoutGun(500, 500,2));

        enemiesWG.add(enemiesWG1);
        enemiesWOG.add(enemiesWOG1);
    }
    
  

    
}

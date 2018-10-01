package jrobokill;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameEngine extends JPanel implements KeyListener, Runnable,
		MouseListener, MouseMotionListener {

	// harbar ke az 1 otagh mire yeki dige bayad room status ro taghir bedim
	public int[][] screenArray; // A Matrix for tiles of each room
	// ********************
	// ********************
	public ArrayList<EnemyWithGun> enemyWithGunforThisRoom;
	public ArrayList<EnemyWithoutGun> enemyWithoutGunForThisRoom;

	public ArrayList<Thing> thingsArray; // An Arraylist of things for each room
	public ArrayList<Box> boxesArray;
	Robot robot;
	ImageIcon background;
	ImageIcon robotIcon;
	JTextField jt;
	Thread thread;
	public ArrayList<Bullet> bulletsArray;
	boolean right, left, up, down;
	int xOfRobot, yOfRobot;
	Image box1Icon, box2Icon, tile1Icon, shield2Icon, shopIcon, firstAid1Icon,
			firstAid2Icon, gasBox1Icon, gasBox2Icon, tile2Icon, tile3Icon,
			cash1Icon, cash2Icon, shield1Icon, weapon1Icon, weapon2Icon,
			shopManIcon, firstPlaceIcon, doorIcon, keyIcon, bulletIcon,
			explosionIcon, enemyWithGunIcon, enemyWOGun1Icon, enemyWOGun2Icon,
			enemyWOGun3Icon;

	Matrixes mx;
	boolean shouldEat;
	GenerateRooms generateRooms;
	GenerateEnemies generateEnemies;
	ArrayList<Room> roomsArray;

	// *******************************************

	// public ArrayList<ArrayList<EnemyWithGun>> enemiesWGForAllRooms;
	// public ArrayList<ArrayList<EnemyWithoutGun>> enemiesWOGForAllRooms;
	// public ArrayList<EnemyWithGun> enemiesWGForThisRooms;
	// public ArrayList<EnemyWithoutGun> enemiesWOGForThisRooms;
	Image currentEnemy;
	private double atan, dir;
	ImageIcon robotShootPlace;

	public GameEngine() {
		addMouseMotionListener(this);
		robot = new Robot();
		mx = new Matrixes();
		// *********
		// *********
		generateEnemies = new GenerateEnemies();
		shouldEat = true;
		this.setLayout(null);
		this.setSize(900, 660);
		robotShootPlace = new ImageIcon(getClass().getResource("robot.png"));

		bulletsArray = new ArrayList<Bullet>();
		generateRooms = new GenerateRooms();
		roomsArray = new ArrayList<Room>();
		roomsArray = generateRooms.roomsArray;
		background = new ImageIcon(getClass().getResource("image.jpg"));
		robotIcon = new ImageIcon(getClass().getResource("pashe.png"));

		box1Icon = new ImageIcon(getClass().getResource("box1.png")).getImage();
		box2Icon = new ImageIcon(getClass().getResource("box2.png")).getImage();

		tile1Icon = new ImageIcon(getClass().getResource("tile1.jpg"))
				.getImage();
		tile2Icon = new ImageIcon(getClass().getResource("tile2.jpg"))
				.getImage();
		tile3Icon = new ImageIcon(getClass().getResource("tile3.jpg"))
				.getImage();

		shield1Icon = new ImageIcon(getClass().getResource("shield1.png"))
				.getImage();
		shield2Icon = new ImageIcon(getClass().getResource("shield2.png"))
				.getImage();

		cash1Icon = new ImageIcon(getClass().getResource("cash1.png"))
				.getImage();
		cash2Icon = new ImageIcon(getClass().getResource("cash2.png"))
				.getImage();

		firstAid1Icon = new ImageIcon(getClass().getResource("firstaid1.png"))
				.getImage();
		firstAid2Icon = new ImageIcon(getClass().getResource("firstaid2.png"))
				.getImage();

		gasBox1Icon = new ImageIcon(getClass().getResource("gasbox1.png"))
				.getImage();
		gasBox2Icon = new ImageIcon(getClass().getResource("gasbox2.png"))
				.getImage();

		weapon1Icon = new ImageIcon(getClass().getResource("weapon1.png"))
				.getImage();
		weapon2Icon = new ImageIcon(getClass().getResource("weapon2.png"))
				.getImage();

		shopIcon = new ImageIcon(getClass().getResource("shop.jpg")).getImage();
		shopManIcon = new ImageIcon(getClass().getResource("shopMan.jpg"))
				.getImage();
		firstPlaceIcon = new ImageIcon(getClass().getResource("firstPlace.jpg"))
				.getImage();

		doorIcon = new ImageIcon(getClass().getResource("door.jpg")).getImage();
		keyIcon = new ImageIcon(getClass().getResource("Key.png")).getImage();
		bulletIcon = new ImageIcon(getClass().getResource("bullet.png"))
				.getImage();
		explosionIcon = new ImageIcon(getClass().getResource("explosion.gif"))
				.getImage();

		enemyWOGun1Icon = new ImageIcon(getClass().getResource("enemy1.png"))
				.getImage();
		enemyWOGun2Icon = new ImageIcon(getClass().getResource("enemy2.png"))
				.getImage();
		enemyWOGun3Icon = new ImageIcon(getClass().getResource("enemy3.png"))
				.getImage();
		enemyWithGunIcon = new ImageIcon(getClass().getResource("enemy4.png"))
				.getImage();

		screenArray = new int[15][11]; // Field of this class

		jt = new JTextField();
		jt.addKeyListener(this);
		this.add(jt);

		right = false;
		left = false;
		up = false;
		down = false;

		xOfRobot = 330 - 22;
		yOfRobot = 330 - 22;

		thread = new Thread(this);
		thread.start();

		thingsArray = new ArrayList<Thing>();
		roomsCheck();

		addMouseListener(this);

		// *****************************
		// enemiesWGForAllRooms = new ArrayList<ArrayList<EnemyWithGun>>();
		// enemiesWOGForAllRooms = new ArrayList<ArrayList<EnemyWithoutGun>>();
		// enemiesWGForAllRooms = generateEnemies.enemiesWG;
		// enemiesWOGForAllRooms = generateEnemies.enemiesWOG;

		// enemiesWGForThisRooms = new ArrayList<EnemyWithGun>();
		// enemiesWOGForThisRooms = new ArrayList<EnemyWithoutGun>();
	} // End of constructor

	// Painting initial view of room
	public void drawBackGround(Graphics g) {
		Image current = null;
		for (int j = 0; j < 11; j++) {
			for (int i = 0; i < 15; i++) {
				switch (screenArray[i][j]) {
				case 0:
					current = null;
					break;
				case 1:
					current = tile1Icon;
					break;
				case 2:
					current = tile2Icon;
					break;
				case 3:
					current = box1Icon;
					break;
				case 4:
					current = box2Icon;
					break;
				case 5:
					current = shield1Icon;
					break;
				case 6:
					current = shield2Icon;
					break;
				case 7:
					current = tile3Icon;
					break;
				case 8:
					current = firstAid1Icon;
					break;
				case 9:
					current = firstAid2Icon;
					break;
				case 10:
					current = gasBox1Icon;
					break;
				case 11:
					current = gasBox2Icon;
					break;
				case 12:
					current = weapon1Icon;
					break;
				case 13:
					current = weapon2Icon;
					break;
				case 14:
					current = shopIcon;
					break;
				case 15:
					current = shopManIcon;
					break;
				case 16:
					current = firstPlaceIcon;
					break;
				case 17:
					current = doorIcon;
					break;

				case 18:
					current = doorIcon;
					break;

				case 19:
					current = doorIcon;
					break;

				case 20:
					current = doorIcon;
					break;
				case 21:
					current = cash1Icon;
					break;
				case 22:
					current = cash2Icon;
					break;

				case 23:
					current = keyIcon;
					break;
				case 24:
					current = explosionIcon;
					break;

				}
				g.drawImage(current, i * 60, j * 60, 60, 60, null);
			}
		}

	}

	public void roomsCheck() // Check which room is the current room and find
								// its room matrix
	{
		for (Room r : generateRooms.roomsArray) {
			if (r.getRoomStatus() == 1) {
				screenArray = mx.matrixes.get(r.getRoomNumber() - 1);
				// enemiesWGForThisRooms =
				// enemiesWGForAllRooms.get(r.getRoomNumber() -1);
				// enemiesWOGForThisRooms =
				// enemiesWOGForAllRooms.get(r.getRoomNumber() - 1);
				// *********
				// *********
				enemyWithGunforThisRoom = generateEnemies.enemiesWG.get(r
						.getRoomNumber() - 1);
				enemyWithoutGunForThisRoom = generateEnemies.enemiesWOG.get(r
						.getRoomNumber() - 1);

			}
		}
	}

	public void move() {
		// ******************
		// ******************
		if (right) {
			if ((screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 7)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 4)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 3)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 10)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 11)) {
				xOfRobot += 3;
			}
		}
		if (left) {
			if ((screenArray[(xOfRobot - 3 + 10) / 60][(yOfRobot + 22) / 60] != 7)
					&& (screenArray[(xOfRobot - 3 + 10) / 60][(yOfRobot + 22) / 60] != 3)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 4)

					&& (screenArray[(xOfRobot - 3 + 10) / 60][(yOfRobot + 22) / 60] != 10)
					&& (screenArray[(xOfRobot - 3 + 10) / 60][(yOfRobot + 22) / 60] != 11)) {

				xOfRobot -= 3;
			}
		}
		if (down) {
			if ((screenArray[(xOfRobot + 22) / 60][(yOfRobot + 3 + 35) / 60] != 7)
					&& (screenArray[(xOfRobot + 22) / 60][(yOfRobot + 3 + 35) / 60] != 3)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 4)

					&& (screenArray[(xOfRobot + 22) / 60][(yOfRobot + 3 + 35) / 60] != 10)
					&& (screenArray[(xOfRobot + 22) / 60][(yOfRobot + 3 + 35) / 60] != 11)) {

				yOfRobot += 3;
			}
		}
		if (up) {
			if ((screenArray[(xOfRobot + 22) / 60][(yOfRobot - 3 + 10) / 60] != 7)
					&& (screenArray[(xOfRobot + 22) / 60][(yOfRobot - 3 + 10) / 60] != 3)
					&& (screenArray[(xOfRobot + 3 + 35) / 60][(yOfRobot + 22) / 60] != 4)

					&& (screenArray[(xOfRobot + 22) / 60][(yOfRobot - 3 + 10) / 60] != 10)
					&& (screenArray[(xOfRobot + 22) / 60][(yOfRobot - 3 + 10) / 60] != 11)) {

				yOfRobot -= 3;
			}
		}

	}

	// *************************
	// *************************
	public void moveOfEnemies() {
		// baraye araye enemieswithgunforthisroom byd check kone bebine tu kooom
		// yek az 8 tast
		for (EnemyWithGun ewg : enemyWithGunforThisRoom) {
			if (ewg.getX() == xOfRobot && ewg.getY() < yOfRobot) {

				if ((screenArray[(ewg.getX() + 22) / 60][(ewg.getY() + 5 + 10) / 60] != 7)
						&& (screenArray[(ewg.getX() + 22) / 60][(ewg.getY() +5 + 10) / 60] != 3)
						&& (screenArray[(ewg.getX() + 5 + 35) / 60][(ewg.getY() + 22) / 60] != 4)
						&& (screenArray[(ewg.getX() + 22) / 60][(ewg.getY() + 5 + 10) / 60] != 10)
						&& (screenArray[(ewg.getX() + 22) / 60][(ewg.getY() + 5 + 10) / 60] != 11)) {

					if (screenArray[ewg.getX() + 22 / 60][(ewg.getY() + 22 + 5) / 60] == 0) {

						ewg.setY(ewg.getY() + 5);
					}

					else if (screenArray[ewg.getX() + 22 / 60][(ewg.getY() + 22 + 5) / 60] != 0) {

						if (screenArray[(ewg.getX() + 22 / 60) + 1][(ewg.getY() + 22) / 60] == 0) {
							ewg.setX(ewg.getX() + 1);
							moveOfEnemies();
						}

						else if (screenArray[(ewg.getX() + 22 / 60) - 1][(ewg
								.getY() + 22) / 60] == 0) {
							
							ewg.setX(ewg.getX() - 1);
							moveOfEnemies();
						}
						
						else if(screenArray[ewg.getX() + 22 / 60][((ewg.getY() + 22) / 60)-1] == 0){
							ewg.setY(ewg.getY() - 1);
							moveOfEnemies();
						}
						
						else if(screenArray[ewg.getX() + 22 / 60][((ewg.getY() + 22) / 60)+1]==0){
							ewg.setY(ewg.getY() + 1);
							moveOfEnemies();
							
						}
						
						else if(screenArray[(ewg.getX() + 22 / 60)+1][((ewg.getY() + 22) / 60)+1] == 0){
							ewg.setY(ewg.getY() + 1);
							ewg.setX(ewg.getX() + 1);

							moveOfEnemies();
						}
						
						
						else if(screenArray[(ewg.getX() + 22 / 60)-1][((ewg.getY() + 22) / 60)-1] == 0){
							ewg.setY(ewg.getY() - 1);
							ewg.setX(ewg.getX() - 1);

							moveOfEnemies();
						}
						
						else if(screenArray[(ewg.getX() + 22 / 60)-1][((ewg.getY() + 22) / 60)+1] == 0){
							ewg.setY(ewg.getY() + 1);
							ewg.setX(ewg.getX() - 1);

							moveOfEnemies();
						}
						
						else if(screenArray[(ewg.getX() + 22 / 60)+1][((ewg.getY() + 22) / 60)-1] == 0){
							ewg.setY(ewg.getY() - 1);
							ewg.setX(ewg.getX() + 1);

							moveOfEnemies();
						}
					}
				}

			}
			
			if (ewg.getX() == xOfRobot && ewg.getY() > yOfRobot) {

				if ((screenArray[(ewg.getX() + 22) / 60][(ewg.getY() - 5 + 10) / 60] != 7)
						&& (screenArray[(ewg.getX() + 22) / 60][(ewg.getY() - 5 + 10) / 60] != 3)
						&& (screenArray[(ewg.getX() + 5 + 35) / 60][(ewg.getY() + 22) / 60] != 4)
						&& (screenArray[(ewg.getX() + 22) / 60][(ewg.getY() - 5 + 10) / 60] != 10)
						&& (screenArray[(ewg.getX() + 22) / 60][(ewg.getY() - 5 + 10) / 60] != 11)) {

					if (screenArray[ewg.getX() + 22 / 60][(ewg.getY() + 22 - 5) / 60] == 0) {

						ewg.setY(ewg.getY() - 5);
					}

					else if (screenArray[ewg.getX() + 22 / 60][(ewg.getY() + 22 - 5) / 60] != 0) {

						if (screenArray[(ewg.getX() + 22 / 60) + 1][(ewg.getY() + 22) / 60] == 0) {
							ewg.setX(ewg.getX() + 1);
							moveOfEnemies();
						}

						else if (screenArray[(ewg.getX() + 22 / 60) - 1][(ewg
								.getY() + 22) / 60] == 0) {
							
							ewg.setX(ewg.getX() - 1);
							moveOfEnemies();
						}
						
						else if(screenArray[ewg.getX() + 22 / 60][((ewg.getY() + 22) / 60)-1] == 0){
							ewg.setY(ewg.getY() - 1);
							moveOfEnemies();
						}
						
						else if(screenArray[ewg.getX() + 22 / 60][((ewg.getY() + 22) / 60)+1]==0){
							ewg.setY(ewg.getY() + 1);
							moveOfEnemies();
							
						}
						
						else if(screenArray[(ewg.getX() + 22 / 60)+1][((ewg.getY() + 22) / 60)+1] == 0){
							ewg.setY(ewg.getY() + 1);
							ewg.setX(ewg.getX() + 1);

							moveOfEnemies();
						}
						
						
						else if(screenArray[(ewg.getX() + 22 / 60)-1][((ewg.getY() + 22) / 60)-1] == 0){
							ewg.setY(ewg.getY() - 1);
							ewg.setX(ewg.getX() - 1);

							moveOfEnemies();
						}
						
						else if(screenArray[(ewg.getX() + 22 / 60)-1][((ewg.getY() + 22) / 60)+1] == 0){
							ewg.setY(ewg.getY() + 1);
							ewg.setX(ewg.getX() - 1);

							moveOfEnemies();
						}
						
						else if(screenArray[(ewg.getX() + 22 / 60)+1][((ewg.getY() + 22) / 60)-1] == 0){
							ewg.setY(ewg.getY() - 1);
							ewg.setX(ewg.getX()+  1);

							moveOfEnemies();
						}
					}
				}

			}
			
//			if (ewg.getY() == yOfRobot && ewg.getX() > xOfRobot) {
//
//				if ((screenArray[(ewg.getX() - 5 + 10) / 60][(ewg.getY() + 22) / 60] != 7)
//						&& (screenArray[(ewg.getX() - 5 + 10) / 60][(ewg.getY() + 22) / 60] != 3)
//						&& (screenArray[(ewg.getX() + 5 + 35) / 60][(ewg.getY() + 22) / 60] != 4)
//
//						&& (screenArray[(ewg.getX() - 5 + 10) / 60][(ewg.getY() + 22) / 60] != 10)
//						&& (screenArray[(ewg.getX() - 5 + 10) / 60][(ewg.getY() + 22) / 60] != 11)) {
//
//				
//
//					if (screenArray[(ewg.getX() + 22 -5 / 60)][(ewg.getY() + 22 ) / 60] == 0) {
//
//						ewg.setX(ewg.getX() - 5);
//					}
//
//					else if (screenArray[ewg.getX() + 22 / 60][(ewg.getY() + 22 - 5) / 60] != 0) {
//
//						if (screenArray[(ewg.getX() + 22 / 60) + 1][(ewg.getY() + 22) / 60] == 0) {
//							ewg.setX(ewg.getX() + 1);
//							moveOfEnemies();
//						}
//
//						else if (screenArray[(ewg.getX() + 22 / 60) - 1][(ewg
//								.getY() + 22) / 60] == 0) {
//							
//							ewg.setX(ewg.getX() - 1);
//							moveOfEnemies();
//						}
//						
//						else if(screenArray[ewg.getX() + 22 / 60][((ewg.getY() + 22) / 60)-1] == 0){
//							ewg.setY(ewg.getY() - 1);
//							moveOfEnemies();
//						}
//						
//						else if(screenArray[ewg.getX() + 22 / 60][((ewg.getY() + 22) / 60)+1]==0){
//							ewg.setY(ewg.getY() + 1);
//							moveOfEnemies();
//							
//						}
//						
//						else if(screenArray[(ewg.getX() + 22 / 60)+1][((ewg.getY() + 22) / 60)+1] == 0){
//							ewg.setY(ewg.getY() + 1);
//							ewg.setX(ewg.getX() + 1);
//
//							moveOfEnemies();
//						}
//						
//						
//						else if(screenArray[(ewg.getX() + 22 / 60)-1][((ewg.getY() + 22) / 60)-1] == 0){
//							ewg.setY(ewg.getY() - 1);
//							ewg.setX(ewg.getX() - 1);
//
//							moveOfEnemies();
//						}
//						
//						else if(screenArray[(ewg.getX() + 22 / 60)-1][((ewg.getY() + 22) / 60)+1] == 0){
//							ewg.setY(ewg.getY() + 1);
//							ewg.setX(ewg.getX() - 1);
//
//							moveOfEnemies();
//						}
//						
//						else if(screenArray[(ewg.getX() + 22 / 60)+1][((ewg.getY() + 22) / 60)-1] == 0){
//							ewg.setY(ewg.getY() - 1);
//							ewg.setX(ewg.getX()+  1);
//
//							moveOfEnemies();
//						}
//					}
//				}
//
//			}
		}
	}

	// ***************************************************************
	public void drawEnemies(Graphics g) {
		// enemiesWGForThisRooms.add(new EnemyWithGun(200, 200));
		// enemiesWOGForThisRooms.add(new EnemyWithoutGun(250, 200, 1));
		// enemiesWOGForThisRooms.add(new EnemyWithoutGun(350, 200, 2));
		// enemiesWOGForThisRooms.add(new EnemyWithoutGun(450, 200, 3));
		for (EnemyWithGun e : enemyWithGunforThisRoom) {
			g.drawImage(enemyWithGunIcon, e.getX(), e.getY(), null);
		}

		for (EnemyWithoutGun e : enemyWithoutGunForThisRoom) {
			switch (e.getType()) {
			case 1:
				currentEnemy = enemyWOGun1Icon;
				break;
			case 2:
				currentEnemy = enemyWOGun2Icon;
				break;
			case 3:
				currentEnemy = enemyWOGun3Icon;
				break;
			}

			g.drawImage(currentEnemy, e.getX(), e.getY(), null);
			// e.setX(e.getX()+3);

		}

	}

	// ********************
	// ********************

//	public void movementOfEnemies() {
//		for (EnemyWithGun enemywithgun : enemyWithGunforThisRoom) {
//			if ((enemywithgun.getX() == xOfRobot)
//					&& (enemywithgun.getY() < yOfRobot)) {
//
//			}
//
//		}
//	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background.getImage(), 0, 0, 1340, 700, null);
		drawBackGround(g);
		move();
		g.drawImage(robotIcon.getImage(), xOfRobot, yOfRobot, 44, 44, null);
		check();
		BufferedImage lDefaaiiImage = new BufferedImage(900, 660,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2 = lDefaaiiImage.createGraphics();
		g2.rotate(Math.toRadians(atan), xOfRobot + 22, yOfRobot + 22);
		g2.drawImage(robotShootPlace.getImage(), xOfRobot - 5, yOfRobot, 54,
				44, null);
		g.drawImage(lDefaaiiImage, 0, 0, null);

		for (Bullet b : bulletsArray) {
			g.drawImage(bulletIcon, (int) b.xOfBullet, (int) b.yOfBullet, 15,
					15, null);
		}
		// ********************************************************
		// *******************************************************
		drawEnemies(g);

	}

	public void check() {
		switch (screenArray[xOfRobot / 60][yOfRobot / 60]) {

		case 5: {
			robot.setShield(robot.getShield() + 10);
			screenArray[xOfRobot / 60][yOfRobot / 60] = 1;
		}
			break;
		case 6: {
			robot.setShield(robot.getShield() + 10);
			screenArray[xOfRobot / 60][yOfRobot / 60] = 2;
		}
			break;
		case 8: {
			screenArray[xOfRobot / 60][yOfRobot / 60] = 1;
			robot.setShield(robot.getShield() + 10);
		}
			break;
		case 9: {

			robot.setShield(robot.getShield() + 10);
			screenArray[xOfRobot / 60][yOfRobot / 60] = 2;
		}
			break;

		case 12: {
			// weapon
		}
		case 13: {
			// weapon
		}
		case 14: {
			// shop
		}
		case 21: // cash1
		{
			robot.setCash(robot.getCash() + 20);
			screenArray[xOfRobot / 60][yOfRobot / 60] = 1;
		}
			break;
		case 22: // cash2
		{
			robot.setCash(robot.getCash() + 20);
			screenArray[xOfRobot / 60][yOfRobot / 60] = 2;
		}
			break;

		case 23: {
			robot.setNumberOfKeys(robot.getNumberOfKeys() + 1);
			screenArray[xOfRobot / 60][yOfRobot / 60] = 2;

		}
		case 17:
			for (Room room : generateRooms.roomsArray) {
				if (room.getRoomStatus() == 1) {
					// ***************
					// ************************
					if ((enemyWithGunforThisRoom.size() == 0)
							&& (enemyWithoutGunForThisRoom.size()) == 0) {
						room.setRoomStatus(2);
						if (room.borders.get(0).typeOfBorder == 1
								|| ((room.borders.get(0).typeOfBorder == 2) && (robot
										.getNumberOfKeys() != 0))) {

							if (room.borders.get(0).typeOfBorder == 2) {
								robot.setNumberOfKeys(robot.getNumberOfKeys() - 1);
							}
							int first = room.borders.get(0).betweenWhichRooms
									.get(0);
							int second = room.borders.get(0).betweenWhichRooms
									.get(1);
							System.out.println(first + "," + second);
							if (first == room.getRoomNumber()) {

								screenArray = mx.matrixes.get(second - 1);
								// setCurrentStatus(second);
								// System.out.println("we r now in this room:second:"+
								// second);
								// System.out.println("we r in second"+room.getRoomNumber());

							} else {
								screenArray = mx.matrixes.get(first - 1);
								// setCurrentStatus(first );
								// System.out.println("we r in first"+room.getRoomNumber());
							}
							xOfRobot = 450 - 22;
							yOfRobot = 600 - 22;
						}
					}

					else if (enemyWithGunforThisRoom.size() != 0) {
						
					}
				}
			}
			break;

		case 18:
			for (Room room : generateRooms.roomsArray) {
				if (room.getRoomStatus() == 1) {
					if ((enemyWithGunforThisRoom.size() == 0)
							&& (enemyWithoutGunForThisRoom.size()) == 0) {

						room.setRoomStatus(2);
						if (room.borders.get(0).typeOfBorder == 1
								|| ((room.borders.get(0).typeOfBorder == 2) && (robot
										.getNumberOfKeys() != 0))) {

							if (room.borders.get(0).typeOfBorder == 2) {
								robot.setNumberOfKeys(robot.getNumberOfKeys() - 1);
							}
							int first = room.borders.get(1).betweenWhichRooms
									.get(0);
							int second = room.borders.get(1).betweenWhichRooms
									.get(1);
							System.out.println(first + "," + second);
							if (first == room.getRoomNumber()) {
								screenArray = mx.matrixes.get(second - 1);
							} else {
								screenArray = mx.matrixes.get(first - 1);
							}
							xOfRobot = 60 + 22;
							yOfRobot = 330 - 22;
						}
					}
				}
			}
			break;

		case 19:
			for (Room room : generateRooms.roomsArray) {
				if (room.getRoomStatus() == 1) {
					if ((enemyWithGunforThisRoom.size() == 0)
							&& (enemyWithoutGunForThisRoom.size()) == 0) {

						room.setRoomStatus(2);
						if (room.borders.get(0).typeOfBorder == 1
								|| ((room.borders.get(0).typeOfBorder == 2) && (robot
										.getNumberOfKeys() != 0))) {
							if (room.borders.get(0).typeOfBorder == 2) {
								robot.setNumberOfKeys(robot.getNumberOfKeys() - 1);
							}
							int first = room.borders.get(2).betweenWhichRooms
									.get(0);
							int second = room.borders.get(2).betweenWhichRooms
									.get(1);
							System.out.println(first + "," + second);
							if (first == room.getRoomNumber()) {
								screenArray = mx.matrixes.get(second);
							} else if (second == room.getRoomNumber()) {
								screenArray = mx.matrixes.get(first);
							}
							xOfRobot = 450 - 22;
							yOfRobot = 60 + 22;
						}
					}
				}
			}
			break;

		case 20:
			for (Room room : generateRooms.roomsArray) {
				if (room.getRoomStatus() == 1) {
					if ((enemyWithGunforThisRoom.size() == 0)
							&& (enemyWithoutGunForThisRoom.size()) == 0) {

						room.setRoomStatus(2);
						if (room.borders.get(0).typeOfBorder == 1
								|| ((room.borders.get(0).typeOfBorder == 2) && (robot
										.getNumberOfKeys() != 0))) {

							if (room.borders.get(0).typeOfBorder == 2) {
								robot.setNumberOfKeys(robot.getNumberOfKeys() - 1);
							}

							int first = room.borders.get(3).betweenWhichRooms
									.get(0);
							int second = room.borders.get(3).betweenWhichRooms
									.get(1);
							System.out.println(first + "," + second);
							if (first == room.getRoomNumber()) {
								screenArray = mx.matrixes.get(second - 1);

							} else {
								screenArray = mx.matrixes.get(first - 1);
							}
							xOfRobot = 900 - 60 - 22;
							yOfRobot = 330 - 22;
						}
					}
				}
			}
			break;
		}

	}

	public void setCurrentStatus(int number) {
		for (Room r : roomsArray) {
			if (r.getRoomNumber() == number) {
				r.setRoomStatus(1);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			right = true;

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		left = false;
		right = false;
		down = false;
		up = false;
	}

	@Override
	public void run() {
		while (true) {
			try {
				repaint();
				thread.sleep(50);
			} catch (InterruptedException ex) {
				Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xOfThePlaceClicked = e.getX();
		int yOfThePlaceClicked = e.getY();
		// double shib = (yOfThePlaceClicked - yOfRobot)/(xOfThePlaceClicked -
		// xOfRobot);
		Bullet bullet = new Bullet(xOfRobot + 22, yOfRobot + 22,
				xOfThePlaceClicked, yOfThePlaceClicked, screenArray);
		// System.out.println(xOfThePlaceClicked + "," + yOfThePlaceClicked);

		bulletsArray.add(bullet);
		new Thread(bullet).start();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		double f = 0;
		if (arg0.getX() >= xOfRobot && arg0.getY() < yOfRobot) {
			f = (double) (yOfRobot - arg0.getY())
					/ (double) (arg0.getX() - xOfRobot);
			atan = -1 * ((xOfRobot * Math.atan(f)) / 3.14) - 90;
		}
		if (arg0.getX() < xOfRobot && arg0.getY() < yOfRobot) {
			f = (double) (yOfRobot - arg0.getY())
					/ (double) (xOfRobot - arg0.getX());
			atan = ((180 * Math.atan(f)) / 3.14) + 90;
		}

		dir = f;

	}

}

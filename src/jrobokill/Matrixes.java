

package jrobokill;

import java.util.ArrayList;

public class Matrixes {
	public ArrayList<int[][]> matrixes;
	public int[][] screen;

	public Matrixes() {
		matrixes = new ArrayList<int[][]>();
		screen = new int[15][11];
		for (int i = 0; i <= 5; i++) {
			screen[i][0] = 7;
		}
		for (int i = 6; i <= 8; i++) {
			screen[i][0] = 17;
		}

		for (int i = 9; i <= 14; i++) {
			screen[i][0] = 7;
		}
		for (int i = 0; i <= 10; i++) {
			screen[0][i] = 7;
			screen[14][i] = 7;

		}

		for (int i = 0; i <= 14; i++) {
			screen[i][10] = 7;

		}

		for (int i = 1; i <= 9; i++) {
			screen[13][i] = 1;

		}

		screen[12][1] = 1;
		screen[12][2] = 3;
		screen[12][3] = 3;
		screen[12][4] = 1;
		screen[12][5] = 3;
		screen[12][6] = 1;
		screen[12][7] = 3;
		screen[12][8] = 3;
		screen[12][9] = 3;

		for (int i = 1; i <= 9; i++) {
			screen[11][i] = 1;

		}

		screen[10][1] = 1;
		screen[10][2] = 15;
		screen[10][3] = 14;
		screen[10][4] = 1;
		screen[10][5] = 1;
		screen[10][6] = 1;
		screen[10][7] = 1;
		screen[10][8] = 1;
		screen[10][9] = 1;

		for (int i = 1; i <= 9; i++) {
			screen[9][i] = 1;

		}

		for (int i = 1; i <= 7; i++) {
			screen[8][i] = 1;

		}

		for (int i = 8; i <= 9; i++) {
			screen[8][i] = 10;

		}

		for (int i = 1; i <= 3; i++) {
			screen[7][i] = 1;
			screen[6][i] = 1;
			screen[5][i] = 1;
			screen[4][i] = 1;

		}

		for (int i = 4; i <= 9; i++) {
			screen[7][i] = 2;
		}

		for (int i = 4; i <= 7; i++) {
			screen[6][i] = 2;
			screen[5][i] = 2;
			screen[4][i] = 2;

		}
		
		screen[5][5] = 16;



		matrixes.add(screen);

		// Room 2 Matrix:
		screen = new int[15][11];
		for (int i = 0; i <= 5; i++) {
			screen[i][0] = 7;
		}
		for (int i = 6; i <= 8; i++) {
			screen[i][0] = 17;
		}

		for (int i = 9; i <= 14; i++) {
			screen[i][0] = 7;
		}
		for (int i = 0; i <= 10; i++) {
			screen[0][i] = 7;
			screen[14][i] = 7;

		}
		
		for (int i = 0; i <= 5; i++) {
			screen[i][10] = 7;
		}
		for (int i = 6; i <= 8; i++) {
			screen[i][10] = 19;
		}

		for (int i = 9; i <= 14; i++) {
			screen[i][10] = 7;
		}
		
		screen[13][1] = 11;
		screen[12][1] = 11;
		screen[11][1] = 2;
		screen[1][1] = 2;
		screen[2][1] = 2;
		screen[3][1] = 2;
		screen[13][9] = 2;
		screen[12][9] = 2;
		screen[11][9] = 2;
		screen[13][8] = 2;
		screen[12][8] = 2;
		screen[11][8] = 2;
		screen[1][9] = 11;
		screen[2][9] = 2;
		screen[3][9] = 2;
		screen[1][8] = 2;
		screen[2][8] = 2;
		screen[3][8] = 2;

		for(int i=6;i<=8;i++){
			for(int j=1;j<=9;j++){
				screen[i][j] = 2;
			}
		}
		matrixes.add(screen);
		
		// Room 3 Matrix:
				screen = new int[15][11];
				for (int i = 0; i <= 5; i++) {
					screen[i][0] = 7;
				}
				for (int i = 6; i <= 8; i++) {
					screen[i][0] = 17;
				}

				for (int i = 9; i <= 14; i++) {
					screen[i][0] = 7;
				}
				for (int i = 0; i <= 10; i++) {
					screen[0][i] = 7;
					screen[14][i] = 7;

				}
				
				for (int i = 0; i <= 5; i++) {
					screen[i][10] = 7;
				}
				for (int i = 6; i <= 8; i++) {
					screen[i][10] = 19;
					}

				for (int i = 9; i <= 14; i++) {
					screen[i][10] = 7;
				}
				

				for (int i = 1; i <= 9; i++) {
					screen[13][i] = 1;
				}
				for(int i = 1;i<=14;i++){
					for(int j = 1;j<=9;j++){
						screen[i][j] = 2;
					}
				}
				
				
				
				
				
			

				matrixes.add(screen);
	}

}

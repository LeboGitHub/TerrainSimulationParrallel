import java.io.File;
import java.util.Scanner;

public class Parallel {
	
	// variable used throughtout the program
	//array of trees and a terrain matrix(2D array)
	static Tree [] trees;
	static float [][] terrain;
	
	/**
	 * Method used to read data from a text files
	 * @param input (The name/path of the text file)
	 */
	public static void setUp(String input) {

		//get the file name
		String inputFileName = input;
		int terrainX; int terrainY; 
		int numTrees=0;;
		try {
			//create a scanner to read from the text file
			Scanner sc = new Scanner(System.in);
			File file = new File(inputFileName);
			sc = new Scanner(file);
			// get the x and y parameters for the terrain matrix
			terrainX = sc.nextInt();
			terrainY = sc.nextInt();
			//create the terrain object
			int inputs =0;
			terrain = new float[terrainX][terrainY];
			//populate the terrain matrix
			for(int outter = 0 ; outter<terrainX ; outter++)
				for(int inner = 0; inner < terrainY; inner++)
				{
					terrain[inner][outter] = sc.nextFloat();
					inputs++;
				}
			//get the number of trees and set the size of the trees array
			numTrees = sc.nextInt();
			trees = new Tree[numTrees];
			//populate the trees array
			for(int iLoop= 0; iLoop < numTrees ; iLoop++) {
				int xPos = sc.nextInt();
				int yPos = sc.nextInt();
				int e = sc.nextInt();
				Tree tree = new Tree(xPos,yPos,e);
				trees[iLoop] = tree;
			}

			sc.close();
		}catch(Exception e)
		{
			System.out.println("Error reading file");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Method to get the sum of the sunlight values for a single tree
	 * @param tree
	 * @return the total sunlight received by a tree
	 */
	public static float canopySum(Tree tree) {
		float sum =0;
		int xPos = tree.getXPos();
		int yPos = tree.getYPos();
		int extent = tree.getE();
		
		return sum;
	}
	
	
	public static void main(String args[]) {
		//get the inputs
		//setUp(args[0]);
		setUp("src/sample_input.txt");
	}

}

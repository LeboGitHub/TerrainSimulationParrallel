import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Parallel {
	
	// variable used throughout the program
	//array of trees and a terrain matrix(2D array)
	static Tree [] trees;
	static double [][] terrain;
	static int terrainX;
	static int terrainY;
	/**
	 * Method used to read data from a text files
	 * @param input (The name/path of the text file)
	 */
	public static void setUp(String input) {

		//get the file name
		String inputFileName = input;
		//int terrainX; int terrainY; 
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
			terrain = new double[terrainX][terrainY];
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
		//initialise values
		float sum =0;
		int xPos = tree.getXPos();
		int yPos = tree.getYPos();
		int extent = tree.getE();
		
		//get the total sunlight for a tree
		for(int outter= xPos; outter<=(xPos+extent);outter++ )
			for(int inner = yPos; inner <= (yPos+extent);inner++) {
				//ensure that you do not go outside the bounds of the terrain
				if((outter < terrainX)&&(inner < terrainY)) {
					sum+= terrain[outter][inner];
				}
			}
		
		return sum;
	}
	
	static double sumArray(Tree[] array) {
		return (double) ForkJoinPool.commonPool().invoke(new SumArray(array,0,array.length));
	}
	
    public static void main(String args[]) {
		//get the inputs
		//setUp(args[0]);
		setUp("src/sample_input.txt");
		double total = (double)sumArray(trees);
		System.out.println("Total: "+String.valueOf(total));
		System.out.println(String.valueOf(trees.length)+ " Trees");
		System.out.println("Avg: "+String.valueOf(total/trees.length));
	}

}

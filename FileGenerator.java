import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;


public class FileGenerator {
	
	static String fileName;
	static int terrainX;
	static int terrainY;
	static double[] matrixValues = new double[terrainX * terrainY];
	static int numTrees;
	static Tree[] trees;
	public static void main(String args) {
		fileName = ("src/sample_input.txt");
		load(fileName);
		generate(100000);
	}
	
	public static void load(String fileName) {
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			terrainX = sc.nextInt();
			terrainY = sc.nextInt();
			for(int iLoop = 0; iLoop<(terrainX*terrainY);iLoop++)
				matrixValues[iLoop] = sc.nextDouble();
			numTrees = sc.nextInt();
			for(int iLoop=0;iLoop<numTrees;iLoop++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int extent = sc.nextInt();
				Tree tree = new Tree(x,y,extent);
				trees[iLoop] = tree;
			}
			
			sc.close();
			
		}catch(Exception e) {
			System.out.println("file not found");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	/**
	 * method to generate text files for experimenting 
	 * @param size
	 */
	public static void generate(int size) {
		String string ="";
		//file name specific to input size
		fileName="input_"+String.valueOf(size)+".txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			//print x and y sizes of terrain
			string = String.valueOf(terrainX)+" "+String.valueOf(terrainY);
			writer.write(string);
			//print terrain values
			string="";
			for(int iLoop=0; iLoop<matrixValues.length;iLoop++) {
				string+= String.valueOf(matrixValues[iLoop]);
				string+=" ";
			}
			writer.write(string);
			//print num trees for this text file
			writer.write(String.valueOf(size));
			string="";
			//print appropriate number of trees
			for(int iLoop=0; iLoop<size;iLoop++) {
				string = String.valueOf(trees[iLoop].getXPos())+" ";
				string+= String.valueOf(trees[iLoop].getYPos())+" ";
				string+= String.valueOf(trees[iLoop].getE());
				writer.write(string);
			}
			
			writer.close();//close writer
		}catch(Exception e) {
			System.out.println("error generating file");
			e.printStackTrace();;
			System.exit(0);
		}
	}

}

public class Tree {
	
	private int xPos;
	private int yPos;
	private int e;
	private double totalSunlight;
	
	public Tree() {
		xPos=0;
		yPos=0;
		e=0;
		totalSunlight = 0;
	}
	
	public Tree(int xPos, int yPos,int e) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.e = e;
	}
	
	public void updateTotal(double num) {
		totalSunlight += num;
	}
	
	public double getTotal(){
		return totalSunlight;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getE() {
		return e;
	}
	
	public void setXPos(int num) {
		xPos = num;
	}
	
	public void setYPos(int num) {
		yPos = num;
	}
	
	public void setE(int num)
	{
		e = num;
	}
	
	public void setTotal(double num) {
		totalSunlight = num;
	}
	
	public String toString() {
		String output =  "X :"+String.valueOf(xPos)+"/n"+"Y: "+String.valueOf(yPos)+"/n"+
				"e: "+String.valueOf(e);
		return output;
	}

}

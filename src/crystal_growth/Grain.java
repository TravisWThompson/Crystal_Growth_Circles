package crystal_growth;

public class Grain extends Thread {
	private Vector mCenter;
	private int mRadius;
	private double mFullArea;
	private double mEffectiveArea;
	private double mEffectiveRadius;
	private double mAreaConstant;
	
	public Grain(Vector center, int radius){
		mCenter = center;
		mRadius = radius;
		mFullArea = getTotalArea();
		//
		
		
		
		
		
		
		mEffectiveArea =
		//mEffectiveRadius = 
	}
	
	public void run(){
		
	}
	
	public void growRadius(int increase){
		mRadius += increase;
	}
	
	public Vector getCenter(){
		return mCenter;
	}
	
	private double getTotalArea(){
		return Math.PI * Math.pow(mRadius, 2);
	}

}

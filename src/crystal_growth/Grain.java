package crystal_growth;

import java.util.ArrayList;

public class Grain extends Thread {
	private Vector mCenter;
	private int mRadius;
	private double mFullArea;
	private double mEffectiveRadius;
	private double mAreaConstant;
	
	public Grain(Vector center, int radius){
		mCenter = center;
		mRadius = radius;
		mFullArea = getTotalArea();
		//mEffectiveRadius = 
	}
	
	/**
	 * Threaded method that will begin to run effective radius calculations.
	 */
	public void run(){
		// Begin effective radius calculations.
		mEffectiveRadius = calculateEffectiveRadius();
	}
	
	/**
	 * Increases the radius of the Grain by an increase.
	 * @param increase Integer value to increase the total radius by.
	 */
	public void growRadius(int increase){
		mRadius += increase;
	}
	
	/**
	 * Returns the coordinate vector of this grain's center.
	 * @return Vector coordinate of the center of this grain.
	 */
	public Vector getCenter(){
		return mCenter;
	}
	
	/**
	 * Return the size of the radius.
	 * @return Integer of radius.
	 */
	public int getRadius(){
		return mRadius;
	}
	
	/**
	 * Check if this Grain lies within a previously existing Grain (from the
	 * ArrayList of Grains).
	 * 
	 * @param grains ArrayList of Grain objects that are in the sample to check
	 * against.
	 * @return Return True if this grain lies within a previously existing 
	 * Grain, otherwise return False. If True, this grain should not exist.
	 */
	public boolean checkGrainCircleIntersection(ArrayList<Grain> grains){
		// Check all grains in the ArrayList.
		for(int i = 0; i < grains.size(); i++){
			// Calculate the magnitude difference between the center of this 
			// grain and the next grain in the list.
			//
			// The method that will be called to perform this calculation can
			// throw an error if the dimensions of the two vectors are not 
			// the same. This should be a fatal error. However, it is currently
			// handled here by only printing the error message and continuing
			// the program.
			//
			try {
				// Calculate magnitude distance between the two centers of the
				// grains.
				double dist = mCenter.differenceMag(grains.get(i).mCenter);
				
				// If the distance between the two vectors is less than the two
				// radius added.
				if(dist < (mRadius+grains.get(i).mRadius)){
					// This grain does lie within another grain.
					return true;
				}
				
			} catch (Exception e) {
				// Error was thrown.
				e.printStackTrace();
			}
		}
		// This grain does NOT lie within another grain.
		return false;
	}
	
	
	/**
	 * Calculate the area of the circle while ignoring overlap with other
	 * grains.
	 * @return Area of the grain ignoring overlap.
	 */
	private double getTotalArea(){
		return Math.PI * Math.pow(mRadius, 2);
	}
	
	/**
	 * Calculates the effective radius of the grain (NOT FINISHED)
	 * @return
	 */
	private double calculateEffectiveRadius(){
		// Radius calculation here.
		return 0.0;
	}

}

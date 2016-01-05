package crystal_growth;

public class GrandPolytope implements Runnable {
	private double mEffectiveRadius;
	
	public GrandPolytope(){
		mEffectiveRadius = 1;
	}
	
	@Override
	public void run() {
		// split GrandPolytope into polytopes and arcs 
		// start each polytope's thread to calculate area
		// join threads and retrieve total area
		
		
	}
	
	
	private double calculateRadiusFromArea(double area){
		return Math.sqrt(area/Math.PI);
	}
	
	

}

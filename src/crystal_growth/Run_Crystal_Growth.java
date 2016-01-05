package crystal_growth;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Run_Crystal_Growth {
	
	private static ArrayList<Grain> Grains;
	private static int Initialize_New_Grains = 1;
	private static int New_Grains_Per_Time = 1;
	private static int Starting_Radius = 1;
	private static int Radius_Increase = 1;
	private static int Sample_Size = 5000;
	private static int Dimensions = 2;
	private static int Time_Steps = 500;
	private static Random Random_Gen;
	private static boolean Display_Sample = true;
	private static Frame frame;
	
	public static void main(String[] args) {
		
		// Initialize parameters:
		Grains = new ArrayList<Grain>();
		Random_Gen = new Random();
		
		// Initialize display:
		//if(Display_Sample == true){
			Frame frame = new Frame(Sample_Size, Grains);
			frame.setTitle("Grain Sample");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		//}
		
		// Second set of initializations:
		int addedGrains = 0;
		int failedGrains = 0;
		
		for(int time = 0; time < Time_Steps; time++){
			
			// ADD NEW GRAINS.
			
			addedGrains = 0;
			failedGrains = 0;
			// This if statement will only allow new grains to be only added
			// every "New_Grains_Per_Time" steps.
			if(time % New_Grains_Per_Time == 0){
				
				// Attempt to add "Initialize_New_Grains" number of new grains
				// to the sample.
				for(int addGrains = 0; addGrains < Initialize_New_Grains; addGrains++){
					// Create a new grain with random coordinates and an initial
					// radius of "Starting_Radius".
					Grain grain = new Grain(initializeGrainCoordinates(), Starting_Radius);
					
					// Check if this new grain lies within a previously existing
					// grain. If it does, the grain will not be added. If it 
					// does not, it will be added to the sample.
					if(grain.checkGrainCircleIntersection(Grains) == true){
						// Grain failed.
						failedGrains++;
					} else {
						//Grain added.
						Grains.add(grain);
						addedGrains++;
					} 
					
				}
					
			}
			
			
			// GROW GRAINS
			for(int i = 0; i < Grains.size(); i++){
				Grains.get(i).growRadius(Radius_Increase);
			}
			
			
			
			// FIND NEW INTERSECTION POINTS
			
			
			
			
			
			// CALCULATE THE EFFECTIVE RADIUS
			
			
			
			
			
			
			
			// PRINT OUT DATA
			
			
			
			
			
			
			
			
			// DRAW GRAIN SAMPLE
			if(Display_Sample == true){
				frame.updateDisplay(Grains);
			}
			
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		/*
		Vector v = new Vector(new int[]{1,2,3,4,5,6});
		Vector v2 = new Vector(new int[]{2,2,3,4,5,6});
		System.out.println(v.magnitude());
		System.out.println(v2.magnitude());
		try {
			System.out.println(v.differenceMag(v2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//Grain g = new Grain(v,1);
		
		
		
	}
	
	public static Vector initializeGrainCoordinates(){
		int[] initialCoord = new int[Dimensions];
		
		for(int i = 0; i < Dimensions; i++){
			initialCoord[i] = (int) Math.round(Random_Gen.nextDouble()*Sample_Size);
			
			if(initialCoord[i] == Sample_Size){
				i--;
			}
		}
		
		return new Vector(initialCoord);
	}

}

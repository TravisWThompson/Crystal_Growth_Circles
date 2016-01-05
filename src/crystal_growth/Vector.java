package crystal_growth;

public class Vector {
	private int[] mVector;
	
	public Vector(int[] vectorValues){
		mVector =  vectorValues;
	}
	
	public int getComponent(int index){
		if(mVector.length <= index){
			throw new IndexOutOfBoundsException("Vector index greater than number "
					+ "of dimensions.");
		} else {
			return mVector[index];
		}
	}
	
	public double magnitude(){
		double mag = 0;
		for(int i = 0; i < mVector.length; i++){
			mag += Math.pow(((double) mVector[i]), 2);
		}
		return Math.sqrt(mag);
	}
	
	public double differenceMag(Vector vector2) throws Exception{
		return calcDiffVector(vector2).magnitude();		
	}
	
	public Vector differenceVector(Vector vector2) throws Exception{
		return calcDiffVector(vector2);
	}
	
	public int size(){
		return mVector.length;
	}
	
	private Vector calcDiffVector(Vector v2) throws Exception{
		if (v2.size() != mVector.length){
			throw new Exception("Vector dimensions do not agree");
		} 
		int[] diff = new int[mVector.length];
		for(int i = 0; i < mVector.length; i++){
			diff[i] = v2.getComponent(i)-mVector[i];			
		}
		return new Vector(diff);
	}
	
	
	

}

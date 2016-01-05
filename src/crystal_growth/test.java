package crystal_growth;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
	}

}

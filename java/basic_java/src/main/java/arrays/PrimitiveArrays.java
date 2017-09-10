package arrays;

class PrimitiveArrays{
	public static void main(String args[]){
		//int
		System.out.println("Integer Arrays:");
		int a1[] = new int[10];
		a1[0] = 1;
		System.out.println(a1[0]);
		
		//Integer
		Integer a2[] = new Integer[10];
		a2[0] = 2;
		System.out.println(a2[0]);
		
		//String
		String s1[] = new String[10];
		s1[0] = "test0";
		s1[1] = "test1";
		s1[2] = "test2";
		s1[3] = "test3";
		System.out.println("String Array 3rd Element:"+s1[2]);
	}
}
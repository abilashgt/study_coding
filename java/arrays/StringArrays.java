import java.util.*;

class StringArrays{
	public static void main(String args[]){
		//primitive
		System.out.println("Primitive Array");
		String s1[] = new String[10];
		s1[0] = "test0";
		s1[1] = "test1";
		s1[2] = "test2";
		s1[3] = "test3";
		System.out.println("3rd Element:"+s1[2]);
		
		char c1[] = new char[20];
		c1[0] = 'a';
		c1[2] = 'c';
		System.out.println(c1[2]);

		char c2[] = {'t','e','s','t'};
		System.out.println(c2[1]);
		System.out.println(c2[0]+' '+c2[1]);
		
	
		//derived
		System.out.println("\nUsing Array List Object (dynamic):");
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("Size:" + al.size());
			//input
		al.add("test1");
		al.add("test2");
			//output
		System.out.println("First Element:" + al.get(0));
		System.out.println("Second Element:" + al.get(1));
		System.out.println("Size:" + al.size());
		//System.out.println("Third Element:" + al.get(2)); //invalid 
	}
}
package staticblocks;

//import StaticImport;

class StaticExample {
	static int a = 1;
	static {
		System.out.println("static code"+a);
	}

	public static void main(String args[]){
		System.out.println("test");

		// another class
		new StaticImport().testFn();
	}
}

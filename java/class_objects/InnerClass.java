class InnerClass {
	public static void main (String args[]){
		System.out.println("\nInside Class:");
		InnerClass innerObj = new InnerClass();
		InnerClass.InsideClass insdeObj = innerObj.new InsideClass();
		insdeObj.normalFn();

		System.out.println("\nInside Static Class:");
		System.out.println(InsideStaticClass.testStr);
		InsideStaticClass.staticFn();
		new InsideStaticClass().normalFn();

	}

	public class InsideClass{
		/* doesn't work */
		//public static String testStr = "staticString";

		/* doesn't work */
		//public void static staticFn(){
		//	System.out.println("static function");
		//}

		public void normalFn(){
			System.out.println("normal function");
		}
	}

	public static class InsideStaticClass{
		public static String testStr = "static String";

		public static void staticFn(){
			System.out.println("static function");
		}

		public void normalFn(){
			System.out.println("normal function");
		}
	}
}

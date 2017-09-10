class StringStudy {
	public static void main(String args[]){
		//Enter one command line argument

		String input = "";
		for(Integer i=0; i<args.length; i++){
			if(i==0){
				input = args[0];
			} else {
				input += " "+args[i];
			}
		}

		System.out.println("String:"+input);
		System.out.println("Length:"+input.length());

		if(isNumeric(input)){
			Double x = Double.valueOf(input);
			System.out.println("Numeric value:"+x);
		}
	}
	
	public static boolean isNumeric(String str){  
		try{
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}
}
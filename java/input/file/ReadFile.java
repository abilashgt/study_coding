import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFile {
	public static void main(String args[]) throws IOException {
		/* read line by line */
		String sCurrentLine;
		BufferedReader br;

		//br = new BufferedReader(new FileReader("/abi_store/coding_study/java/file/testFile.txt"));
		FileReader fr = new FileReader("testFile.txt");
		br = new BufferedReader(fr);
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}

		/* read by each character and store to string */
		FileReader fileReader = new FileReader("testFile.txt");
		String fileContents = "";

		int i;
		while((i =  fileReader.read())!=-1){
			char ch = (char)i;
			fileContents = fileContents + ch; 
		}
		
		System.out.println(fileContents);
	}
}
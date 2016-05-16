import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FirstCommand{

	public static void main(String args[]){
		final String cmd = "ls -l";

		try {
			// Run ls command
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec(cmd);

			//System.out.println("Process exited with code = " + rt.exitValue());

			// Get process' output: its InputStream
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// And print each line
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

			is.close();

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
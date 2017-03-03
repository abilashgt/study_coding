
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class TimezoneExample{

  public static void main(String[] args) {
		TimeZone tz = TimeZone.getTimeZone("GMT+5.30");
		Calendar c = Calendar.getInstance(tz);
		System.out.println(c.getTimeInMillis());
		System.out.println(c.getTime());

		DateFormat df = new SimpleDateFormat("HH");

		df.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		String hour = df.format(Calendar.getInstance().getTime());
		System.out.println(hour);

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("Singapore"));
		hour = df.format(Calendar.getInstance().getTime());
		System.out.println(hour);


	}

}

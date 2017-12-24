package time;

import com.sun.jmx.snmp.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Abilash on 16/2/17.
 */
public class CurrentTimeAndDate {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static void main(String[] args) {
        //method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        //method 2 - via Date
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));

        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
        System.out.println(timestamp.getDateTime());

        //not working
        //format timestamp
        //System.out.println(sdf.format(timestamp));

    }
}

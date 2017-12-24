package time;

import java.util.Calendar;

/**
 * Created by Abilash on 15/2/17.
 */
public class weekend {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: "+cal.getTime());

        cal.set(2017, 2, 18);
        System.out.println("altered date: "+cal.getTime());

        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            System.out.println("Saturday!");
        }
        else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            System.out.println("Sunday!");
        }
        else {
            System.out.println("Not weekend");
        }
    }
}

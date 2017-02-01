package testing.mockito.powermockito;

/**
 * Created by abilash on 30/1/17.
 */
public class RegularFunctions {
    public int sum(){
        int sum = StaticFunctions.add(1,2);
        System.out.println("sum="+sum);
        return sum;
    }
}

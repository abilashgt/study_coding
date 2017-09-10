package testing.mockito.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by abilash on 30/1/17.
 */

@RunWith(PowerMockRunner.class)
public class RegularFunctionsTest {

    @PrepareForTest({ StaticFunctions.class })
    @Test
    public void main(){

        // static
        PowerMockito.mockStatic(StaticFunctions.class);
        PowerMockito.when(StaticFunctions.add(1,2))
                .thenReturn(new Integer(4));

        RegularFunctions rf = new RegularFunctions();
        int sum = rf.sum();
        assertEquals(sum, 4);
    }
}

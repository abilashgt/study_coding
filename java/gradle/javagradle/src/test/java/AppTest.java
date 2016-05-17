import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by abilash on 18/5/16.
 */
public class AppTest {
    App app;

    final static Logger logger = Logger.getLogger("App.class");

    @Test
    public void main(){
        app.main(new String[2]);
        logger.info("hello world test");
        assert(true);
    }
}

package cucumber;


import io.cucumber.java.Before;
import steps.BaseTest;

public class Hooks extends BaseTest {

    @Before
    public void beforeEach() {
        if(CONFIG.getBoolean("debug")){
            //el hook @beforeClass no se lanza cuando se ejecuta sin mvn
            Runner.setup();
        }
    }

}
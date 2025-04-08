package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    // Calls the setUp method from the BaseTest class before each scenario
    @Before
    public void setUp() {
        super.setUp();
    }

    // Calls the tearDown method from the BaseTest class after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            super.takeScreenshot(scenario);
        }
        super.tearDown();
    }
}
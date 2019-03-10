package ltd.idcu.mock;

import ltd.idcu.mock.testapi.HelloControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({ HelloControllerTest.class })
@SpringBootTest
public class MockApplicationTests {

    @Test
    public void contextLoads() {
    }

}

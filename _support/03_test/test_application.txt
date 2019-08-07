import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestApplication {
    private Application application;

    @BeforeEach
    public void setup() {
        application = new Application();
        application.build();
    }

    @Test
    @Order(1)
    public void getComponentPort() {
        assertNotNull(PrimeNumberSearchFactory.build());
    }

    @Test
    @Order(2)
    public void version() {
        assertEquals("prime number search", application.getVersion());
    }

    @Test
    @Order(3)
    public void countFrom1To10() {
        assertEquals(4, application.count(1, 10));
    }

    @Test
    @Order(4)
    public void countFrom1To100() {
        assertEquals(25, application.count(1, 100));
    }

    @Test
    @Order(5)
    public void countFrom1To1000() {
        assertEquals(168, application.count(1, 1000));
    }

    @Test
    @Order(6)
    public void countFrom1To10000() {
        assertEquals(1229, application.count(1, 10000));
    }

    @Test
    @Order(7)
    public void countFrom1To100000() {
        assertEquals(9592, application.count(1, 100000));
    }

    @Test
    @Order(8)
    public void countFrom1To1000000() {
        assertEquals(78498, application.count(1, 1000000));
    }

    @Test
    @Order(9)
    public void countFrom1To10000000() {
        assertEquals(664579, application.count(1, 10000000));
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void testSetup() {
        int expected = 10;
        int actual = 5 + 5;
        assertEquals("Basic addition should work", expected, actual);
    }
}

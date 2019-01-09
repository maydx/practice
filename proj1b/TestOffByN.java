import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testEqualChars() {
        CharacterComparator offByFive = new OffByN(5);

        assertTrue(offByFive.equalChars('a', 'f'));
        assertFalse(offByFive.equalChars('x', 'x'));
    }

}

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ReportTest {

    /**
     * pepega testing => trying to find bug :)
     */
    @Test
    void testIsValid2() {
        List<Integer>i;
        Report r;

        i = List.of(52, 48, 51, 49, 43);
        r = new Report(i);
        assertFalse(r.isValid2());

        i = List.of(52, 51, 49, 43);
        r = new Report(i);
        assertTrue(r.isValid2());

        i = List.of(52, 51, 49, 43, 46, 43);
        r = new Report(i);
        assertTrue(r.isValid2());

        i = List.of(1, 4, 2, 3, 4);
        r = new Report(i);
        assertTrue(r.isValid2());

        i = List.of(4, 1, 3, 2, 1);
        r = new Report(i);
        assertTrue(r.isValid2());

        i = List.of(60, 57, 56, 56, 54, 51, 49);
        r = new Report(i);
        assertTrue(r.isValid2());

        // the bug! => this list is correct when we remove the first element.
        i = List.of(54, 51, 54, 55, 57, 58);
        r = new Report(i);
        assertTrue(r.isValid2());

    }

}

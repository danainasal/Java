package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ex1.PerecheNumere;
import org.junit.jupiter.api.Test;

public class Egall {
    @Test
    void test1 ()
    {
        PerecheNumere p = new PerecheNumere(56, 74);
        assertTrue(p.isSumaCifreEgala());
    }

    @Test
    void test2 ()
    {
        PerecheNumere p = new PerecheNumere(2, 3);
        assertEquals(false, p.isSumaCifreEgala());
    }

    @Test
    void test3 ()
    {
        PerecheNumere p = new PerecheNumere(21, 35);
        assertFalse(p.isSumaCifreEgala());
    }
}

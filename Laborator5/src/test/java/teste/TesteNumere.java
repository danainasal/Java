package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ex1.PerecheNumere;
import org.junit.jupiter.api.Test;

public class TesteNumere {

    @Test
    void test1 ()
    {
        PerecheNumere p = new PerecheNumere(2, 3);
        assertEquals(6, p.cmmmc());
    }

    @Test
    void test2 ()
    {
        PerecheNumere p = new PerecheNumere(5, 10);
        assertTrue(p.cmmmc() == 10);
    }

    @Test
    void test3 ()
    {
        PerecheNumere p = new PerecheNumere(5, 9);
        assertFalse(p.cmmmc() == 2);
    }
}

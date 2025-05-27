import com.example.BaseClasses.Intervenant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class IntervenantTest {

    @BeforeEach
    void resetCounter() throws Exception {
        Field counterField = Intervenant.class.getDeclaredField("counter");
        counterField.setAccessible(true);
        counterField.setInt(null, 0);
    }

    @Test
    void testConstructorIncrementsCounter() {
        new Intervenant("I001", "Alice", "alice@example.com");
        assertEquals(1, Intervenant.getCounter());

        new Intervenant("I002", "Bob", "bob@example.com");
        assertEquals(2, Intervenant.getCounter());
    }

    @Test
    void testSetAndGetCounter() {
        Intervenant.setCounter(5);
        assertEquals(5, Intervenant.getCounter());
    }

    @Test
    void testInheritanceFromParticipant() {
        Intervenant i = new Intervenant("I003", "Charlie", "charlie@example.com");

        assertEquals("I003", i.getId());
        assertEquals("Charlie", i.getNom());
        assertEquals("charlie@example.com", i.getEmail());
    }
}

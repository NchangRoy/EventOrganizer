import com.example.Exceptions.CapaciteMaxAtteinteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapaciteMaxAtteinteExceptionTest {

    @Test
    void testExceptionMessage() {
        String errorMessage = "Capacite Max Atteinte!!";
        CapaciteMaxAtteinteException exception = new CapaciteMaxAtteinteException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}

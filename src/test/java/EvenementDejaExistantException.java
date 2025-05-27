import com.example.Exceptions.EvenementDejaExistantException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenementDejaExistantExceptionTest {

    @Test
    void testExceptionMessage() {
        String message = "Event already exists!";
        EvenementDejaExistantException exception = new EvenementDejaExistantException(message);

        assertEquals(message, exception.getMessage());
    }
}

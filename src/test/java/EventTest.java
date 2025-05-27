import com.example.BaseClasses.Event;
import com.example.BaseClasses.Participant;
import com.example.Exceptions.CapaciteMaxAtteinteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private Event event;
    private Participant p1;
    private Participant p2;

    @BeforeEach
    void setUp() {
        event = new Event("E01", "Tech Conference", LocalDate.of(2025, 10, 15), 2);
        p1 = new Participant("P01", "Alice", "alice@example.com");
        p2 = new Participant("P02", "Bob", "bob@example.com");
    }

    @Test
    void testAjouterParticipant() throws CapaciteMaxAtteinteException {
        event.ajouterParticipant(p1);
        assertEquals(1, event.getParticipants().size());
        assertTrue(event.getParticipants().contains(p1));
    }

    @Test
    void testAjouterParticipantThrowsException() throws CapaciteMaxAtteinteException {
        event.ajouterParticipant(p1);
        event.ajouterParticipant(p2);
        Participant p3 = new Participant("P03", "Charlie", "charlie@example.com");
        assertThrows(CapaciteMaxAtteinteException.class, () -> event.ajouterParticipant(p3));
    }

    @Test
    void testRemoveParticipant() throws CapaciteMaxAtteinteException {
        event.ajouterParticipant(p1);
        event.removeParticipant(p1);
        assertFalse(event.getParticipants().contains(p1));
    }

    @Test
    void testAnnulerDoesNotCrash() throws CapaciteMaxAtteinteException {
        event.ajouterParticipant(p1);
        event.annuler(); // Just ensure no exception is thrown
        assertTrue(true); // Dummy assertion to mark the test passed
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("E01", event.getId());
        assertEquals("Tech Conference", event.getNom());
        assertEquals(LocalDate.of(2025, 10, 15), event.getDate());
        assertEquals(2, event.getCapaciteMax());
    }
}

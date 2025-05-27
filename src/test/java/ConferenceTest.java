import com.example.BaseClasses.Conference;
import com.example.BaseClasses.Intervenant;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceTest {

    private Conference conference;

    @BeforeEach
    void setUp() {
        conference = new Conference("CONF01", "Tech Summit", LocalDate.of(2025, 9, 10), 200, "AI and Robotics");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("CONF01", conference.getId());
        assertEquals("Tech Summit", conference.getNom());
        assertEquals(LocalDate.of(2025, 9, 10), conference.getDate());
        assertEquals(200, conference.getCapaciteMax());
        assertEquals("AI and Robotics", conference.getTheme());
        assertTrue(conference.getIntervenants().isEmpty());
    }

    @Test
    void testSetTheme() {
        conference.setTheme("Quantum Computing");
        assertEquals("Quantum Computing", conference.getTheme());
    }

    @Test
    void testAjouterIntervenant() {
        Intervenant intervenant = new Intervenant("I001", "John Doe", "john@example.com");
        conference.ajouterIntervenant(intervenant);

        List<Intervenant> intervenants = conference.getIntervenants();
        assertEquals(1, intervenants.size());
        assertEquals("John Doe", intervenants.get(0).getNom());
    }

    @Test
    void testAfficherDetails() {
        String details = conference.afficherDetails();
        assertTrue(details.contains("eventID: CONF01"));
        assertTrue(details.contains("eventName: Tech Summit"));
        assertTrue(details.contains("eventDate:10/09/2025"));
        assertTrue(details.contains("eventCapacity: 200"));
        assertTrue(details.contains("Theme: AI and Robotics"));
    }
}

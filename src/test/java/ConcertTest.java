import com.example.BaseClasses.Concert;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertTest {

    private Concert concert;

    @BeforeEach
    void setUp() {
        concert = new Concert("C01", "Jazz Night", LocalDate.of(2025, 8, 20), 150, "Miles Davis", "Jazz");
    }

    @Test
    void testGetters() {
        assertEquals("C01", concert.getId());
        assertEquals("Jazz Night", concert.getNom());
        assertEquals(LocalDate.of(2025, 8, 20), concert.getDate());
        assertEquals(150, concert.getCapaciteMax());
        assertEquals("Miles Davis", concert.getArtiste());
        assertEquals("Jazz", concert.getGenreMusical());
    }

    @Test
    void testSetters() {
        concert.setArtiste("John Coltrane");
        concert.setGenreMusical("Blues");

        assertEquals("John Coltrane", concert.getArtiste());
        assertEquals("Blues", concert.getGenreMusical());
    }

    @Test
    void testAfficherDetails() {
        String details = concert.afficherDetails();
        assertTrue(details.contains("eventID: C01"));
        assertTrue(details.contains("eventName: Jazz Night"));
        assertTrue(details.contains("eventDate:20/08/2025")); // formatted
        assertTrue(details.contains("eventCapacity: 150"));
        assertTrue(details.contains("Artist: Miles Davis"));
        assertTrue(details.contains("genreMusical: Jazz"));
    }
}

import com.example.BaseClasses.Event;
import com.example.Exceptions.EvenementDejaExistantException;
import com.example.Services.GestionEvenement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestionEvenementTest {

    GestionEvenement gestionEvenement;

    @BeforeEach
    void setup() {
        gestionEvenement = GestionEvenement.getGestionEvenement();
        // Clear existing events before each test
        gestionEvenement.setEvenements(null);
    }

    @Test
    void testSingletonInstance() {
        GestionEvenement instance1 = GestionEvenement.getGestionEvenement();
        GestionEvenement instance2 = GestionEvenement.getGestionEvenement();
        assertSame(instance1, instance2, "GestionEvenement should be a singleton");
    }

    @Test
    void testAjouterEtRechercherEvenement() throws EvenementDejaExistantException {
        Event event = new Event("E1", "Test Event", LocalDate.now(), 10);
        gestionEvenement.ajouterEvenement(event);
        assertTrue(gestionEvenement.rechercherEvenement(event), "Event should be found after adding");
    }

    @Test
    void testAjouterEvenementDejaExistantException() throws EvenementDejaExistantException {
        Event event = new Event("E1", "Test Event", LocalDate.now(), 10);
        gestionEvenement.ajouterEvenement(event);
        EvenementDejaExistantException thrown = assertThrows(EvenementDejaExistantException.class, () -> {
            gestionEvenement.ajouterEvenement(event);
        });
        assertEquals("Evenement Existe Deja", thrown.getMessage());
    }

    @Test
    void testSupprimerEvenement() throws EvenementDejaExistantException {
        Event event = new Event("E1", "Test Event", LocalDate.now(), 10);
        gestionEvenement.ajouterEvenement(event);
        assertTrue(gestionEvenement.rechercherEvenement(event));
        gestionEvenement.supprimerEvenement(event);
        assertFalse(gestionEvenement.rechercherEvenement(event));
    }

    @Test
    void testGetEventsAndSetEvenements() throws EvenementDejaExistantException {
        Event event1 = new Event("E1", "Event 1", LocalDate.now(), 5);
        Event event2 = new Event("E2", "Event 2", LocalDate.now(), 8);
        gestionEvenement.ajouterEvenement(event1);
        gestionEvenement.ajouterEvenement(event2);

        assertEquals(2, gestionEvenement.getEvents().size());

        // Reset the list with just one event
        gestionEvenement.setEvenements(java.util.List.of(event1));
        assertEquals(1, gestionEvenement.getEvents().size());
        assertTrue(gestionEvenement.rechercherEvenement(event1));
        assertFalse(gestionEvenement.rechercherEvenement(event2));
    }
}

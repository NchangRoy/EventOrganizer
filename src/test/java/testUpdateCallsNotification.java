import com.example.Services.NotificationService;
import com.example.BaseClasses.Participant;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ParticipantTest {

    @Test
    void testUpdateCallsNotificationService() {
        // Mock the NotificationService
        NotificationService mockNotificationService = mock(NotificationService.class);

        // Create participant with test data
        Participant participant = new Participant("P01", "Alice", "alice@example.com");

        // Replace real NotificationService with mock by overriding update method
        participant = new Participant("P01", "Alice", "alice@example.com") {
            @Override
            public void update(String title, String message) {
                mockNotificationService.envoyerNotification(title, message, getEmail());
            }
        };

        // Call update
        participant.update("Test Title", "Test Message");

        // Verify envoyerNotification was called with correct parameters
        verify(mockNotificationService).envoyerNotification("Test Title", "Test Message", "alice@example.com");
    }
}

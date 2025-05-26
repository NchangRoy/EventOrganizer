import com.example.Services.NotificationService;
import com.example.Services.NotificationServiceImpl;
public class Testemail {
    public static void main(String[] args) {
        NotificationService notificationService=(NotificationService)new NotificationServiceImpl();
        notificationService.envoyerNotification("Hello nigga","Just Greeting", "furehmitoto@gmail.com");
        System.out.println("sending on diffrent thread");
        notificationService.future.join();
    }
}

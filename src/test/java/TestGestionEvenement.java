import java.time.LocalDate;

import com.example.BaseClasses.Concert;
import com.example.BaseClasses.Event;
import com.example.Services.GestionEvenement;

public class TestGestionEvenement {
    public static void main(String[] args) {
        Concert concert1 = new Concert(
            "C001",
            "Summer Fest",
            LocalDate.of(2025, 7, 20),
            5000,
            "The Sun Band",
            "Rock"
        );
        
        Concert concert2 = new Concert(
            "C001",
            "Jazz Night",
            LocalDate.of(2025, 9, 15),
            3000,
            "Smooth Jazz Quartet",
            "Jazz"
        );
GestionEvenement gestionEvenemt=GestionEvenement.getGestionEvenement();
try {
    gestionEvenemt.ajouterEvenement(concert2);
   
} catch (Exception e) {
    e.printStackTrace();
}
    }
}

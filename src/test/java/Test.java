import java.time.LocalDate;

import com.example.BaseClasses.Event;
import com.example.BaseClasses.Participant;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
public class Test {
    public static void main(String[] args) {
         Event event = new Event(
            "E001",
            "Music Festival",
            LocalDate.of(2025, 8, 20),
            2  // max capacity of 2 participants
        );
        Participant participant1 = new Participant("P001", "Alice", "furehmitoto@gmail.com");
        Participant participant2 = new Participant("P002", "Bob", "furehmitoto@gmail.com");
        
        try {
           
            event.ajouterParticipant(participant1);
            event.ajouterParticipant(participant2);
            File file=new File("src/main/java/com/example/SavedJsonFiles/save.json");
            ObjectMapper mapper=new ObjectMapper();
            //to be able to serialize Localdate
            mapper.registerModule(new JavaTimeModule());

            mapper.writeValue(file, event);

            Event event2=mapper.readValue(file,Event.class);
            
            
        } catch (Exception e) { 
            System.out.println(e.getMessage());
        }

        event.notifyParticipants("hello suckers","ssdfj");
        event.annuler();
    }
}

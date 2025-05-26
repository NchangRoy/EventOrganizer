package com.example.BaseClasses;
import com.example.Exceptions.CapaciteMaxAtteinteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
public class Event   {
    private String id;
    private String nom;
    private LocalDate date;
    private int capaciteMax;
    private List<Participant> participants;
    
    public Event(String id, String nom, LocalDate date, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.capaciteMax = capaciteMax;
        participants=new ArrayList<>();
    }
    public Event(){

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
  
    
   

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void ajouterParticipant(Participant particapant)throws CapaciteMaxAtteinteException{
        if(participants.size()+1>capaciteMax){
            throw new  CapaciteMaxAtteinteException("Capacite Max Atteinte!!");
        }
        participants.add(particapant);

    }
    public void removeParticipant(Participant participant){
        participants.remove(participant);
    }
    public void notifyParticipants(String title,String message){
        for(Participant p:participants){
            p.update(title,message);
        }
    }
    public void annuler(){
        String title="Cancelation of "+this.getNom();
        String cancellationMessage = """
Dear Client,

I hope this message finds you well.

I regret to inform you that the %s, scheduled for %s , has been cancelled due to unforeseen circumstances.

We sincerely apologize for any inconvenience this may cause and appreciate your understanding.

If you have any questions or need further information, please feel free to reach out.

Best regards,
schedula
""";

        String message=String.format(cancellationMessage,this.nom,this.getNom(),this.getDate());
        //System.out.println(message);
       notifyParticipants(title,message);
    }
    public String afficherDetails(){
       return null;
    }
    
    
}

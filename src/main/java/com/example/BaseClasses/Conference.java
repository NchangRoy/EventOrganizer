package com.example.BaseClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conference extends Event{
    private String theme;
    private  List<Intervenant> intervenants;
    public Conference(String id, String nom, LocalDate date, int capaciteMax,String theme){
        super(id, nom, date, capaciteMax);
        this.theme=theme;
        intervenants=new ArrayList<>();
    }
    public void ajouterIntervenant(Intervenant intervenant){
        intervenants.add(intervenant);
    }

    @Override
    public String afficherDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String stringDate=super.getDate().format(formatter);
      

       String message="eventID: "+super.getId()+
       "\n"+"eventName: "+
       super.getNom()+"\n"+"eventDate:"+stringDate+"\n"+
       "eventDate:"+stringDate+"\n"+
       "eventCapacity: "+super.getCapaciteMax()+"\n"+
      "Theme: "+theme+"\n";
      return message;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public List<Intervenant> getIntervenants() {
        return intervenants;
    }
    public void setIntervenants(List<Intervenant> intervenants) {
        this.intervenants = intervenants;
    }
    
    

}

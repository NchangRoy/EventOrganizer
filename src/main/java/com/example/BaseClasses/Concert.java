package com.example.BaseClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    String artiste;
    String genreMusical;
    public Concert(String id, String nom, LocalDate date, int capaciteMax,String artiste,String genreMusical){
        super(id, nom, date, capaciteMax);
        this.artiste=artiste;
        this.genreMusical=genreMusical;
    }
    public String getArtiste() {
        return artiste;
    }
    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }
    public void setGenreMusical(String genreMusical) {
        this.genreMusical = genreMusical;
    }
    public String getGenreMusical() {
        return genreMusical;
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
       "Artist: "+artiste+"\n"+
       "genreMusical: "+genreMusical+"\n";
       return message;
    }

}

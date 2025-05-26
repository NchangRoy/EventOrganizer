package com.example.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.BaseClasses.Event;
import com.example.Exceptions.EvenementDejaExistantException;
public class GestionEvenement {
    Map<String,Event> evenements;
    static GestionEvenement gestionEvenement=new GestionEvenement();
    private GestionEvenement(){
        evenements=new HashMap<>();
    }
    //method to return static reference to the class(Singleton)
    public static GestionEvenement getGestionEvenement(){
        return gestionEvenement;
    }
    public void ajouterEvenement(Event event) throws EvenementDejaExistantException{
        if(rechercherEvenement(event)){
            throw new EvenementDejaExistantException("Evenement Existe Deja");
        }
        else{
            evenements.put(event.getId(),event);
        }
       

    }
    public void supprimerEvenement(Event event){
        evenements.remove(event.getId());
    }
    public boolean rechercherEvenement(Event event){
        
        List<Event> list=new ArrayList<>(evenements.values());
        return list.stream().anyMatch(ev->ev.getId().equals(event.getId()));

    }
    public List<Event> getEvents(){
        return new ArrayList<>(evenements.values());
    }
}

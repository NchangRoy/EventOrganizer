package com.example.BaseClasses;

import java.util.ArrayList;
import java.util.List;

public class Organisateur extends Participant {
    List<Event> evenement;
    Organisateur(String id, String nom, String email){
        super(id, nom, email);
        evenement=new ArrayList<>();
    }
}

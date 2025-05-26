package com.example.BaseClasses;

import com.example.Services.NotificationService;
import com.example.Services.NotificationServiceImpl;

public class Participant {
    private String id;
    private String nom;
    private String email;
    //counter to create simple id like P00+number
    static int counter;
    public Participant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        counter+=1;
    }
    public Participant(){

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   public static int getCounter(){
        return counter;
    }

    public void update(String title,String message){
        NotificationService notificationService=(NotificationService)new NotificationServiceImpl();
        notificationService.envoyerNotification(title, message, this.email);
    }
}

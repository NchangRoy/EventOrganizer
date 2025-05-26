package com.example.BaseClasses;

public class Intervenant extends Participant {
    static int counter=0;
        public Intervenant(String id, String nom, String email){
        super(id, nom, email);
        counter+=1;
    }
        public static int getCounter() {
            return counter;
        }
        public static void setCounter(int counter) {
            Intervenant.counter = counter;
        }

}

package com.example.Exceptions;
import java.lang.Exception;
public class EvenementDejaExistantException extends Exception {
    public EvenementDejaExistantException(String message){
        super(message);
    }
}

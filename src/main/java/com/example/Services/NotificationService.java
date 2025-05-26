package com.example.Services;

import java.util.concurrent.CompletableFuture;

public interface NotificationService {

     public static final CompletableFuture<Void> future = new CompletableFuture<Void>();
    public void envoyerNotification(String subject,String body,String receiverEmail);
    
} 
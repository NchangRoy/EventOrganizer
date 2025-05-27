package com.example.Controllers;

import java.util.concurrent.CompletableFuture;

import javax.management.Notification;

import com.example.BaseClasses.Event;
import com.example.BaseClasses.Participant;
import com.example.Services.NotificationService;
import com.example.Services.NotificationServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class eventOptions {
    Event event;
   
   Scene previousScene;
    @FXML
    private Label alertLabel;

    @FXML
    private Label eventNameLabel;

    @FXML
    void cancelEvent(ActionEvent event) {
   
    this.event.annuler();
    }

    @FXML
    void manageParticipants(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/manageParticpants.fxml"));
       try {

        Parent parent=loader.load();
        //get and previous scene to ease navigation
        Scene previouScene=((Node) event.getSource()).getScene();
        ManageParticpantsController controller=loader.getController();
        controller.initialize(previouScene,this.event);
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
       } catch (Exception e) {
       e.printStackTrace();
       }

    }

    @FXML
    void modifyEvent(ActionEvent event) {
        if(this.event.getClass().getSimpleName().equals("Conference")){
           FXMLLoader loader=new FXMLLoader(getClass().getResource("/conferenceUI.fxml"));
           try {
            Parent root=loader.load();
            Scene scene=new Scene(root);

            ConferenceUIController controller=loader.getController();
            Scene previousScene=((Node)event.getSource()).getScene();
            controller.initialize(this.event, previousScene);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Modify Conference");
            //clock current stage 
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
           } catch (Exception e) {
           e.printStackTrace();
           }

        }
        if(this.event.getClass().getSimpleName().equals("Concert")){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/concertUI.fxml"));
            try {
             Parent root=loader.load();
             Scene scene=new Scene(root);
 
             concertUIController controller=loader.getController();
             Scene previousScene=((Node)event.getSource()).getScene();
             controller.initialize(this.event, previousScene);
             Stage stage=new Stage();
             stage.setScene(scene);
             stage.show();
             stage.setTitle("Modify Concert");
             //clock current stage 
             Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             currentStage.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        }

    }

    @FXML
    void sendNotifications(ActionEvent event) {
        CompletableFuture<Void> future=new CompletableFuture<>();
        NotificationService notificationService=(NotificationService)new NotificationServiceImpl();
        for(Participant p: this.event.getParticipants()){
           
            future.runAsync(()->{
                String body=String.format(""" 
                Hello %s,

                Thank you for registering for the event:\n
                %s
                We’re excited to have you join us!  
                """,p.getNom(),this.event.afficherDetails());
               
                notificationService.envoyerNotification("Event Notification", body, p.getEmail());
            
            });
            
        }
       
        alertLabel.setText("Notification delivered to all Participants");
    }
    @FXML
    void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(previousScene);
    }

    void initialize(Event event,Scene scene){
        this.event=event;
       
        previousScene=scene;
        eventNameLabel.setText(event.getId()+":"+event.getNom());

        
    }

}

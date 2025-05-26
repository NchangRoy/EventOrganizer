package com.example.Services;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.CompletableFuture;
public class NotificationServiceImpl implements NotificationService{
    
    String password="ncmw toxd xbvf arxy";
    String email="furehmitoto@gmail.com";
    public CompletableFuture<Void> future=new CompletableFuture<>();
    public NotificationServiceImpl(String email,String password){
        this.email=email;
        this.password=password;
       
    }
    public NotificationServiceImpl(){
        
    }
    
    

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public static Session createSession(String email, String password) {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.ssl.trust","smtp.gmail.com");

    return Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(email, password);
        }
    });
}

public static void sendPlainTextEmail(Session session, String from, String to, String subject, String body) throws MessagingException {
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    message.setSubject(subject);
    message.setText(body);

    Transport.send(message);
    System.out.println("Plain text email sent!");
}




@Override
public void envoyerNotification(String subject,String body,String receiverEmail) {
    
       
            Session session=createSession(email, password);
        try {
            sendPlainTextEmail(session, email, receiverEmail,subject, body);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        //block mainthread for it to wait for this to finish
        
    
        
   
}

}

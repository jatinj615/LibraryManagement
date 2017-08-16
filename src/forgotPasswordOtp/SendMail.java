package forgotPasswordOtp;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import connection.Connections;

import java.util.Properties;

import javax.activation.*;

public class SendMail {	
	public static boolean send(String from,String pass,String to,String username) {
		boolean status=false;
		String sub="One Time Password";
		String msg="Your one time password to reset your password is : ";
		 Properties props = new Properties();    
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {    
                 protected PasswordAuthentication getPasswordAuthentication() {    
                 return new PasswordAuthentication(from,pass);  
                 }    
                });    
         try {    
             MimeMessage message = new MimeMessage(session);    
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
             message.setSubject(sub); 
             msg=msg+GenerateOtp.code(username);
             message.setText(msg);     
             Transport.send(message);  
             status=true;
            } catch (MessagingException e) {throw new RuntimeException(e);}    
               
		return status;
		}	
}



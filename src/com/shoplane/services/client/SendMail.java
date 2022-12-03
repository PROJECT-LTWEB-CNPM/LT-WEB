package com.shoplane.services.client;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.shoplane.models.User;

public class SendMail {
  public SendMail() {

  }

  public String getRandom() {
    Random rand = new Random();
    int number = rand.nextInt(999999);
    return String.format("%06d", number);
  }

  public boolean sendMail(User user) {
    boolean isSend = false;
    String toEmail = user.getEmail();
    /*
     * String fromEmail = "doduongthaituan201102@gmail.com";
     * String fromPwd = "ddqzmkydrtjexbfj";
     */
    String fromEmail = "20110743@student.hcmute.edu.vn";
    String fromPwd = "Tuanvn1234567890..";
    try {

      // your host email smtp server details
      Properties pr = new Properties();
      pr.setProperty("mail.smtp.host", "smtp.gmail.com");
      pr.setProperty("mail.smtp.port", "587");
      pr.setProperty("mail.smtp.auth", "true");
      pr.setProperty("mail.smtp.starttls.enable", "true");
      pr.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//    pr.put("mail.debug", "true");
//    pr.setProperty("mail.smtp.ssl.trust", "*");
      /*
       * pr.put("mail.smtp.socketFactory.port", "587");
       * pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       * pr.put("mail.smtp.socketFactory.fallback", "true");
       */
      // get session to authenticate the host email address and password
      Session session = Session.getInstance(pr, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(fromEmail, fromPwd);
        }
      });

      // set email message details
      Message mess = new MimeMessage(session);

      // set from email address
      mess.setFrom(new InternetAddress(fromEmail));
      // set to email address or destination email address
      mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

      // set email subject
      mess.setSubject("User Email Verification");

      // set message text
      mess.setText("Registered successfully. Please verify your account using this code: " + user.getCode());
      // send the message
      Transport.send(mess);

      isSend = true;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return isSend;
  }
}

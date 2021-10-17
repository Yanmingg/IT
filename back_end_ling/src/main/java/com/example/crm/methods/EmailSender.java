package com.example.crm.methods;


import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
    This class provides the functions to send emails, which provides
    two com.example.crm.methods to deal with sending one email or several emails.
    1. Giving one email address
    2. Giving an array list of email address
 */
public class EmailSender{
    private Session newSession = null;
    private MimeMessage mimeMessage = null;

    // Send email to customer by an official account
    private void sendEmail() throws MessagingException {
        String OFFICIAL_ACCOUNT = "personalcrmofficial@gmail.com";
        String OFFICIAL_ACCOUNT_PASSWORD = "Gym20010212";
        String fromUser = OFFICIAL_ACCOUNT;
        String fromUserPassword = OFFICIAL_ACCOUNT_PASSWORD;
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    // Setting up server
    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);
    }

    // Hold to send email to several customers
    private MimeMessage draftEmail(List<String> receiver, String emailSubject,
                                   String emailBody) throws AddressException,
            MessagingException, IOException {
        mimeMessage = new MimeMessage(newSession);

        for (String email: receiver)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        }
        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(emailBody);
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    // Hold to send email to one customer
    private MimeMessage draftOneEmail(String receiver, String emailSubject, String emailBody) throws AddressException, MessagingException, IOException {
        mimeMessage = new MimeMessage(newSession);

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(emailBody);
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    // Ready to send one email
    public void sendOneEmail(String receiver, String emailSubject, String emailBody) throws IOException, MessagingException {
        this.setupServerProperties();
        this.draftOneEmail(receiver, emailSubject, emailBody);
        this.sendEmail();
    }

    // Ready to send emails
    public void sendEmail(List<String> receiver, String emailSubject,
                          String emailBody, String senderAddress, String senderName) throws IOException, MessagingException {
        this.setupServerProperties();
        String showSender;
        showSender = "This email was sent by "+ senderName + ". Which email is: " + senderAddress + ".\n";
        String body = showSender + emailBody;
        this.draftEmail(receiver, emailSubject, body);
        this.sendEmail();
    }

}

import java.io.IOException;
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

public class EmailSender{
    Session newSession = null;
    MimeMessage mimeMessage = null;

    private void sendEmail() throws MessagingException {
        String fromUser = "personalcrmofficial@gmail.com";  //Enter sender email id
        String fromUserPassword = "Gym20010212";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    private MimeMessage defaultDraftEmail() throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {"yanmingg@student.unimelb.edu.au", "thhuang@student.unimelb.edu.au",
                "jinjied@student.unimelb.edu.au", "linghuang@student.unimelb.edu.au","quanyingl@student.unimelb.edu.au"};  //Enter list of email recepients
        String emailSubject = "PCRM from team66";
        String emailBody = "Hi, there! Our team66 is glad to invite to be beta-developer for our product Personal CRM!";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE
        // CREATE MESSAGE BODY PARTS
        // CREATE MESSAGE MULTIPART
        // ADD MESSAGE BODY PARTS ----> MULTIPART
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object


        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody,"html/text");
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);
    }

    public void send() throws IOException, MessagingException {
        this.setupServerProperties();
        this.defaultDraftEmail();
        this.sendEmail();
    }

    public void sendEmail(String[] receiver, String emailSubject, String emailBody) throws IOException, MessagingException {
        this.setupServerProperties();
        this.draftEmail(receiver, emailSubject, emailBody);
        this.sendEmail();
    }
    private MimeMessage draftEmail(String[] receiver, String emailSubject, String emailBody) throws AddressException, MessagingException, IOException {
        //String[] emailReceipients = {"yanmingg@student.unimelb.edu.au", "thhuang@student.unimelb.edu.au",
              //  "jinjied@student.unimelb.edu.au", "linghuang@student.unimelb.edu.au","quanyingl@student.unimelb.edu.au"};  //Enter list of email recepients
        //String emailSubject = "PCRM from team66";
        //String emailBody = "Hi, there! Our team66 is glad to invite to be beta-developer for our product Personal CRM!";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<receiver.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver[i]));
        }
        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE
        // CREATE MESSAGE BODY PARTS
        // CREATE MESSAGE MULTIPART
        // ADD MESSAGE BODY PARTS ----> MULTIPART
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object


        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(emailBody);
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    private MimeMessage draftOneEmail(String receiver, String emailSubject, String emailBody) throws AddressException, MessagingException, IOException {
        //String[] emailReceipients = {"yanmingg@student.unimelb.edu.au", "thhuang@student.unimelb.edu.au",
        //  "jinjied@student.unimelb.edu.au", "linghuang@student.unimelb.edu.au","quanyingl@student.unimelb.edu.au"};  //Enter list of email recepients
        //String emailSubject = "PCRM from team66";
        //String emailBody = "Hi, there! Our team66 is glad to invite to be beta-developer for our product Personal CRM!";
        mimeMessage = new MimeMessage(newSession);

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE
        // CREATE MESSAGE BODY PARTS
        // CREATE MESSAGE MULTIPART
        // ADD MESSAGE BODY PARTS ----> MULTIPART
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object


        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(emailBody);
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    public void sendOneEmail(String receiver, String emailSubject, String emailBody) throws IOException, MessagingException {
        this.setupServerProperties();
        this.draftOneEmail(receiver, emailSubject, emailBody);
        this.sendEmail();
    }
}

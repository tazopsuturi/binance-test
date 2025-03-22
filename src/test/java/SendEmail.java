import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
	private static final String EMAIL = "email@gmail.com";
	private static final String PASSWORD = "password";
	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final int SMTP_PORT = 587;
	
	public void sendEmail(String recipient, String subject, String body) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", SMTP_HOST);
		properties.put("mail.smtp.port", SMTP_PORT);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, PASSWORD);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(subject);
			message.setText(body);
			
			Transport.send(message);
			System.out.println("Email sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

package raihan.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class ConsumerService {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = "myQueue")
    public void receivedMessage(String text) {
        System.out.println("Received: " + text);
        sendEmail(text);
    }

    public void sendEmail(String text) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom("muhammadraihan.mrpw@gmail.com"); // email pengirim
            helper.setTo("raemon@pnp.ac.id");   // email tujuan
            helper.setSubject("Notifikasi Order Baru");

            String html = "<div style='font-family:Arial'>" +
                    "<h2 style='color:green'>Order Baru Masuk</h2>" +
                    "<pre>" + text + "</pre>" +
                    "<br><p>Terima kasih</p>" +
                    "</div>";

            helper.setText(html, true);

            mailSender.send(mimeMessage);

            System.out.println("✅ Email berhasil dikirim");

        } catch (Exception e) {
            System.out.println("❌ Error email: " + e.getMessage());
        }
    }
}
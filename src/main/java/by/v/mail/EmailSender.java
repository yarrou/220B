package by.v.mail;

import by.v.entity.InputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class EmailSender implements Runnable{
    @Autowired
    private JavaMailSender mailSender;
    @Value("${S_EMAIL}")
    private String defaultEmail;
    @Value("${T_EMAIL}")
    private String toEmail;
    private InputMessage inputMessage;

    public void sendInputMessage()  {
        log.debug("отправка ссылки на подтверждение регистрацию на email");
        String fromAddress = defaultEmail;
        String senderName = "220B";
        String subject = "Поступило новое сообщение";
        String content = "Cooбщение от [[name]],<br>"
                + inputMessage.getText() +"<br>"
                + "Контактный email - [[URL]] ";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom(fromAddress, senderName);
            helper.setTo(toEmail);
            helper.setSubject(subject);

            content = content.replace("[[name]]", inputMessage.getName());

            content = content.replace("[[URL]]", inputMessage.getEmail());

            helper.setText(content, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Не удалось отправить сообщение",e);
        } catch (UnsupportedEncodingException e) {
            log.error("Не удалось отправить сообщение",e);
        }

    }

    public void setInputMessage(InputMessage inputMessage) {
        this.inputMessage = inputMessage;
    }

    @Override
    public void run() {
        sendInputMessage();
    }
}

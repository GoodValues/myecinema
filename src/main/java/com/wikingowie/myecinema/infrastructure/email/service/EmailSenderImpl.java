package com.wikingowie.myecinema.infrastructure.email.service;

import com.wikingowie.myecinema.infrastructure.email.dto.EmailFields;
import com.wikingowie.myecinema.infrastructure.email.dto.TemplateFields;
import com.wikingowie.myecinema.infrastructure.email.exception.EmailServiceException;
import org.hibernate.sql.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderImpl.class);

    public EmailSenderImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(EmailFields emailFields) throws EmailServiceException {

        MimeMessage mimeMessage;
        String[] recipients = createRecipients(emailFields.getRecipients());
        try {
            mimeMessage = prepareMessage(emailFields, recipients);
        } catch(MessagingException e) {
            LOGGER.warn(String.format("Email not sended. An exception occured! %s", e.getMessage()));
            throw new EmailServiceException(e);
        } catch(IllegalArgumentException e) {
            LOGGER.warn(String.format("Email not sended. An exception occured! %s", e.getMessage()));
            throw new EmailServiceException(e);
        }

        javaMailSender.send(mimeMessage);
        LOGGER.info("Email was sent successfully!");
    }

    private MimeMessage prepareMessage(EmailFields emailFields, String[] recipients) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(recipients);
        helper.setSubject(emailFields.getSubject());
        helper.setText(prepareTemplateMail(emailFields.getTemplateFields()), true);
        return mimeMessage;
    }

    private String prepareTemplateMail(TemplateFields templateFields) {
        Context context = new Context();
        context.setVariables(templateFields.getVariables());
        return templateEngine.process(templateFields.getTemplateName(), context);
    }

    private String[] createRecipients(List<String> recipients) {
        return recipients.stream().toArray(String[]::new);
    }
}

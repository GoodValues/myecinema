package com.wikingowie.myecinema.infrastructure.email.service;

import com.wikingowie.myecinema.infrastructure.email.dto.EmailFields;

public interface EmailSender {
    void sendEmail(EmailFields emailFields);
}

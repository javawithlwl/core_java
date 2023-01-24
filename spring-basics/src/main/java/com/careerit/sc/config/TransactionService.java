package com.careerit.sc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private SMSService smsService;
    @Autowired
    private EmailService emailService;
}

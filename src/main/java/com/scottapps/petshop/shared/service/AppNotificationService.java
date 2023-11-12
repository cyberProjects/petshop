package com.scottapps.petshop.shared.service;

import com.scottapps.petshop.framework.Notification;
import com.scottapps.petshop.framework.NotificationService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class AppNotificationService implements NotificationService {
    @Inject
    Logger log;

    @Override
    public void notify(Notification notification) throws IOException {
        log.info("Sending a notification e-mail!");
    }
}

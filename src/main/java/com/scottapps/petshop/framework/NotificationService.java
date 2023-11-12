package com.scottapps.petshop.framework;

import java.io.IOException;

public interface NotificationService {
    void notify(Notification notification) throws IOException;
}

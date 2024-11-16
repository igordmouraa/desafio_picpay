package br.com.igordmoura.desafio_picpay.service;

import br.com.igordmoura.desafio_picpay.client.NotificationClient;
import br.com.igordmoura.desafio_picpay.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer) {
        try {
            logger.info("Sending notification to user...");

            var response = notificationClient.sendNotification(transfer);

            if (response.getStatusCode().isError()) {
                logger.error("Error while sending notification, status code isn't OK");
            }

            notificationClient.sendNotification(transfer);
        } catch (Exception e) {
            logger.error("Error while sending notification", e);
        }
    }

}

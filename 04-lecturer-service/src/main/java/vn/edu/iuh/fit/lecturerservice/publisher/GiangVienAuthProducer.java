package vn.edu.iuh.fit.lecturerservice.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lecturerservice.event.GiangVienEvent;


@Service
public class GiangVienAuthProducer {
    @Value("${lecturer.exchange}")
    private String exchange;
    @Value("${lecturer.auth.queue.key}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(GiangVienAuthProducer.class);

//    LECTURER
    public boolean sendToAuthService(GiangVienEvent giangVienEvent) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, giangVienEvent);
            LOGGER.info("Lecturer sent Auth successfully: " + giangVienEvent);
            return true;
        } catch (Exception e) {
            LOGGER.error("Error sending to Auth: " + giangVienEvent);
            LOGGER.error(e+"");
            return false;
        }
    }
}

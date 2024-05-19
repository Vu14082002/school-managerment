package vn.edu.iuh.fit.lecturerservice.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lecturerservice.event.GiangVienEvent;

@Service
public class GiangVienSubjectProducer {
    @Value("${lecturer.exchange}")
    private String exchange;
    @Value("${lecturer.subject.queue.key}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(GiangVienAuthProducer.class);

    public boolean sendToAuthService(GiangVienEvent sinhVienEvent) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, sinhVienEvent);
            LOGGER.info("Lecturer sent Subject successfully: " + sinhVienEvent);
            return true;
        } catch (Exception e) {
            LOGGER.error("Error sending to Subject: " + sinhVienEvent);
            LOGGER.error(e+"");
            return false;
        }
    }
}

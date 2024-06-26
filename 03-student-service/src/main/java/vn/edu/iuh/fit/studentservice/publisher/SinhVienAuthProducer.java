package vn.edu.iuh.fit.studentservice.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.studentservice.event.SinhVienEvent;


@Service
public class SinhVienAuthProducer {
    @Value("${student.exchange}")
    private String exchange;
    @Value("${student.auth.queue.key}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(SinhVienAuthProducer.class);

    public boolean sendToAuthService(SinhVienEvent sinhVienEvent) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, sinhVienEvent);
            LOGGER.info("Student sent auth successfully: " + sinhVienEvent);
            return true;
        } catch (Exception e) {
            LOGGER.error("Error sending auth: " + sinhVienEvent);
            LOGGER.error(e+"");
            return false;
        }
    }
}

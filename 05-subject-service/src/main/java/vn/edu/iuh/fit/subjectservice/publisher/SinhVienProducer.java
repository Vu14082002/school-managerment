//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class SinhVienProducer {
//    @Value("${spring.rabbitmq.exchange.student}")
//    private String exchange;
//    @Value("${spring.rabbitmq.routingKey.student.auth}")
//    private String routingKey;
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    private final Logger LOGGER = LoggerFactory.getLogger(SinhVienProducer.class);
//
//    public boolean sendToAuthService(SinhVienAuthEvent sinhVienEvent) {
//        try {
//            rabbitTemplate.convertAndSend(exchange, routingKey, sinhVienEvent);
//            LOGGER.info("Student sent successfully: " + sinhVienEvent);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("Error sending order: " + sinhVienEvent);
//            LOGGER.error(e+"");
//            return false;
//        }
//    }
//}

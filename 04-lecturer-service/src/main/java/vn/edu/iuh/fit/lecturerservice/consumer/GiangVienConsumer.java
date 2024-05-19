package vn.edu.iuh.fit.lecturerservice.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GiangVienConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(GiangVienConsumer.class);

//    @RabbitListener(queues = {"${spring.rabbitmq.queue.student.auth}"})
//    public void receiveOrder(SinhVienEvent sinhVienEvent) {
//        LOGGER.info(String.format("Received order: %s", sinhVienEvent.getStudentId()));
//        LOGGER.info(String.format("Received order: %s", sinhVienEvent.getPassword()));
//    }
}


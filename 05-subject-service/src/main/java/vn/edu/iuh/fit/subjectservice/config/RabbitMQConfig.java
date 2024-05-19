package vn.edu.iuh.fit.subjectservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Queue for incoming messages from other services
    @Value("${student.exchange}")
    private String studentExchange;
    @Value("${student.subject.queue}")
    private String studentQueue;
    @Value("${student.subject.queue.key}")
    private String studentRoutingKey;

    // Queue for lecturer messages
    @Value("${lecturer.exchange}")
    private String lecturerExchange;
    @Value("${lecturer.subject.queue}")
    private String lecturerQueue;
    @Value("${lecturer.subject.queue.key}")
    private String lecturerRoutingKey;

    // Queue for this service
    @Value("${subject.exchange}")
    private String serviceExchange;
    @Value("${subject.queue}")
    private String serviceQueue;
    @Value("${subject.key}")
    private String serviceRoutingKey;

    @Bean
    public DirectExchange studentExchange() {
        return new DirectExchange(studentExchange);
    }

    @Bean
    public Queue studentQueue() {
        return new Queue(studentQueue, true);
    }

    @Bean
    public Binding studentBinding() {
        return BindingBuilder.bind(studentQueue()).to(studentExchange()).with(studentRoutingKey);
    }

    @Bean
    public DirectExchange lecturerExchange() {
        return new DirectExchange(lecturerExchange);
    }

    @Bean
    public Queue lecturerQueue() {
        return new Queue(lecturerQueue, true);
    }

    @Bean
    public Binding lecturerBinding() {
        return BindingBuilder.bind(lecturerQueue()).to(lecturerExchange()).with(lecturerRoutingKey);
    }

    @Bean
    public DirectExchange serviceExchange() {
        return new DirectExchange(serviceExchange);
    }

    @Bean
    public Queue serviceQueue() {
        return new Queue(serviceQueue, true);
    }

    @Bean
    public Binding serviceBinding() {
        return BindingBuilder.bind(serviceQueue()).to(serviceExchange()).with(serviceRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}

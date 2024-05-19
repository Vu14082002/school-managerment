package vn.edu.iuh.fit.lecturerservice.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    @Value("${lecturer.exchange}")
    private String exchange;

    @Value("${lecturer.auth.queue}")
    private String lecturerAuthQueue;
    @Value("${lecturer.auth.queue.key}")
    private String lecturerAuthQueueKey;

    @Value("${lecturer.subject.queue}")
    private String lecturerSubjectQueue;
    @Value("${lecturer.subject.queue.key}")
    private String lecturerSubjectQueueKey;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue lecturerAuthQueue() {
        return new Queue(lecturerAuthQueue, true);
    }

    @Bean
    public Queue lecturerSubjectQueue() {
        return new Queue(lecturerSubjectQueue, true);
    }

    @Bean
    public Binding bindingLecturerAuth(DirectExchange exchange, Queue lecturerAuthQueue) {
        return BindingBuilder.bind(lecturerAuthQueue).to(exchange).with(lecturerAuthQueueKey);
    }

    @Bean
    public Binding bindingLecturerSubject(DirectExchange exchange, Queue lecturerSubjectQueue) {
        return BindingBuilder.bind(lecturerSubjectQueue).to(exchange).with(lecturerSubjectQueueKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}


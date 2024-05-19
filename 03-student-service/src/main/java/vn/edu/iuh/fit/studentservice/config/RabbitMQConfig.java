package vn.edu.iuh.fit.studentservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${student.exchange}")
    private String exchange;

    @Value("${student.auth.queue}")
    private String studentAuthQueue;
    @Value("${student.auth.queue.key}")
    private String studentAuthQueueKey;

    @Value("${student.subject.queue}")
    private String studentSubjectQueue;
    @Value("${student.subject.queue.key}")
    private String studentSubjectQueueKey;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue studentAuthQueue() {
        return new Queue(studentAuthQueue, true);
    }

    @Bean
    public Queue studentSubjectQueue() {
        return new Queue(studentSubjectQueue, true);
    }

    @Bean
    public Binding bindingStudentAuth(DirectExchange exchange, Queue studentAuthQueue) {
        return BindingBuilder.bind(studentAuthQueue).to(exchange).with(studentAuthQueueKey);
    }

    @Bean
    public Binding bindingStudentSubject(DirectExchange exchange, Queue studentSubjectQueue) {
        return BindingBuilder.bind(studentSubjectQueue).to(exchange).with(studentSubjectQueueKey);
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

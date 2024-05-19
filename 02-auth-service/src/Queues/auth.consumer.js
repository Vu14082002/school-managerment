const { createNewUser } = require('../services/auth.service');
const { createConnection } = require('./connection.amqp');

// consumer.js
require('dotenv').config();

async function consumeStudentAuthMessage(channel) {
  try {
    if (!channel) {
      channel = createConnection();
    }
    const queueName = process.env.STUDENT_QUEUE;
    const exchangeName = process.env.STUDENT_EXCHANGE;
    const routingKey = process.env.STUDENT_KEY;
    await channel.assertExchange(exchangeName, 'direct');
    await channel.assertQueue(queueName, { durable: true });
    await channel.bindQueue(queueName, exchangeName, routingKey);
    channel.consume(queueName, async (message) => {
      if (message !== null) {
        const content = JSON.parse(message.content.toString());
        await createNewUser(content.username, content.password, content.role);
        channel.ack(message);
      }
    });
  } catch (error) {
    console.error('Error while consuming queue:', error);
  }
}
async function consumeLecturerAuthMessage(channel) {
  try {
    if (!channel) {
      channel = createConnection();
    }
    const queueName = process.env.LECTURER_QUEUE;
    const exchangeName = process.env.LECTURER_EXCHANGE;
    const routingKey = process.env.LECTURER_KEY;
    await channel.assertExchange(exchangeName, 'direct');
    await channel.assertQueue(queueName, { durable: true });
    await channel.bindQueue(queueName, exchangeName, routingKey);
    channel.consume(queueName, async (message) => {
      if (message !== null) {
        const content = JSON.parse(message.content.toString());
        await createNewUser(content.username, content.password, content.role);
        channel.ack(message);
      }
    });
  } catch (error) {
    console.error('Error while consuming queue:', error);
  }
}

module.exports = { consumeStudentAuthMessage, consumeLecturerAuthMessage };

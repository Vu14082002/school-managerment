const { createConnection } = require('./connection.amqp');
require('dotenv').config();
const publishDirectMessage = async (exchangeName, routingKey, message) => {
  try {
    // initialize
    const channel = await createConnection();
    const queueName = process.env.QUEUE_NAME;
    // publish message
    // declare = false --> server crack then message will be lost
    await channel.assertQueue(queueName, { durable: false });
    await channel.assertExchange(exchangeName, 'direct', { durable: false });
    await channel.bindQueue(queueName, exchangeName, routingKey);
    await channel.publish(exchangeName, routingKey, Buffer.from(JSON.stringify(message)));
  } catch (error) {
    console.error('Error while publishing message:', error);
  }
};

module.exports = { publishDirectMessage };

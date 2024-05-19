// creaet connecttion to rabbitmq
const client = require('amqplib');
require('dotenv').config();
// create connection to rabbitmq cloud
const createConnection = async () => {
  try {
    const connection = await client.connect(process.env.RABITMQ_URL);
    const chanel = connection.createChannel();
    closeConnection(chanel, connection);
    return chanel;
  } catch (error) {
    throw error;
  }
};

const closeConnection = async (chanel, connection) => {
  process.on('SIGINT', () => {
    chanel.close();
    connection.close();
  });
};

module.exports = { createConnection, closeConnection };

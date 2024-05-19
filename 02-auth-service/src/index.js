const { consumeStudentAuthMessage, consumeLecturerAuthMessage } = require('./Queues/auth.consumer');
const { createConnection } = require('./Queues/connection.amqp');
const { app } = require('./app');

const port = process.env.PORT;
let server;

const startServer = () => {
  server = app.listen(port, () => {
    console.log(`API Gateway Service running on port ${port}`);
  });
};

createConnection()
  .then(async (channel) => {
    await consumeStudentAuthMessage(channel);
    await consumeLecturerAuthMessage(channel);
    startServer();
  })
  .catch((error) => {
    console.error('Error creating connection:', error);
  });

const exitHandler = () => {
  if (server) {
    server.close(() => {
      console.log('Server closed');
      process.exit(1);
    });
  } else {
    process.exit(1);
  }
};

const unexpectedErrorHandler = (err, req, res, next) => {
  exitHandler();
  process.exit(1);
};

process.on('uncaughtException', unexpectedErrorHandler);
process.on('unhandledRejection', unexpectedErrorHandler);

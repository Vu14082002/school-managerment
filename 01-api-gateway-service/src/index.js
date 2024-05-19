const { app } = require('./app');

const port = process.env.PORT || 4000;
let server = app.listen(port, () => {
  console.log(`API Gateway Service running on port ${port}`);
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

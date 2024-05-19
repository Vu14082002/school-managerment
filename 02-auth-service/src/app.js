const express = require('express');
require('dotenv').config();
const morgan = require('morgan');
const helmet = require('helmet');
const cors = require('cors');
const mongoSanitize = require('express-mongo-sanitize');
const cookieParser = require('cookie-parser');
const compression = require('compression');
const { StatusCodes } = require('http-status-codes');
const { CustomError } = require('./handlers/error.handler');
const { databaseConnection } = require('./db/maria.connection');
const JWT = require('jsonwebtoken');
const { createConnection } = require('./Queues/connection.amqp');
const { consumeQueue, consumeStudentAuthMessage } = require('./Queues/auth.consumer');
const { router } = require('./routes');
const app = express();

// Middlewares
app.use(morgan('common'));

app.use(helmet());
app.use(
  cors({
    origin: '*',
  })
);
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(mongoSanitize());
app.use(cookieParser());
app.use(compression());
// start queue service

// start database connection
databaseConnection();
// apigateway routes handlers
app.use('/api/v1', router);
// hander for not found resources
// error handler
app.use('*', (req, res, next) => {
  const fullUrl = req.protocol + '://' + req.get('host') + req.originalUrl;
  res.status(StatusCodes.NOT_FOUND).json({
    message: `Requested URL ${fullUrl} Not Found`,
  });
  next();
});
app.use('*', (error, req, res, next) => {
  if (error instanceof CustomError) {
    res.status(error.statusCode).json({
      message: error.serizalizeError(),
    });
  }
});
app.use((req, _res, next) => {
  if (req.headers.authorization) {
    const token = req.headers.authorization.split(' ')[1];
    const payload = JWT.verify(token, process.env.ACCESS_TOKEN_KEY);
    req.user = payload;
    next();
  }
});

module.exports = { app };

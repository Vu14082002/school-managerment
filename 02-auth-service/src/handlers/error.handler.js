const { StatusCodes } = require('http-status-codes');

class CustomError extends Error {
  constructor(
    message = 'An error occurred',
    commingFrom = 'CustomError',
    status = 'error',
    statusCode = StatusCodes.INTERNAL_SERVER_ERROR
  ) {
    super(message);
    this.commingFrom = commingFrom;
    this.status = status;
    this.statusCode = statusCode;
  }
  serizalizeError() {
    return {
      message: this.message,
      status: this.status,
      statusCode: this.statusCode,
      commingFrom: this.commingFrom,
    };
  }
}
class BadRequestError extends CustomError {
  constructor(message, commingFrom = 'BadRequestError') {
    super(message, commingFrom, 'error', StatusCodes.BAD_REQUEST);
  }
}

class NotFoundError extends CustomError {
  constructor(message, commingFrom = 'NotFoundError') {
    super(message, commingFrom, 'error', StatusCodes.NOT_FOUND);
  }
}
class NotAuthorizedError extends CustomError {
  constructor(message, commingFrom = 'NotAuthorizedError') {
    super(message, commingFrom, 'error', StatusCodes.UNAUTHORIZED);
  }
}
class ForbiddenError extends CustomError {
  constructor(message, commingFrom = 'ForbiddenError') {
    super(message, commingFrom, 'error', StatusCodes.FORBIDDEN);
  }
}
class FileTooLargeError extends CustomError {
  constructor(message, commingFrom = 'FileTooLargeError') {
    super(message, commingFrom, 'error', StatusCodes.PAYLOAD_TOO_LARGE);
  }
}
class ServerError extends CustomError {
  constructor(message, commingFrom = 'ServerError') {
    super(message, commingFrom, 'error', StatusCodes.SERVICE_UNAVAILABLE);
  }
}
class ErrorNotFound extends CustomError {
  constructor(message) {
    super(message, 'ErrorNotFound', 'error', StatusCodes.NOT_FOUND);
  }
}
class ErrorBadRequest extends CustomError {
  constructor(message) {
    super(message, 'ErrorBadRequest', 'error', StatusCodes.BAD_REQUEST);
  }
}

module.exports = {
  BadRequestError,
  NotFoundError,
  NotAuthorizedError,
  ForbiddenError,
  FileTooLargeError,
  ServerError,
  ErrorNotFound,
  ErrorBadRequest,
  CustomError,
};

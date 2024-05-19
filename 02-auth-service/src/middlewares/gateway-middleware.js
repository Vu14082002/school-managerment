const JWT = require('jsonwebtoken');
const { NotAuthorizedError } = require('../handlers/error.handler');
const { authPayload, gatewayPayload } = require('../interface/payload');
require('dotenv').config();
//  service list

const commingFrom = 'api-gateway-service: verifyGatewayToken()';
const message = {
  NOT_AUTHORIZED: 'Request Not Comming From Gateway',
  INVALID_REQUEST: 'Invalid Request',
};
const tokens = ['auth', 'enrollCourse'];
const verifyGatewayToken = async (req, res, next) => {
  if (!req.headers?.gateWaytoken) {
    throw new NotAuthorizedError(message.INVALID_REQUEST, commingFrom);
  }
  const token = req.headers.gateWaytoken;
  if (!token) {
    throw new NotAuthorizedError(message.INVALID_REQUEST, commingFrom);
  }
  try {
    gatewayPayload = JWT.verify(token, '');
    if (!tokens.includes(gatewayPayload.id)) {
      throw new NotAuthorizedError(message.NOT_AUTHORIZED, commingFrom);
    }
  } catch (error) {
    throw new NotAuthorizedError(message.INVALID_REQUEST, commingFrom);
  }
};

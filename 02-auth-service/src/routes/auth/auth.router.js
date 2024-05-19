const express = require('express');
const trimRequest = require('trim-request');
const {
  loginController,
  logoutController,
  refreshTokenController,
} = require('../../controllers/auth.controller');
const authRouter = express.Router();
authRouter.get('/health', (req, res) => {
  res.status(200).json({
    mesage: 'auth service is up and running',
  });
});
authRouter.post('/login', trimRequest.all, loginController);
authRouter.post('/logout', trimRequest.all, logoutController);
authRouter.post('/refresh-token', trimRequest.all, refreshTokenController);
module.exports = { authRouter };

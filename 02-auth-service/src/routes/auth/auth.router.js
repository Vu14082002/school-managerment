const express = require('express');
const trimRequest = require('trim-request');
const {
    loginController,
    logoutController,
    refreshTokenController,
    createAuth,
} = require('../../controllers/auth.controller');
const authRouter = express.Router();

authRouter.post('/register', trimRequest.all, createAuth);
authRouter.post('/login', trimRequest.all, loginController);
authRouter.post('/logout', trimRequest.all, logoutController);
authRouter.post('/refresh-token', trimRequest.all, refreshTokenController);
module.exports = { authRouter };

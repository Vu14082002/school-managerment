const { createNewUser, loginSevice } = require('../services/auth.service');
require('dotenv').config();
const jwt = require('jsonwebtoken');
const createAuth = async (req, res, next) => {
  try {
    const { username, password, roleId } = req.body;
    const newUser = await createNewUser(username, password, roleId);
    // send queue message
    await publishDirectMessage(
      process.env.EXCHANGE_NAME_CREATE_AUTH,
      process.env.ROUTING_KEY,
      newUser
    );
    return res.status(201).json(newUser);
  } catch (error) {}
};
const loginController = async (req, res, next) => {
  try {
    const { username, password } = req.body;
    const user = await loginSevice(username, password);
    const accessToken = jwt.sign({ username }, process.env.ACCESS_TOKEN_KEY, {
      expiresIn: '14d',
    });
    const refreshToken = jwt.sign({ username }, process.env.REFRESH_TOKEN_KEY, {
      expiresIn: '30d',
    });
  } catch (error) {
    next(error);
  }
};
const logoutController = async (req, res, next) => {
  try {
  } catch (error) {
    next(error);
  }
};
const refreshTokenController = async (req, res, next) => {
  try {
  } catch (error) {
    next(error);
  }
};

module.exports = { createAuth, loginController, logoutController, refreshTokenController };

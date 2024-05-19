const { User, Role, UserRoles } = require('../models/user.model');
const { sequelize } = require('../db/maria.connection');
const { NotFoundError } = require('../handlers/error.handler');
const { publishDirectMessage } = require('../Queues/auth.producer');
require('dotenv').config();

const getAuthUserById = async (userId) => {
  const user = await User.findOne({
    where: { username: userId },
    include: Role,
  });
  return user.dataValues;
};
const createNewUser = async (username, password, role) => {
  //   begin transaction
  try {
    console.log(username, password, role);
    const transaction = await sequelize.transaction();
    const userRole = await Role.findOne({
      where: { role: role },
    });
    console.log(userRole);
    if (!userRole) {
      console.log('role not found');
    } else {
      const newUser = await User.create(
        {
          username,
          password,
        },
        { transaction }
      );
      await UserRoles.create(
        {
          username,
          role: userRole.dataValues.id,
        },
        { transaction }
      );
      await transaction.commit();
      return createNewRole.dataValues;
    }
  } catch (error) {
    await transaction.rollback();
    return error;
  }
};

// add new role table
const createNewRole = async (role) => {
  const newRole = await Role.create({
    name: role,
  });
  return newRole;
};
const loginSevice = async (username, password) => {
  try {
    const user = await User.findOne({
      where: { username, password },
    });
    return user;
  } catch (error) {
    throw new NotFoundError(`User ${username} not found`, 'auth-service');
  }
};

module.exports = { getAuthUserById, createNewUser, createNewRole, loginSevice };

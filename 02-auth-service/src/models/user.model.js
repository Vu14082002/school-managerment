const { Sequelize, DataTypes } = require('sequelize');
const { sequelize } = require('../db/maria.connection');

// Define the User model
const User = sequelize.define(
  'User',
  {
    username: {
      type: DataTypes.STRING,
      primaryKey: true,
    },
    password: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    tableName: 'user',
    timestamps: false,
  }
);

// Define the Role model
const Role = sequelize.define(
  'Role',
  {
    id: {
      type: DataTypes.INTEGER,
      autoIncrement: true,
      primaryKey: true,
    },
    role: {
      type: DataTypes.STRING,
      allowNull: false,
      unique: true,
    },
  },
  { tableName: 'role', timestamps: false }
);

// Define the UserRoles model
const UserRoles = sequelize.define(
  'UserRoles',
  {},
  {
    tableName: 'user_role',
    timestamps: false,
  }
);

// Define the many-to-many relationships between the models
User.belongsToMany(Role, {
  through: UserRoles,
  foreignKey: 'username',
  primaryKey: true,
  onDelete: 'CASCADE',
});
Role.belongsToMany(User, {
  through: UserRoles,
  foreignKey: 'role',
  primaryKey: true,
  onDelete: 'CASCADE',
});
// init data to table role

sequelize
  .sync()
  .then(async () => {
    try {
      await Role.bulkCreate([
        { role: 'ADMIN' },
        { role: 'MANAGER' },
        { role: 'LECTURER' },
        { role: 'STUDENT' },
      ]);
      console.log('Role data initialized');
    } catch (error) {
      console.error('Error initializing role data:', error);
    }
  })
  .catch((error) => {
    console.error('Error synchronizing database:', error);
  });

module.exports = { User, Role, UserRoles };

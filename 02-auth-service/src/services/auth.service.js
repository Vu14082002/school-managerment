const { User, Role, UserRoles } = require('../models/user.model');
const { sequelize } = require('../db/maria.connection');
const {
    NotFoundError,
    NotAuthorizedError,
    BadRequestError,
    ConflictError,
} = require('../handlers/error.handler');
const bcrypt = require('bcrypt');

const getAuthUserById = async (userId) => {
    const user = await User.findOne({
        where: { username: userId },
        include: Role,
    });
    return user.dataValues;
};

const createNewUser = async ({ username, password, role }) => {
    if (!username || !password || !role)
        throw new BadRequestError('Username, password and role are required');

    const saltRounds = parseInt(process.env.SALT_ROUNDS, 10);
    if (isNaN(saltRounds)) throw new Error('Invalid salt rounds');

    let transaction = null;
    try {
        transaction = await sequelize.transaction();

        const userRole = await Role.findOne({ where: { role } });
        if (!userRole)
            throw new NotFoundError(`Role ${role} not found`, 'auth-service');

        const hashPassword = await bcrypt.hash(password, saltRounds);

        const newUser = await User.create(
            {
                username,
                password: hashPassword,
            },
            { transaction },
        );

        await UserRoles.create(
            {
                username,
                role: userRole.dataValues.id,
            },
            { transaction },
        );

        await transaction.commit();
        return newUser.dataValues;
    } catch (error) {
        if (transaction) await transaction.rollback();

        if (error.name === 'SequelizeUniqueConstraintError')
            throw new ConflictError('Username already exists');

        throw error;
    }
};

// add new role table
const createNewRole = async (role) => {
    const newRole = await Role.create({
        name: role,
    });
    return newRole;
};

const loginService = async ({ username, password }) => {
    if (!username || !password)
        throw new BadRequestError('Username and password are required');

    try {
        const [user, userRoles] = await Promise.all([
            User.findOne({ where: { username } }),
            UserRoles.findAll({ where: { username } }),
        ]);

        if (!user) {
            throw new NotFoundError(
                `User ${username} not found`,
                'auth-service',
            );
        }

        const userData = user.dataValues;
        const comparePassword = await bcrypt.compare(
            password,
            userData.password,
        );

        if (!comparePassword)
            throw new NotAuthorizedError(
                'Invalid username or password',
                'auth-service',
            );

        const roleIds = userRoles.map((userRole) => userRole.role);

        const roles = await Role.findAll({
            where: { id: roleIds },
        });

        return {
            username,
            roles: roles.map((r) => r.dataValues.role),
        };
    } catch (error) {
        console.error('Error in loginService:', error);
        throw error;
    }
};

module.exports = {
    getAuthUserById,
    createNewUser,
    createNewRole,
    loginService,
};

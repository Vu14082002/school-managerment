const { publishDirectMessage } = require('../Queues/auth.producer');
const { createNewUser, loginService } = require('../services/auth.service');
const jwt = require('jsonwebtoken');
const createAuth = async (req, res, next) => {
    const { username, password, roleId } = req.body;

    try {
        const newUser = await createNewUser({
            username,
            password,
            role: roleId,
        });

        await publishDirectMessage(
            process.env.EXCHANGE_NAME_CREATE_AUTH,
            process.env.ROUTING_KEY,
            newUser,
        );

        return res.status(201).json(newUser);
    } catch (error) {
        next(error);
    }
};
const loginController = async (req, res, next) => {
    try {
        const { username, password } = req.body;

        const user = await loginService({ username, password });
        const accessToken = jwt.sign(
            { username },
            process.env.ACCESS_TOKEN_KEY,
            {
                expiresIn: '14d',
            },
        );
        const refreshToken = jwt.sign(
            { username },
            process.env.REFRESH_TOKEN_KEY,
            {
                expiresIn: '30d',
            },
        );

        res.cookie('refreshToken', refreshToken, {
            httpOnly: true,
            secure: true,
            sameSite: 'Strict',
            path: '/api/v1/auth/refresh-token',
        });

        return res.status(200).json({
            status: 'success',
            message: 'User logged in successfully',
            data: {
                user,
                accessToken,
            },
        });
    } catch (error) {
        next(error);
    }
};
const logoutController = async (_req, res, next) => {
    try {
        res.clearCookie('refreshToken', {
            path: '/api/v1/auth/refresh-token',
        });
        res.json({ status: 'success', message: 'Logged out successfully.' });
    } catch (error) {
        next(error);
    }
};
const refreshTokenController = async (req, res, next) => {
    try {
        const refreshToken = req.cookies.refreshToken;

        if (!refreshToken) {
            return res.status(403).json({
                status: 'error',
                message: 'Refresh token is missing.',
            });
        }

        jwt.verify(refreshToken, process.env.REFRESH_TOKEN_KEY, (err, user) => {
            if (err) {
                return res.status(403).json({
                    status: 'error',
                    message: 'Refresh token is invalid or expired.',
                });
            }

            const newAccessToken = jwt.sign(
                { username: user.username },
                process.env.ACCESS_TOKEN_KEY,
                {
                    expiresIn: '14d',
                },
            );

            res.json({
                status: 'success',
                message: 'Token refreshed successfully.',
                data: {
                    accessToken: newAccessToken,
                },
            });
        });
    } catch (error) {
        next(error);
    }
};

module.exports = {
    createAuth,
    loginController,
    logoutController,
    refreshTokenController,
};

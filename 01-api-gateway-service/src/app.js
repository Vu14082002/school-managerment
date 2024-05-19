const express = require('express');
require('dotenv').config();
const morgan = require('morgan');
const helmet = require('helmet');
const cors = require('cors');
const mongoSanitize = require('express-mongo-sanitize');
const cookieParser = require('cookie-parser');
const compression = require('compression');
const { StatusCodes } = require('http-status-codes');
const axios = require('axios');

const app = express();

// Middlewares
app.use(morgan('common'));
app.use(helmet());
app.use(cors({ origin: '*' }));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(mongoSanitize());
app.use(cookieParser());
app.use(compression());

// Environment variables
const AUTH_BASE_URL = process.env.AUTH_BASE_URL;
const STUDENT_URL = process.env.STUDENT_URL;
const LECTURER_URL = process.env.LECTURER_URL;
const SUBJECT_URL = process.env.SUBJECT_URL;

// API Gateway health check
app.get('/health', async (req, res) => {
  res.status(200).json({ message: 'API Gateway Service is running' });
});

// Auth service routes
app.get('/api/v1/auth/health', async (req, res) => {
  try {
    const response = await axios.get(`${AUTH_BASE_URL}/api/v1/auth/health`);
    res.status(response.status).json(response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
    res.status(error.response?.status || 500).json({ error: 'Auth service is not running' });
  }
});

app.post('/api/v1/auth/login', async (req, res) => {
  try {
    const { username, password } = req.body;
    const response = await axios.post(`${AUTH_BASE_URL}/api/v1/auth/login`, { username, password });
    res.status(response.status).json(response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
    res.status(error.response?.status || 500).json({ error: 'Auth service is not running' });
  }
});

// Student service routes
const studentsApi = '/api/v1/students-service';
app.get(studentsApi + '/health', async (req, res) => {
  try {
    const response = await axios.get(`${STUDENT_URL}${studentsApi}/health`);
    res.status(response.status).json(response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
    res.status(error.response?.status || 500).json({ error: 'Student service is not running' });
  }
});

app.post(studentsApi, async (req, res) => {
  try {
    const response = await axios.post(`${STUDENT_URL}${studentsApi}`, req.body);
    res.status(response.status).json(response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
    res.status(error.response?.status || 500).json({ error: 'Student service is not running' });
  }
});

// Lecturer service routes
const lecturersApi = '/api/v1/lecturer-service';
app.get(lecturersApi + '/health', async (req, res) => {
  try {
    const response = await axios.get(`${LECTURER_URL}${lecturersApi}/health`);
    res.status(response.status).json(response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
    res.status(error.response?.status || 500).json({ error: 'Lecturer service is not running' });
  }
});

app.post(lecturersApi, async (req, res) => {
  try {
    const response = await axios.post(`${LECTURER_URL}${lecturersApi}`, req.body);
    res.status(response.status).json(response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
    res.status(error.response?.status || 500).json({ error: 'Lecturer service is not running' });
  }
});

// Error handling for unmatched routes
app.use('*', (req, res) => {
  const fullUrl = req.protocol + '://' + req.get('host') + req.originalUrl;
  res.status(StatusCodes.NOT_FOUND).json({ message: `Requested URL ${fullUrl} Not Found` });
});

module.exports = { app };

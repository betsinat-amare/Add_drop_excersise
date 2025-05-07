// src/server.ts
import express from 'express';
import cors from 'cors';
import dotenv from 'dotenv';
import bodyParser from 'body-parser';

import authRoutes from '../routes/auth'; // Import auth routes
import courseRoutes from '../routes/courses';
import addRoutes from '../routes/adds';
import dropRoutes from '../routes/drops';

dotenv.config();

const app = express();

// Middleware setup
app.use(cors());
app.use(express.json()); // Automatically parses JSON request bodies
app.use(bodyParser.json()); // Optional, if you prefer bodyParser

// Route setup
app.use('/api/auth', authRoutes); // Auth routes (login, logout, admin)
app.use('/api/courses', courseRoutes); // Courses route
app.use('/api/adds', addRoutes); // Add course route
app.use('/api/drops', dropRoutes); // Drop course route

// Global error handler
app.use((err: Error, req: express.Request, res: express.Response, next: express.NextFunction) => {
  console.error(err.stack);
  res.status(500).json({ error: 'Internal server error' });
});

// Start the server
const PORT: number = parseInt(process.env.PORT as string, 10) || 5000;
app.listen(PORT, () => {
  console.log(`✅ Server running on http://localhost:${PORT}`);
});

export default app; // Export for testing purposes
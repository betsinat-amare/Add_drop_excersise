import express, { Request, Response } from 'express';
import jwt from 'jsonwebtoken';
import dotenv from 'dotenv';

dotenv.config();

const router = express.Router();

// Dummy login route — replace with real DB check later
router.post('/login', (req: Request, res: Response) => {
  console.log("Incoming body:", req.body);

  const { id, password } = req.body;

  if (!id || !password) {
    return res.status(400).json({ error: 'ID and password are required' });
  }

  // Hardcoded dummy user (for testing only)
  if (id === 'student123' && password === 'password123') {
    const token = jwt.sign(
      { id, role: 'student' },
      process.env.JWT_SECRET!,
      { expiresIn: '1h' }
    );

    return res.status(200).json({
      message: 'Login successful',
      token,
    });
  }

  return res.status(401).json({ error: 'Invalid ID or password' });
});

// Stateless logout — just notify client to delete token
router.post('/logout', (req: Request, res: Response) => {
  try {
    res.status(200).json({
      message: 'Logout successful.',
    });
  } catch (err) {
    console.error('Logout error:', err);
    res.status(500).json({ error: 'Internal server error' });
  }
});

export default router;

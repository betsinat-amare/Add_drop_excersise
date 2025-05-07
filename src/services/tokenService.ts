import jwt from 'jsonwebtoken';
import { TokenBlacklistService } from '../db/blacklist';

interface JwtPayload {
  id: number;
  role: string;
  exp: number;
}

export const TokenService = {
  generateToken: (payload: Omit<JwtPayload, 'exp'>): string => {
    return jwt.sign(payload, process.env.JWT_SECRET!, { expiresIn: '1h' });
  },

  verifyToken: async (token: string): Promise<JwtPayload> => {
    if (await TokenBlacklistService.isBlacklisted(token)) {
      throw new Error('Token revoked');
    }
    return jwt.verify(token, process.env.JWT_SECRET!) as JwtPayload;
  },

  revokeToken: async (token: string): Promise<void> => {
    const decoded = jwt.decode(token) as JwtPayload;
    await TokenBlacklistService.addToBlacklist(token, decoded.exp * 1000);
  }
};
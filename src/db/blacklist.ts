import { Database } from 'sqlite3';

const db = new Database('college.db');

interface BlacklistService {
  addToBlacklist(token: string, expiresAt: number): Promise<void>;
  isBlacklisted(token: string): Promise<boolean>;
}

export const TokenBlacklistService: BlacklistService = {
  addToBlacklist: (token, expiresAt) => {
    return new Promise((resolve, reject) => {
      db.run(
        'INSERT INTO token_blacklist (token, expires_at) VALUES (?, ?)',
        [token, expiresAt],
        (err) => (err ? reject(err) : resolve())
      );
    });
  },

  isBlacklisted: (token) => {
    return new Promise((resolve) => {
      db.get(
        'SELECT 1 FROM token_blacklist WHERE token = ?',
        [token],
        (err, row) => resolve(!!row)
      );
    });
  }
};
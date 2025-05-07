import { Database } from 'sqlite3';
const db = new Database('college.db');

export class TokenBlacklist {
  static async addToken(token: string, expiresAt: number): Promise<void> {
    return new Promise((resolve, reject) => {
      db.run(
        'INSERT INTO token_blacklist (token, expires_at) VALUES (?, ?)',
        [token, expiresAt],
        (err) => {
          if (err) return reject(err);
          resolve();
        }
      );
    });
  }

  static async isTokenBlacklisted(token: string): Promise<boolean> {
    return new Promise((resolve, reject) => {
      db.get(
        'SELECT 1 FROM token_blacklist WHERE token = ?',
        [token],
        (err, row) => {
          if (err) return reject(err);
          resolve(!!row);
        }
      );
    });
  }

  static async cleanupExpiredTokens(): Promise<void> {
    const now = Date.now();
    return new Promise((resolve, reject) => {
      db.run(
        'DELETE FROM token_blacklist WHERE expires_at < ?',
        [now],
        (err) => {
          if (err) return reject(err);
          resolve();
        }
      );
    });
  }
}
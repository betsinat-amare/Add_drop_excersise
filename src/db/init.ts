import sqlite3 from 'sqlite3';
import bcrypt from 'bcrypt';

const db = new sqlite3.Database('./college.db');

db.serialize(() => {
    db.run(`
        CREATE TABLE IF NOT EXISTS users (
            id INTEGER PRIMARY KEY,
            full_name TEXT NOT NULL,
            username TEXT NOT NULL UNIQUE,
            password TEXT NOT NULL,
            role TEXT NOT NULL CHECK(role IN ('Student', 'Registrar')),
            email TEXT NOT NULL UNIQUE,
            profile_photo TEXT
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS ids (
            id INTEGER PRIMARY KEY,
            role TEXT NOT NULL CHECK(role IN ('Student', 'Registrar')),
            assigned INTEGER NOT NULL DEFAULT 0 CHECK(assigned IN (0, 1))
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS courses (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL,
            code TEXT NOT NULL UNIQUE,
            description TEXT,
            credit_hours INTEGER NOT NULL
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS adds (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            student_id INTEGER NOT NULL,
            course_id INTEGER NOT NULL,
            approval_status TEXT NOT NULL CHECK(approval_status IN ('pending', 'approved', 'rejected')),
            added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY (student_id) REFERENCES users(id),
            FOREIGN KEY (course_id) REFERENCES courses(id)
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS drops (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            add_id INTEGER NOT NULL,
            student_id INTEGER NOT NULL,
            course_id INTEGER NOT NULL,
            approval_status TEXT NOT NULL CHECK(approval_status IN ('pending', 'approved', 'rejected')),
            dropped_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY (add_id) REFERENCES adds(id),
            FOREIGN KEY (student_id) REFERENCES users(id),
            FOREIGN KEY (course_id) REFERENCES courses(id)
        )
    `);

    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [1, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [2, 'Registrar', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [3, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [4, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [5, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [6, 'Registrar', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [7, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [8, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [9, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [10, 'Registrar', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [11, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [12, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [13, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [14, 'Registrar', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [15, 'Student', 0]);
    db.run('INSERT OR IGNORE INTO ids (id, role, assigned) VALUES (?, ?, ?)', [16, 'Student', 0]);

    const hashedPassword = bcrypt.hashSync('password123', 10);
    db.run(
        'INSERT OR IGNORE INTO users (id, full_name, username, password, role, email, profile_photo) VALUES (?, ?, ?, ?, ?, ?, ?)',
        [1, 'Test Student', 'teststudent', hashedPassword, 'Student', 'teststudent@example.com', null]
    );
    db.run(
        'INSERT OR IGNORE INTO users (id, full_name, username, password, role, email, profile_photo) VALUES (?, ?, ?, ?, ?, ?, ?)',
        [2, 'Test Registrar', 'testregistrar', hashedPassword, 'Registrar', 'testregistrar@example.com', null]
    );

    db.run('INSERT OR IGNORE INTO courses (id, title, code, description, credit_hours) VALUES (?, ?, ?, ?, ?)', 
        [1, 'Course 1', 'C101', 'Description 1', 10]);
    db.run('INSERT OR IGNORE INTO courses (id, title, code, description, credit_hours) VALUES (?, ?, ?, ?, ?)', 
        [2, 'Course 2', 'C102', 'Description 2', 20]);
});

db.close();
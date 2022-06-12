CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(16) NOT NULL
);

CREATE TABLE IF NOT EXISTS weeks (
    id INT PRIMARY KEY NOT NULL,
    num_of_week INT NOT NULL,
    num_of_year INT,
    title VARCHAR(50) NOT NULL DEFAULT '',
    color INT[4] NOT NULL DEFAULT '{0, 255, 255, 255}',
    text TEXT NOT NULL DEFAULT ''
);

CREATE TABLE IF NOT EXISTS calendars (
    id INT PRIMARY KEY NOT NULL,
    week_fk INT REFERENCES weeks(id),
    user_fk INT REFERENCES users(id)
);
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

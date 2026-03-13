CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author_name VARCHAR(10) NOT NULL,
    password VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    view_count INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE TABLE author (
    id serial PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO author (name, email) VALUES ('Carlos Barbosa','cbgomes@gmail.com');
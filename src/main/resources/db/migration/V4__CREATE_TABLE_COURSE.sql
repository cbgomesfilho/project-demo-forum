CREATE TABLE course (
    id serial PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    category VARCHAR(200) NOT NULL
);

INSERT INTO course (name, category) VALUES ('KOTLIN', 'Programming');
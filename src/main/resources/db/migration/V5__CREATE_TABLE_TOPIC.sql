CREATE TABLE topic (
    id serial PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    message VARCHAR (200) NOT NULL,
    createAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NOT NULL,
    status VARCHAR(200) NOT NULL,
    course_id serial NOT NULL,
    author_id serial NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id),
    FOREIGN KEY (author_id) REFERENCES author(id)
);

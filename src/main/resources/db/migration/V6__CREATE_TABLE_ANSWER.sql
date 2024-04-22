CREATE TABLE answer (
  id serial PRIMARY KEY,
  message VARCHAR(400) NOT NULL,
  createAt TIMESTAMP NOT NULL,
  isSortedOut BOOLEAN NOT NULL,
  author_id serial NOT NULL,
  topic_id serial NOT NULL,
  FOREIGN KEY (author_id) REFERENCES author(id),
  FOREIGN KEY (topic_id) REFERENCES topic(id)
);
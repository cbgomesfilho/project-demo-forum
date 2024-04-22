CREATE TABLE users (
    id serial PRIMARY KEY,
    username VARCHAR (50) NOT NULL,
    firstname VARCHAR (50) NOT NULL,
    lastname VARCHAR (50) NOT NULL,
    email VARCHAR (200) NOT NULL,
    password VARCHAR (100) NOT NULL

);

INSERT INTO users (id,username, firstname, lastname, email, password)
VALUES (1,'cbgomes@gmail.com', 'Carlos','Barbosa','cbgomes@gmail.com','$2a$04$yPC3BO4dDAW.dunTnzxJ6.JVfmZiVqcbwrJSFjyGTR0G.WIgLwrse');
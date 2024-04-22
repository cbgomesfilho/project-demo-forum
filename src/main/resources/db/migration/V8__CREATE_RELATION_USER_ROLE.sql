CREATE TABLE roles_users (
    id serial PRIMARY KEY ,
    id_user serial NOT NULL ,
    id_role serial NOT NULL ,
    FOREIGN KEY (id_user) REFERENCES users (id),
    FOREIGN KEY (id_role) REFERENCES roles (id)
);
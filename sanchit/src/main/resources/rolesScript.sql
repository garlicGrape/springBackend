INSERT INTO roles(name) values('ROLE_USER')
INSERT INTO roles(name) values('ROLE_MODERATOR')
INSERT INTO roles(name) values('ROLE_ADMIN')

CREATE TABLE users(
	id serial PRIMARY KEY,
	email varchar(255),
	userpassword varchar(255),
	username varchar(255)
);

INSERT INTO users(email,userpassword,username) VALUES('test@test.com','dog','Zelda');
INSERT INTO users(email,userpassword,username) VALUES('test2@test.com','aligator','lizard');

DROP TABLE users CASCADE;

SELECT * FROM users; 
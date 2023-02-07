INSERT INTO roles(id,name) values(0,'ROLE_USER');   --ROLE_USER must be set to ID value 0
INSERT INTO roles(id,name) values(1,'ROLE_MODERATOR');
INSERT INTO roles(id,name) values(2,'ROLE_ADMIN');

Truncate table roles CASCADE;

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

SELECT * FROM roles;